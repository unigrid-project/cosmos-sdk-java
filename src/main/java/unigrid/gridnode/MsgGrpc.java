package unigrid.gridnode;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Msg defines the Msg service for gridnode module.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: gridnode/tx.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MsgGrpc {

  private MsgGrpc() {}

  public static final String SERVICE_NAME = "unigrid.gridnode.Msg";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<unigrid.gridnode.Tx.MsgGridnodeDelegate,
      unigrid.gridnode.Tx.MsgGridnodeDelegateResponse> getDelegateTokensMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DelegateTokens",
      requestType = unigrid.gridnode.Tx.MsgGridnodeDelegate.class,
      responseType = unigrid.gridnode.Tx.MsgGridnodeDelegateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<unigrid.gridnode.Tx.MsgGridnodeDelegate,
      unigrid.gridnode.Tx.MsgGridnodeDelegateResponse> getDelegateTokensMethod() {
    io.grpc.MethodDescriptor<unigrid.gridnode.Tx.MsgGridnodeDelegate, unigrid.gridnode.Tx.MsgGridnodeDelegateResponse> getDelegateTokensMethod;
    if ((getDelegateTokensMethod = MsgGrpc.getDelegateTokensMethod) == null) {
      synchronized (MsgGrpc.class) {
        if ((getDelegateTokensMethod = MsgGrpc.getDelegateTokensMethod) == null) {
          MsgGrpc.getDelegateTokensMethod = getDelegateTokensMethod =
              io.grpc.MethodDescriptor.<unigrid.gridnode.Tx.MsgGridnodeDelegate, unigrid.gridnode.Tx.MsgGridnodeDelegateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DelegateTokens"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unigrid.gridnode.Tx.MsgGridnodeDelegate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unigrid.gridnode.Tx.MsgGridnodeDelegateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MsgMethodDescriptorSupplier("DelegateTokens"))
              .build();
        }
      }
    }
    return getDelegateTokensMethod;
  }

  private static volatile io.grpc.MethodDescriptor<unigrid.gridnode.Tx.MsgGridnodeUndelegate,
      unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse> getUndelegateTokensMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndelegateTokens",
      requestType = unigrid.gridnode.Tx.MsgGridnodeUndelegate.class,
      responseType = unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<unigrid.gridnode.Tx.MsgGridnodeUndelegate,
      unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse> getUndelegateTokensMethod() {
    io.grpc.MethodDescriptor<unigrid.gridnode.Tx.MsgGridnodeUndelegate, unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse> getUndelegateTokensMethod;
    if ((getUndelegateTokensMethod = MsgGrpc.getUndelegateTokensMethod) == null) {
      synchronized (MsgGrpc.class) {
        if ((getUndelegateTokensMethod = MsgGrpc.getUndelegateTokensMethod) == null) {
          MsgGrpc.getUndelegateTokensMethod = getUndelegateTokensMethod =
              io.grpc.MethodDescriptor.<unigrid.gridnode.Tx.MsgGridnodeUndelegate, unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndelegateTokens"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unigrid.gridnode.Tx.MsgGridnodeUndelegate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MsgMethodDescriptorSupplier("UndelegateTokens"))
              .build();
        }
      }
    }
    return getUndelegateTokensMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MsgStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgStub>() {
        @java.lang.Override
        public MsgStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgStub(channel, callOptions);
        }
      };
    return MsgStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MsgBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgBlockingStub>() {
        @java.lang.Override
        public MsgBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgBlockingStub(channel, callOptions);
        }
      };
    return MsgBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MsgFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgFutureStub>() {
        @java.lang.Override
        public MsgFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgFutureStub(channel, callOptions);
        }
      };
    return MsgFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Msg defines the Msg service for gridnode module.
   * </pre>
   */
  public static abstract class MsgImplBase implements io.grpc.BindableService {

    /**
     */
    public void delegateTokens(unigrid.gridnode.Tx.MsgGridnodeDelegate request,
        io.grpc.stub.StreamObserver<unigrid.gridnode.Tx.MsgGridnodeDelegateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelegateTokensMethod(), responseObserver);
    }

    /**
     */
    public void undelegateTokens(unigrid.gridnode.Tx.MsgGridnodeUndelegate request,
        io.grpc.stub.StreamObserver<unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndelegateTokensMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDelegateTokensMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                unigrid.gridnode.Tx.MsgGridnodeDelegate,
                unigrid.gridnode.Tx.MsgGridnodeDelegateResponse>(
                  this, METHODID_DELEGATE_TOKENS)))
          .addMethod(
            getUndelegateTokensMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                unigrid.gridnode.Tx.MsgGridnodeUndelegate,
                unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse>(
                  this, METHODID_UNDELEGATE_TOKENS)))
          .build();
    }
  }

  /**
   * <pre>
   * Msg defines the Msg service for gridnode module.
   * </pre>
   */
  public static final class MsgStub extends io.grpc.stub.AbstractAsyncStub<MsgStub> {
    private MsgStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgStub(channel, callOptions);
    }

    /**
     */
    public void delegateTokens(unigrid.gridnode.Tx.MsgGridnodeDelegate request,
        io.grpc.stub.StreamObserver<unigrid.gridnode.Tx.MsgGridnodeDelegateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelegateTokensMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void undelegateTokens(unigrid.gridnode.Tx.MsgGridnodeUndelegate request,
        io.grpc.stub.StreamObserver<unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndelegateTokensMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Msg defines the Msg service for gridnode module.
   * </pre>
   */
  public static final class MsgBlockingStub extends io.grpc.stub.AbstractBlockingStub<MsgBlockingStub> {
    private MsgBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgBlockingStub(channel, callOptions);
    }

    /**
     */
    public unigrid.gridnode.Tx.MsgGridnodeDelegateResponse delegateTokens(unigrid.gridnode.Tx.MsgGridnodeDelegate request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelegateTokensMethod(), getCallOptions(), request);
    }

    /**
     */
    public unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse undelegateTokens(unigrid.gridnode.Tx.MsgGridnodeUndelegate request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndelegateTokensMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Msg defines the Msg service for gridnode module.
   * </pre>
   */
  public static final class MsgFutureStub extends io.grpc.stub.AbstractFutureStub<MsgFutureStub> {
    private MsgFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<unigrid.gridnode.Tx.MsgGridnodeDelegateResponse> delegateTokens(
        unigrid.gridnode.Tx.MsgGridnodeDelegate request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelegateTokensMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse> undelegateTokens(
        unigrid.gridnode.Tx.MsgGridnodeUndelegate request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndelegateTokensMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELEGATE_TOKENS = 0;
  private static final int METHODID_UNDELEGATE_TOKENS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MsgImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MsgImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELEGATE_TOKENS:
          serviceImpl.delegateTokens((unigrid.gridnode.Tx.MsgGridnodeDelegate) request,
              (io.grpc.stub.StreamObserver<unigrid.gridnode.Tx.MsgGridnodeDelegateResponse>) responseObserver);
          break;
        case METHODID_UNDELEGATE_TOKENS:
          serviceImpl.undelegateTokens((unigrid.gridnode.Tx.MsgGridnodeUndelegate) request,
              (io.grpc.stub.StreamObserver<unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse>) responseObserver);
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

  private static abstract class MsgBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MsgBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return unigrid.gridnode.Tx.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Msg");
    }
  }

  private static final class MsgFileDescriptorSupplier
      extends MsgBaseDescriptorSupplier {
    MsgFileDescriptorSupplier() {}
  }

  private static final class MsgMethodDescriptorSupplier
      extends MsgBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MsgMethodDescriptorSupplier(String methodName) {
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
      synchronized (MsgGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MsgFileDescriptorSupplier())
              .addMethod(getDelegateTokensMethod())
              .addMethod(getUndelegateTokensMethod())
              .build();
        }
      }
    }
    return result;
  }
}
