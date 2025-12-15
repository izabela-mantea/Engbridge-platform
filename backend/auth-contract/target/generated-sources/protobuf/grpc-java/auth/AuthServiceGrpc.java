package auth;

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
  private static volatile io.grpc.MethodDescriptor<auth.Auth.RegisterRequest,
      auth.Auth.RegisterResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Register",
      requestType = auth.Auth.RegisterRequest.class,
      responseType = auth.Auth.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.RegisterRequest,
      auth.Auth.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<auth.Auth.RegisterRequest, auth.Auth.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = AuthServiceGrpc.getRegisterMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getRegisterMethod = AuthServiceGrpc.getRegisterMethod) == null) {
          AuthServiceGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<auth.Auth.RegisterRequest, auth.Auth.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.RegisterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Register"))
              .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.LoginRequest,
      auth.Auth.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = auth.Auth.LoginRequest.class,
      responseType = auth.Auth.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.LoginRequest,
      auth.Auth.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<auth.Auth.LoginRequest, auth.Auth.LoginResponse> getLoginMethod;
    if ((getLoginMethod = AuthServiceGrpc.getLoginMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getLoginMethod = AuthServiceGrpc.getLoginMethod) == null) {
          AuthServiceGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<auth.Auth.LoginRequest, auth.Auth.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.ValidateRequest,
      auth.Auth.ValidateResponse> getValidateTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateToken",
      requestType = auth.Auth.ValidateRequest.class,
      responseType = auth.Auth.ValidateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.ValidateRequest,
      auth.Auth.ValidateResponse> getValidateTokenMethod() {
    io.grpc.MethodDescriptor<auth.Auth.ValidateRequest, auth.Auth.ValidateResponse> getValidateTokenMethod;
    if ((getValidateTokenMethod = AuthServiceGrpc.getValidateTokenMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getValidateTokenMethod = AuthServiceGrpc.getValidateTokenMethod) == null) {
          AuthServiceGrpc.getValidateTokenMethod = getValidateTokenMethod =
              io.grpc.MethodDescriptor.<auth.Auth.ValidateRequest, auth.Auth.ValidateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.ValidateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.ValidateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("ValidateToken"))
              .build();
        }
      }
    }
    return getValidateTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.InvalidateRequest,
      auth.Auth.InvalidateResponse> getInvalidateTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InvalidateToken",
      requestType = auth.Auth.InvalidateRequest.class,
      responseType = auth.Auth.InvalidateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.InvalidateRequest,
      auth.Auth.InvalidateResponse> getInvalidateTokenMethod() {
    io.grpc.MethodDescriptor<auth.Auth.InvalidateRequest, auth.Auth.InvalidateResponse> getInvalidateTokenMethod;
    if ((getInvalidateTokenMethod = AuthServiceGrpc.getInvalidateTokenMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getInvalidateTokenMethod = AuthServiceGrpc.getInvalidateTokenMethod) == null) {
          AuthServiceGrpc.getInvalidateTokenMethod = getInvalidateTokenMethod =
              io.grpc.MethodDescriptor.<auth.Auth.InvalidateRequest, auth.Auth.InvalidateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InvalidateToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.InvalidateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.InvalidateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("InvalidateToken"))
              .build();
        }
      }
    }
    return getInvalidateTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.CreateUserRequest,
      auth.Auth.CreateUserResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = auth.Auth.CreateUserRequest.class,
      responseType = auth.Auth.CreateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.CreateUserRequest,
      auth.Auth.CreateUserResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<auth.Auth.CreateUserRequest, auth.Auth.CreateUserResponse> getCreateUserMethod;
    if ((getCreateUserMethod = AuthServiceGrpc.getCreateUserMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getCreateUserMethod = AuthServiceGrpc.getCreateUserMethod) == null) {
          AuthServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<auth.Auth.CreateUserRequest, auth.Auth.CreateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.CreateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.CreateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.UpdateRequest,
      auth.Auth.UpdateResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = auth.Auth.UpdateRequest.class,
      responseType = auth.Auth.UpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.UpdateRequest,
      auth.Auth.UpdateResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<auth.Auth.UpdateRequest, auth.Auth.UpdateResponse> getUpdateMethod;
    if ((getUpdateMethod = AuthServiceGrpc.getUpdateMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getUpdateMethod = AuthServiceGrpc.getUpdateMethod) == null) {
          AuthServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<auth.Auth.UpdateRequest, auth.Auth.UpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.UpdateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Update"))
              .build();
        }
      }
    }
    return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.DeleteRequest,
      auth.Auth.DeleteResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = auth.Auth.DeleteRequest.class,
      responseType = auth.Auth.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.DeleteRequest,
      auth.Auth.DeleteResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<auth.Auth.DeleteRequest, auth.Auth.DeleteResponse> getDeleteMethod;
    if ((getDeleteMethod = AuthServiceGrpc.getDeleteMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getDeleteMethod = AuthServiceGrpc.getDeleteMethod) == null) {
          AuthServiceGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<auth.Auth.DeleteRequest, auth.Auth.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.DeleteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("Delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.Empty,
      auth.Auth.UserList> getGetAllUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllUsers",
      requestType = auth.Auth.Empty.class,
      responseType = auth.Auth.UserList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.Empty,
      auth.Auth.UserList> getGetAllUsersMethod() {
    io.grpc.MethodDescriptor<auth.Auth.Empty, auth.Auth.UserList> getGetAllUsersMethod;
    if ((getGetAllUsersMethod = AuthServiceGrpc.getGetAllUsersMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGetAllUsersMethod = AuthServiceGrpc.getGetAllUsersMethod) == null) {
          AuthServiceGrpc.getGetAllUsersMethod = getGetAllUsersMethod =
              io.grpc.MethodDescriptor.<auth.Auth.Empty, auth.Auth.UserList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.UserList.getDefaultInstance()))
              .setSchemaDescriptor(new AuthServiceMethodDescriptorSupplier("getAllUsers"))
              .build();
        }
      }
    }
    return getGetAllUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<auth.Auth.UserIdRequest,
      auth.Auth.UserResponse> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUser",
      requestType = auth.Auth.UserIdRequest.class,
      responseType = auth.Auth.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<auth.Auth.UserIdRequest,
      auth.Auth.UserResponse> getGetUserMethod() {
    io.grpc.MethodDescriptor<auth.Auth.UserIdRequest, auth.Auth.UserResponse> getGetUserMethod;
    if ((getGetUserMethod = AuthServiceGrpc.getGetUserMethod) == null) {
      synchronized (AuthServiceGrpc.class) {
        if ((getGetUserMethod = AuthServiceGrpc.getGetUserMethod) == null) {
          AuthServiceGrpc.getGetUserMethod = getGetUserMethod =
              io.grpc.MethodDescriptor.<auth.Auth.UserIdRequest, auth.Auth.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.UserIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  auth.Auth.UserResponse.getDefaultInstance()))
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
    default void register(auth.Auth.RegisterRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.RegisterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    default void login(auth.Auth.LoginRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.LoginResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    default void validateToken(auth.Auth.ValidateRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.ValidateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateTokenMethod(), responseObserver);
    }

    /**
     */
    default void invalidateToken(auth.Auth.InvalidateRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.InvalidateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInvalidateTokenMethod(), responseObserver);
    }

    /**
     */
    default void createUser(auth.Auth.CreateUserRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.CreateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    default void update(auth.Auth.UpdateRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.UpdateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    default void delete(auth.Auth.DeleteRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.DeleteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    default void getAllUsers(auth.Auth.Empty request,
        io.grpc.stub.StreamObserver<auth.Auth.UserList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllUsersMethod(), responseObserver);
    }

    /**
     */
    default void getUser(auth.Auth.UserIdRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.UserResponse> responseObserver) {
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
    public void register(auth.Auth.RegisterRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.RegisterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(auth.Auth.LoginRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.LoginResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateToken(auth.Auth.ValidateRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.ValidateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void invalidateToken(auth.Auth.InvalidateRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.InvalidateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInvalidateTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createUser(auth.Auth.CreateUserRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.CreateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(auth.Auth.UpdateRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.UpdateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(auth.Auth.DeleteRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.DeleteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllUsers(auth.Auth.Empty request,
        io.grpc.stub.StreamObserver<auth.Auth.UserList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUser(auth.Auth.UserIdRequest request,
        io.grpc.stub.StreamObserver<auth.Auth.UserResponse> responseObserver) {
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
    public auth.Auth.RegisterResponse register(auth.Auth.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.LoginResponse login(auth.Auth.LoginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.ValidateResponse validateToken(auth.Auth.ValidateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.InvalidateResponse invalidateToken(auth.Auth.InvalidateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInvalidateTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.CreateUserResponse createUser(auth.Auth.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.UpdateResponse update(auth.Auth.UpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.DeleteResponse delete(auth.Auth.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.UserList getAllUsers(auth.Auth.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public auth.Auth.UserResponse getUser(auth.Auth.UserIdRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.RegisterResponse> register(
        auth.Auth.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.LoginResponse> login(
        auth.Auth.LoginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.ValidateResponse> validateToken(
        auth.Auth.ValidateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.InvalidateResponse> invalidateToken(
        auth.Auth.InvalidateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInvalidateTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.CreateUserResponse> createUser(
        auth.Auth.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.UpdateResponse> update(
        auth.Auth.UpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.DeleteResponse> delete(
        auth.Auth.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.UserList> getAllUsers(
        auth.Auth.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<auth.Auth.UserResponse> getUser(
        auth.Auth.UserIdRequest request) {
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
          serviceImpl.register((auth.Auth.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.RegisterResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((auth.Auth.LoginRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.LoginResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_TOKEN:
          serviceImpl.validateToken((auth.Auth.ValidateRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.ValidateResponse>) responseObserver);
          break;
        case METHODID_INVALIDATE_TOKEN:
          serviceImpl.invalidateToken((auth.Auth.InvalidateRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.InvalidateResponse>) responseObserver);
          break;
        case METHODID_CREATE_USER:
          serviceImpl.createUser((auth.Auth.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.CreateUserResponse>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((auth.Auth.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.UpdateResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((auth.Auth.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.DeleteResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_USERS:
          serviceImpl.getAllUsers((auth.Auth.Empty) request,
              (io.grpc.stub.StreamObserver<auth.Auth.UserList>) responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser((auth.Auth.UserIdRequest) request,
              (io.grpc.stub.StreamObserver<auth.Auth.UserResponse>) responseObserver);
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
              auth.Auth.RegisterRequest,
              auth.Auth.RegisterResponse>(
                service, METHODID_REGISTER)))
        .addMethod(
          getLoginMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auth.Auth.LoginRequest,
              auth.Auth.LoginResponse>(
                service, METHODID_LOGIN)))
        .addMethod(
          getValidateTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auth.Auth.ValidateRequest,
              auth.Auth.ValidateResponse>(
                service, METHODID_VALIDATE_TOKEN)))
        .addMethod(
          getInvalidateTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auth.Auth.InvalidateRequest,
              auth.Auth.InvalidateResponse>(
                service, METHODID_INVALIDATE_TOKEN)))
        .addMethod(
          getCreateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auth.Auth.CreateUserRequest,
              auth.Auth.CreateUserResponse>(
                service, METHODID_CREATE_USER)))
        .addMethod(
          getUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auth.Auth.UpdateRequest,
              auth.Auth.UpdateResponse>(
                service, METHODID_UPDATE)))
        .addMethod(
          getDeleteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auth.Auth.DeleteRequest,
              auth.Auth.DeleteResponse>(
                service, METHODID_DELETE)))
        .addMethod(
          getGetAllUsersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auth.Auth.Empty,
              auth.Auth.UserList>(
                service, METHODID_GET_ALL_USERS)))
        .addMethod(
          getGetUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              auth.Auth.UserIdRequest,
              auth.Auth.UserResponse>(
                service, METHODID_GET_USER)))
        .build();
  }

  private static abstract class AuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return auth.Auth.getDescriptor();
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
