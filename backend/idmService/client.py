import grpc
from protos import auth_pb2, auth_pb2_grpc

def run():
    channel = grpc.insecure_channel("localhost:50051")
    stub = auth_pb2_grpc.AuthServiceStub(channel)

    print("Sending register request...")
    response = stub.Login(auth_pb2.LoginRequest(
        username="testuser",
        password="secret",
    ))

    print("Response:")
    print(response)

if __name__ == "__main__":
    run()
