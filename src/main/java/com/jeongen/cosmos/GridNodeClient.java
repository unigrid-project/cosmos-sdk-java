package com.jeongen.cosmos;

import unigrid.gridnode.MsgGrpc;
import unigrid.gridnode.Tx.MsgGridnodeDelegate;
import unigrid.gridnode.Tx.MsgGridnodeDelegateResponse;
import unigrid.gridnode.Tx.MsgGridnodeUndelegate;
import unigrid.gridnode.Tx.MsgGridnodeUndelegateResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;

public class GridNodeClient {

    private final ManagedChannel channel;
    private final MsgGrpc.MsgBlockingStub stub;

    public GridNodeClient(String host, int port) {
        // Creates a new channel and stub for interacting with the gRPC server
        this.channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build();
        this.stub = MsgGrpc.newBlockingStub(channel);
    }

    public MsgGridnodeDelegateResponse delegateTokens(MsgGridnodeDelegate request) {
        // Invokes the DelegateTokens method on the gRPC server
        return stub.delegateTokens(request);
    }

    public MsgGridnodeUndelegateResponse undelegateTokens(MsgGridnodeUndelegate request) {
        // Invokes the UndelegateTokens method on the gRPC server
        return stub.undelegateTokens(request);
    }

    public void shutdown() throws InterruptedException {
        // Shuts down the channel when it's no longer needed
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}

