# server.py
import grpc
from concurrent import futures
import time
import os
import hashlib
import jwt
import datetime
from dotenv import load_dotenv
import protos.auth_pb2 as auth_pb2
import protos.auth_pb2_grpc as auth_pb2_grpc
from sqlalchemy.orm import Session
from config.database import SessionLocal, engine
from models.user import User, UserRole,Base
from config.settings import get_settings
# type: ignore - SQLAlchemy type hints

load_dotenv()
settings = get_settings()

Base.metadata.create_all(bind=engine)

class AuthService(auth_pb2_grpc.AuthServiceServicer):

    def __init__(self):
        self.blocklist = set()
        self.jwt_secret = settings.jwt_secret if hasattr(settings, 'jwt_secret') else os.getenv("JWT_SECRET")

    def Register(self, request, context):
        db: Session = SessionLocal()
        try:
            existing_user = db.query(User).filter(
                (User.username == request.username) | (User.email == request.email)
            ).first()
            
            if existing_user:
                return auth_pb2.RegisterResponse(#type: ignore
                    success=False, 
                    message="User already exists",
                    user_id=0
                )
            
            hashed_password = hashlib.sha256(request.password.encode()).hexdigest()
            
            new_user = User(
                username=request.username,
                email=request.email,
                password_hash=hashed_password, 
                role=UserRole.STUDENT
            )
            
            db.add(new_user)
            db.commit()
            db.refresh(new_user) 

            print(f"User registered: {new_user.username} with ID: {new_user.id}")
            
            return auth_pb2.RegisterResponse(#type: ignore
                success=True, 
                message="User registered successfully",
                user_id=new_user.id
            )
            
        except Exception as e:
            db.rollback()
            print(f"Registration error: {str(e)}")
            return auth_pb2.RegisterResponse(#type: ignore
                success=False,
                message=f"Registration failed: {str(e)}",
                user_id=0
            )
        finally:
            db.close()

    def Login(self, request, context):
        db: Session = SessionLocal()
        try:
            user = db.query(User).filter(User.username == request.username).first()
            
            if not user:
                return auth_pb2.LoginResponse(#type: ignore
                    token="", 
                    error="Invalid credentials",
                    user_id=0
                )#type: ignore
            
            hashed_password = hashlib.sha256(request.password.encode()).hexdigest()
            if user.password_hash != hashed_password:
                return auth_pb2.LoginResponse(#type: ignore
                    token="", 
                    error="Invalid credentials",
                    user_id=0
                )
            
            payload = {
                "user_id": user.id,
                "username": user.username,
                "email": user.email,
                "role": user.role.value if isinstance(user.role, UserRole) else user.role,  # ← FIX
                "exp": datetime.datetime.now(datetime.UTC) + datetime.timedelta(hours=1)
            }
            
            token = jwt.encode(payload, self.jwt_secret, algorithm="HS256")
            
            print(f"User logged in: {user.username} (ID: {user.id})")
            
            return auth_pb2.LoginResponse(#type: ignore
                token=token, 
                error="",
                user_id=user.id
            )
            
        except Exception as e:
            print(f"Login error: {str(e)}")
            return auth_pb2.LoginResponse(#type: ignore
                token="",
                error=f"Login failed: {str(e)}",
                user_id=0
            )
        finally:
            db.close()

    def ValidateToken(self, request, context):
        if request.token in self.blocklist:
            return auth_pb2.ValidateResponse(#type: ignore
                valid=False, 
                error="Token invalidated",
                user_id=0,
                username="",
                role=""
            )
        try:
            decoded = jwt.decode(request.token, self.jwt_secret, algorithms=["HS256"])
            return auth_pb2.ValidateResponse(#type: ignore
                valid=True, 
                error="",
                user_id=decoded.get("user_id", 0),
                username=decoded.get("username", ""),
                role=decoded.get("role", "")
            )
        except jwt.ExpiredSignatureError:
            return auth_pb2.ValidateResponse(#type: ignore
                valid=False, error="Token expired", user_id=0, username="", role=""
            )
        except jwt.InvalidTokenError:
            return auth_pb2.ValidateResponse(#type: ignore
                valid=False, error="Invalid token", user_id=0, username="", role=""
            )
    
    def InvalidateToken(self, request, context):
        self.blocklist.add(request.token)
        return auth_pb2.InvalidateResponse(#type: ignore
            success=True
        )

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    auth_pb2_grpc.add_AuthServiceServicer_to_server(AuthService(), server)
    server.add_insecure_port('[::]:50051')
    print("gRPC Server started on port 50051")
    print(f"Connected to database: {settings.database_url}")
    server.start()
    try:
        while True:
            time.sleep(86400)
    except KeyboardInterrupt:
        print("\nShutting down server...")
        server.stop(0)

if __name__ == '__main__':
    serve()