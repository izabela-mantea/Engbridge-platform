import grpc
import protos.auth_pb2 as auth_pb2
import protos.auth_pb2_grpc as auth_pb2_grpc

def run():
    
    with grpc.insecure_channel('localhost:50051') as channel:
        stub = auth_pb2_grpc.AuthServiceStub(channel)

        response = stub.Register(auth_pb2.RegisterRequest( #type: ignore
            username="newuser",
            password="newpassword",
            email="newuser@example.com",
            role="user"
            ))
        print(f"Register Success: {response.success}, Message: {response.message}")

        response = stub.Login(auth_pb2.LoginRequest( #type: ignore
            username="newuser",
            password="newpassword"
        ))
        if response.token:
            print(f"Login Successful. Token: {response.token}")
            token = response.token
        else:
            print(f"Login Failed: {response.error}")
            return

        response = stub.ValidateToken(auth_pb2.ValidateRequest(token=token)) #type: ignore
        print(f"Token Valid: {response.valid}, Error: {response.error}")
        print(f"User ID: {response.user_id}")

        response = stub.ValidateToken(auth_pb2.ValidateRequest(token="invalidtoken")) #type: ignore
        print(f"Token Valid: {response.valid}, Error: {response.error}")

        response = stub.InvalidateToken(auth_pb2.InvalidateRequest(token=token)) #type: ignore
        print(f"Token Invalidated: {response.success}, Error: {response.error}")

if __name__ == '__main__':
    run()
