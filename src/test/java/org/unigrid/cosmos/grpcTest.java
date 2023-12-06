package org.unigrid.cosmos;

import cosmos.bank.v1beta1.QueryGrpc;
import cosmos.bank.v1beta1.QueryOuterClass;
import cosmos.staking.v1beta1.MsgGrpc;
import cosmos.staking.v1beta1.Tx.MsgDelegate;
import cosmos.staking.v1beta1.Tx.MsgDelegateResponse;
import cosmos.tx.v1beta1.ServiceGrpc;
import cosmos.tx.v1beta1.ServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import cosmos.base.v1beta1.CoinOuterClass.Coin;

public class grpcTest {
    
    public void grpcDemo() {
        // grpc endpoint
        ManagedChannel channel = ManagedChannelBuilder.forTarget("127.0.0.1:9090")
                .usePlaintext()
                .build();

        // new query service
        QueryGrpc.QueryBlockingStub queryBlockingStub = QueryGrpc.newBlockingStub(channel);

        // query the balance
        QueryOuterClass.QueryAllBalancesResponse balance = queryBlockingStub.allBalances(QueryOuterClass.QueryAllBalancesRequest.newBuilder().setAddress("cosmos1wjuh6ee7gzkr489pmfc3qcw6qvjensquzv3s0x").build());
        System.out.println(balance.getBalances(0).getAmount());

        // new transactions service
        ServiceGrpc.ServiceBlockingStub txServiceBlockingStub = ServiceGrpc.newBlockingStub(channel);
        // query tx detail
        ServiceOuterClass.GetTxResponse txResponse = txServiceBlockingStub.getTx(ServiceOuterClass.GetTxRequest.newBuilder().setHash("9A500E826296559DEF05E9D0C7D354F05A37FCF69DDD79B78EF0FCA438E8660B").build());
        System.out.println(txResponse.getTxResponse().getTxhash());

        // broadcast transactions
        ServiceOuterClass.BroadcastTxResponse broadcastTxResponse = txServiceBlockingStub.broadcastTx(ServiceOuterClass.BroadcastTxRequest.newBuilder().build());
        System.out.println(broadcastTxResponse.getTxResponse().getTxhash());
    }

    public void delegateTokens(String delegatorAddress, String validatorAddress, Coin amount) {
        // Create a gRPC channel
        ManagedChannel channel = ManagedChannelBuilder.forTarget("127.0.0.1:9090")
                .usePlaintext()
                .build();

        // Create a stub for the staking service
        MsgGrpc.MsgBlockingStub stakingStub = MsgGrpc.newBlockingStub(channel);

        // Create a delegation message
        MsgDelegate msgDelegate = MsgDelegate.newBuilder()
                .setDelegatorAddress(delegatorAddress)
                .setValidatorAddress(validatorAddress)
                // Assuming Coin has a method to set the amount
                .setAmount(amount)  
                .build();

        // Send the delegation request
        MsgDelegateResponse response = stakingStub.delegate(msgDelegate);

        // Handle the response
        // ...

        // Don't forget to shutdown the channel when you're done
        channel.shutdown();
    }
    
}