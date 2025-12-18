package com.engbridge.auth.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: auth.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthServiceGrpc {

  private AuthServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "auth.AuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.engbridge.auth.grpc.RegisterRequest,
      com.engbridge.auth.grpc.RegisterResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Register",
      requestType = com.engbridge.auth.grpc.RegisterRequest.class,
      responseType = com.engbridge.auth.grpc.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.engbridge.auth.grpc.RegisterRequest,
      com.engbridge.auth.grpc.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<com.engbridge.auth.grpc.RegisterRequest, com.engbridge.auth.grpc.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = AuthServiceGrpc.getRegisterMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getRegisterMethod = AuthServiceGrpc.getRegisterMethod) == null) {
          AuthServiceGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<com.engbridge.auth.grpc.RegisterRequest, com.engbridge.auth.grpc.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.RegisterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Register"))
              .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.engbridge.auth.grpc.LoginRequest,
      com.engbridge.auth.grpc.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = com.engbridge.auth.grpc.LoginRequest.class,
      responseType = com.engbridge.auth.grpc.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.engbridge.auth.grpc.LoginRequest,
      com.engbridge.auth.grpc.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.engbridge.auth.grpc.LoginRequest, com.engbridge.auth.grpc.LoginResponse> getLoginMethod;
    if ((getLoginMethod = AuthServiceGrpc.getLoginMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getLoginMethod = AuthServiceGrpc.getLoginMethod) == null) {
          AuthServiceGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<com.engbridge.auth.grpc.LoginRequest, com.engbridge.auth.grpc.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.engbridge.auth.grpc.ValidateRequest,
      com.engbridge.auth.grpc.ValidateResponse> getValidateTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateToken",
      requestType = com.engbridge.auth.grpc.ValidateRequest.class,
      responseType = com.engbridge.auth.grpc.ValidateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.engbridge.auth.grpc.ValidateRequest,
      com.engbridge.auth.grpc.ValidateResponse> getValidateTokenMethod() {
    io.grpc.MethodDescriptor<com.engbridge.auth.grpc.ValidateRequest, com.engbridge.auth.grpc.ValidateResponse> getValidateTokenMethod;
    if ((getValidateTokenMethod = AuthServiceGrpc.getValidateTokenMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getValidateTokenMethod = AuthServiceGrpc.getValidateTokenMethod) == null) {
          AuthServiceGrpc.getValidateTokenMethod = getValidateTokenMethod =
              io.grpc.MethodDescriptor.<com.engbridge.auth.grpc.ValidateRequest, com.engbridge.auth.grpc.ValidateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.ValidateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.ValidateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("ValidateToken"))
              .build();
        }
      }
    }
    return getValidateTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.engbridge.auth.grpc.InvalidateRequest,
      com.engbridge.auth.grpc.InvalidateResponse> getInvalidateTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InvalidateToken",
      requestType = com.engbridge.auth.grpc.InvalidateRequest.class,
      responseType = com.engbridge.auth.grpc.InvalidateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.engbridge.auth.grpc.InvalidateRequest,
      com.engbridge.auth.grpc.InvalidateResponse> getInvalidateTokenMethod() {
    io.grpc.MethodDescriptor<com.engbridge.auth.grpc.InvalidateRequest, com.engbridge.auth.grpc.InvalidateResponse> getInvalidateTokenMethod;
    if ((getInvalidateTokenMethod = AuthServiceGrpc.getInvalidateTokenMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getInvalidateTokenMethod = AuthServiceGrpc.getInvalidateTokenMethod) == null) {
          AuthServiceGrpc.getInvalidateTokenMethod = getInvalidateTokenMethod =
              io.grpc.MethodDescriptor.<com.engbridge.auth.grpc.InvalidateRequest, com.engbridge.auth.grpc.InvalidateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InvalidateToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.InvalidateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.InvalidateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("InvalidateToken"))
              .build();
        }
      }
    }
    return getInvalidateTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.engbridge.auth.grpc.CreateUserRequest,
      com.engbridge.auth.grpc.CreateUserResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = com.engbridge.auth.grpc.CreateUserRequest.class,
      responseType = com.engbridge.auth.grpc.CreateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.engbridge.auth.grpc.CreateUserRequest,
      com.engbridge.auth.grpc.CreateUserResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<com.engbridge.auth.grpc.CreateUserRequest, com.engbridge.auth.grpc.CreateUserResponse> getCreateUserMethod;
    if ((getCreateUserMethod = AuthServiceGrpc.getCreateUserMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getCreateUserMethod = AuthServiceGrpc.getCreateUserMethod) == null) {
          AuthServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<com.engbridge.auth.grpc.CreateUserRequest, com.engbridge.auth.grpc.CreateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.CreateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.CreateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.engbridge.auth.grpc.UpdateRequest,
      com.engbridge.auth.grpc.UpdateResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.engbridge.auth.grpc.UpdateRequest.class,
      responseType = com.engbridge.auth.grpc.UpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.engbridge.auth.grpc.UpdateRequest,
      com.engbridge.auth.grpc.UpdateResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.engbridge.auth.grpc.UpdateRequest, com.engbridge.auth.grpc.UpdateResponse> getUpdateMethod;
    if ((getUpdateMethod = AuthServiceGrpc.getUpdateMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getUpdateMethod = AuthServiceGrpc.getUpdateMethod) == null) {
          AuthServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<com.engbridge.auth.grpc.UpdateRequest, com.engbridge.auth.grpc.UpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.UpdateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Update"))
              .build();
        }
      }
    }
    return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.engbridge.auth.grpc.DeleteRequest,
      com.engbridge.auth.grpc.DeleteResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.engbridge.auth.grpc.DeleteRequest.class,
      responseType = com.engbridge.auth.grpc.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.engbridge.auth.grpc.DeleteRequest,
      com.engbridge.auth.grpc.DeleteResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.engbridge.auth.grpc.DeleteRequest, com.engbridge.auth.grpc.DeleteResponse> getDeleteMethod;
    if ((getDeleteMethod = AuthServiceGrpc.getDeleteMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getDeleteMethod = AuthServiceGrpc.getDeleteMethod) == null) {
          AuthServiceGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<com.engbridge.auth.grpc.DeleteRequest, com.engbridge.auth.grpc.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.DeleteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.engbridge.auth.grpc.Empty,
      com.engbridge.auth.grpc.UserList> getGetAllUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllUsers",
      requestType = com.engbridge.auth.grpc.Empty.class,
      responseType = com.engbridge.auth.grpc.UserList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.engbridge.auth.grpc.Empty,
      com.engbridge.auth.grpc.UserList> getGetAllUsersMethod() {
    io.grpc.MethodDescriptor<com.engbridge.auth.grpc.Empty, com.engbridge.auth.grpc.UserList> getGetAllUsersMethod;
    if ((getGetAllUsersMethod = AuthServiceGrpc.getGetAllUsersMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGetAllUsersMethod = AuthServiceGrpc.getGetAllUsersMethod) == null) {
          AuthServiceGrpc.getGetAllUsersMethod = getGetAllUsersMethod =
              io.grpc.MethodDescriptor.<com.engbridge.auth.grpc.Empty, com.engbridge.auth.grpc.UserList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.UserList.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("getAllUsers"))
              .build();
        }
      }
    }
    return getGetAllUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.engbridge.auth.grpc.UserIdRequest,
      com.engbridge.auth.grpc.UserResponse> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUser",
      requestType = com.engbridge.auth.grpc.UserIdRequest.class,
      responseType = com.engbridge.auth.grpc.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.engbridge.auth.grpc.UserIdRequest,
      com.engbridge.auth.grpc.UserResponse> getGetUserMethod() {
    io.grpc.MethodDescriptor<com.engbridge.auth.grpc.UserIdRequest, com.engbridge.auth.grpc.UserResponse> getGetUserMethod;
    if ((getGetUserMethod = AuthServiceGrpc.getGetUserMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGetUserMethod = AuthServiceGrpc.getGetUserMethod) == null) {
          AuthServiceGrpc.getGetUserMethod = getGetUserMethod =
              io.grpc.MethodDescriptor.<com.engbridge.auth.grpc.UserIdRequest, com.engbridge.auth.grpc.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.UserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.engbridge.auth.grpc.UserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("getUser"))
              .build();
        }
      }
    }
    return getGetUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceStub>() {
        @java.lang.Override
        public AuthServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceStub(channel, callOptions);
        }
      };
    return AuthServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceBlockingStub>() {
        @java.lang.Override
        public AuthServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceBlockingStub(channel, callOptions);
        }
      };
    return AuthServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthServiceFutureStub>() {
        @java.lang.Override
        public AuthServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthServiceFutureStub(channel, callOptions);
        }
      };
    return AuthServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void register(com.engbridge.auth.grpc.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.RegisterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    default void login(com.engbridge.auth.grpc.LoginRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.LoginResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    default void validateToken(com.engbridge.auth.grpc.ValidateRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.ValidateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateTokenMethod(), responseObserver);
    }

    /**
     */
    default void invalidateToken(com.engbridge.auth.grpc.InvalidateRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.InvalidateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInvalidateTokenMethod(), responseObserver);
    }

    /**
     */
    default void createUser(com.engbridge.auth.grpc.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.CreateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    default void update(com.engbridge.auth.grpc.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.UpdateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    default void delete(com.engbridge.auth.grpc.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.DeleteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    default void getAllUsers(com.engbridge.auth.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.UserList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllUsersMethod(), responseObserver);
    }

    /**
     */
    default void getUser(com.engbridge.auth.grpc.UserIdRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.UserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AuthService.
   */
  public static abstract class AuthServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AuthServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AuthService.
   */
  public static final class AuthServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AuthServiceStub> {
    private AuthServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(com.engbridge.auth.grpc.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.RegisterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(com.engbridge.auth.grpc.LoginRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.LoginResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateToken(com.engbridge.auth.grpc.ValidateRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.ValidateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void invalidateToken(com.engbridge.auth.grpc.InvalidateRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.InvalidateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInvalidateTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createUser(com.engbridge.auth.grpc.CreateUserRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.CreateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.engbridge.auth.grpc.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.UpdateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.engbridge.auth.grpc.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.DeleteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllUsers(com.engbridge.auth.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.UserList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUser(com.engbridge.auth.grpc.UserIdRequest request,
        io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.UserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AuthService.
   */
  public static final class AuthServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuthServiceBlockingStub> {
    private AuthServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.engbridge.auth.grpc.RegisterResponse register(com.engbridge.auth.grpc.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.engbridge.auth.grpc.LoginResponse login(com.engbridge.auth.grpc.LoginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.engbridge.auth.grpc.ValidateResponse validateToken(com.engbridge.auth.grpc.ValidateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.engbridge.auth.grpc.InvalidateResponse invalidateToken(com.engbridge.auth.grpc.InvalidateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInvalidateTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.engbridge.auth.grpc.CreateUserResponse createUser(com.engbridge.auth.grpc.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.engbridge.auth.grpc.UpdateResponse update(com.engbridge.auth.grpc.UpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.engbridge.auth.grpc.DeleteResponse delete(com.engbridge.auth.grpc.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.engbridge.auth.grpc.UserList getAllUsers(com.engbridge.auth.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.engbridge.auth.grpc.UserResponse getUser(com.engbridge.auth.grpc.UserIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AuthService.
   */
  public static final class AuthServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuthServiceFutureStub> {
    private AuthServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.engbridge.auth.grpc.RegisterResponse> register(
        com.engbridge.auth.grpc.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.engbridge.auth.grpc.LoginResponse> login(
        com.engbridge.auth.grpc.LoginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.engbridge.auth.grpc.ValidateResponse> validateToken(
        com.engbridge.auth.grpc.ValidateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.engbridge.auth.grpc.InvalidateResponse> invalidateToken(
        com.engbridge.auth.grpc.InvalidateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInvalidateTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.engbridge.auth.grpc.CreateUserResponse> createUser(
        com.engbridge.auth.grpc.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.engbridge.auth.grpc.UpdateResponse> update(
        com.engbridge.auth.grpc.UpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.engbridge.auth.grpc.DeleteResponse> delete(
        com.engbridge.auth.grpc.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.engbridge.auth.grpc.UserList> getAllUsers(
        com.engbridge.auth.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.engbridge.auth.grpc.UserResponse> getUser(
        com.engbridge.auth.grpc.UserIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_LOGIN = 1;
  private static final int METHODID_VALIDATE_TOKEN = 2;
  private static final int METHODID_INVALIDATE_TOKEN = 3;
  private static final int METHODID_CREATE_USER = 4;
  private static final int METHODID_UPDATE = 5;
  private static final int METHODID_DELETE = 6;
  private static final int METHODID_GET_ALL_USERS = 7;
  private static final int METHODID_GET_USER = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((com.engbridge.auth.grpc.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.RegisterResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.engbridge.auth.grpc.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.LoginResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_TOKEN:
          serviceImpl.validateToken((com.engbridge.auth.grpc.ValidateRequest) request,
              (io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.ValidateResponse>) responseObserver);
          break;
        case METHODID_INVALIDATE_TOKEN:
          serviceImpl.invalidateToken((com.engbridge.auth.grpc.InvalidateRequest) request,
              (io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.InvalidateResponse>) responseObserver);
          break;
        case METHODID_CREATE_USER:
          serviceImpl.createUser((com.engbridge.auth.grpc.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.CreateUserResponse>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.engbridge.auth.grpc.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.UpdateResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.engbridge.auth.grpc.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.DeleteResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_USERS:
          serviceImpl.getAllUsers((com.engbridge.auth.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.UserList>) responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser((com.engbridge.auth.grpc.UserIdRequest) request,
              (io.grpc.stub.StreamObserver<com.engbridge.auth.grpc.UserResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getRegisterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.engbridge.auth.grpc.RegisterRequest,
              com.engbridge.auth.grpc.RegisterResponse>(
                service, METHODID_REGISTER)))
        .addMethod(
          getLoginMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.engbridge.auth.grpc.LoginRequest,
              com.engbridge.auth.grpc.LoginResponse>(
                service, METHODID_LOGIN)))
        .addMethod(
          getValidateTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.engbridge.auth.grpc.ValidateRequest,
              com.engbridge.auth.grpc.ValidateResponse>(
                service, METHODID_VALIDATE_TOKEN)))
        .addMethod(
          getInvalidateTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.engbridge.auth.grpc.InvalidateRequest,
              com.engbridge.auth.grpc.InvalidateResponse>(
                service, METHODID_INVALIDATE_TOKEN)))
        .addMethod(
          getCreateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.engbridge.auth.grpc.CreateUserRequest,
              com.engbridge.auth.grpc.CreateUserResponse>(
                service, METHODID_CREATE_USER)))
        .addMethod(
          getUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.engbridge.auth.grpc.UpdateRequest,
              com.engbridge.auth.grpc.UpdateResponse>(
                service, METHODID_UPDATE)))
        .addMethod(
          getDeleteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.engbridge.auth.grpc.DeleteRequest,
              com.engbridge.auth.grpc.DeleteResponse>(
                service, METHODID_DELETE)))
        .addMethod(
          getGetAllUsersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.engbridge.auth.grpc.Empty,
              com.engbridge.auth.grpc.UserList>(
                service, METHODID_GET_ALL_USERS)))
        .addMethod(
          getGetUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.engbridge.auth.grpc.UserIdRequest,
              com.engbridge.auth.grpc.UserResponse>(
                service, METHODID_GET_USER)))
        .build();
  }

  private static abstract class AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.engbridge.auth.grpc.Auth.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthService");
    }
  }

  private static final class AuthServiceFileDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier {
    AuthServiceFileDescriptorSupplier() {}
  }

  private static final class AuthServiceMethodDescriptorSupplier
      extends AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AuthServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getLoginMethod())
              .addMethod(getValidateTokenMethod())
              .addMethod(getInvalidateTokenMethod())
              .addMethod(getCreateUserMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getDeleteMethod())
              .addMethod(getGetAllUsersMethod())
              .addMethod(getGetUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
