import grpc
from concurrent import futures
from  protos.auth_pb2 import *
import protos.auth_pb2_grpc

from sqlalchemy.orm import Session
from config.database import SessionLocal
from models import User, InvalidToken
import bcrypt
import datetime
import uuid
import jwt
from jwt import ExpiredSignatureError, InvalidTokenError
from config.database import settings

print("SERVER SETTINGS DB URL:", settings.database_url)
print("MYSQL_USER:", settings.mysql_user)
print("MYSQL_PASSWORD:", settings.mysql_password)
print("Database URL:", settings.database_url)
SECRET_KEY = "$s%w!2#44r@q1&z7e(8u9o0p"
ALGORITHM = "HS256"
SERVICE_URL = settings.idm_service_url
class AuthService(protos.auth_pb2_grpc.AuthServiceServicer):
    
    def __init__(self):
        self.blacklist = set() 
    
    def Register(self, request, context):
        db: Session=SessionLocal()
        try:
            exist=db.query(User).filter(User.username==request.username).first()
            if exist:
                return protos.auth_pb2.RegisterResponse(
                    success=False,
                    message="Username or email already exists."
                )
            
            hashed_password = bcrypt.hashpw(
                request.password.encode('utf-8'), 
                bcrypt.gensalt()
            ).decode('utf-8')
            new_user = User(
                username=request.username,
                email=request.email,
                password_hash=hashed_password,
                role=request.role
            )
            db.add(new_user)
            db.commit()

            return protos.auth_pb2.RegisterResponse(
                success=True,
                message=f"User {request.username} registered successfully."
            )
        except Exception as e:
            db.rollback()
            return protos.auth_pb2.RegisterResponse(
                success=False,
                message=f"Error: {str(e)}"
            )
        finally:
            db.close()

    
    def Login(self, request, context):
        db: Session=SessionLocal()
        try:    
            exist=db.query(User).filter(User.username==request.username).first()
            if not exist:
                return protos.auth_pb2.LoginResponse(
                    token="",
                    error="Invalid username or password."
                )
            if not bcrypt.checkpw(request.password.encode('utf-8'), exist.password_hash.encode('utf-8')):
                return protos.auth_pb2.LoginResponse(
                    token="",
                    error="Invalid username or password."
                )
            header={
                "alg": ALGORITHM,
                "typ": "JWT"
                }
            payload = {
                "iss": SERVICE_URL,             
                "sub": str(exist.id),            
                "exp": datetime.datetime.now() + datetime.timedelta(hours=1),  
                "jti": str(uuid.uuid4()),       
                "role": exist.role              
            }

            token = jwt.encode(headers=header, payload=payload, key=SECRET_KEY, algorithm=ALGORITHM)

            return protos.auth_pb2.LoginResponse(
                token=token,
                error=""
            )
        finally:
            db.close()

    def ValidateToken(self, request, context):
        token_str = request.token

        if token_str in self.blacklist:
            return protos.auth_pb2.ValidateResponse(
                valid=False, #succes....ar trebui sa fie true?
                userId="",
                role="",
                error="Token is blacklisted"
            )

        try:
            payload = jwt.decode(token_str, SECRET_KEY, algorithms=[ALGORITHM])

            return protos.auth_pb2.ValidateResponse(
                valid=True,
                userId=payload.get("sub", ""),
                role=str(payload.get("role", "")),
                error=""
            )
        except ExpiredSignatureError:
            self.blacklist.add(token_str)
            return protos.auth_pb2.ValidateResponse(
                valid=False, #succes....ar trebui sa fie true?
                userId="",
                role="",
                error="Token has expired"
            )
        except InvalidTokenError:
            self.blacklist.add(token_str)
            return protos.auth_pb2.ValidateResponse(
                valid=False, #succes....ar trebui sa fie true?
                userId="",
                role="",
                error="Invalid token"
            )


    def InvalidateToken(self, request, context):
        token_str = request.token
        self.blacklist.add(token_str)

        return protos.auth_pb2.InvalidateResponse(
            success=True,
            message="Token invalidated successfully",
            error=""
        )


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    protos.auth_pb2_grpc.add_AuthServiceServicer_to_server(AuthService(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    print("Server started on port 50051")
    server.wait_for_termination()

if __name__ == "__main__":
    serve()
