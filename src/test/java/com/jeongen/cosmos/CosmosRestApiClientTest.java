package com.jeongen.cosmos;

import com.jeongen.cosmos.crypro.CosmosCredentials;
import com.jeongen.cosmos.vo.SendInfo;
import cosmos.base.abci.v1beta1.Abci;
import cosmos.staking.v1beta1.MsgGrpc;
import cosmos.staking.v1beta1.Tx.MsgDelegate;
import cosmos.staking.v1beta1.Tx.MsgDelegateResponse;
import cosmos.tx.v1beta1.ServiceOuterClass;
import cosmos_proto.Cosmos;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import junit.framework.TestCase;
import org.bouncycastle.util.encoders.Hex;
import org.checkerframework.checker.units.qual.A;

import cosmos.base.v1beta1.CoinOuterClass.Coin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CosmosRestApiClientTest extends TestCase {

    public void testSendMultiTx() throws Exception {
        CosmosRestApiClient cosmosRestApiClient = new CosmosRestApiClient("https://api.cosmos.network", "cosmoshub-4",
                "uatom");

        BigDecimal balanceInAtom = cosmosRestApiClient
                .getBalanceInAtom("cosmos1xxkueklal9vejv9unqu80w9vptyepfa95pd53u");
        System.out.println(balanceInAtom);
        // 私钥生成公钥、地址
        byte[] privateKey = Hex.decode("c2ad7a31c06ea8bb560a0467898ef844523f2f804dec96fedf65906dbb951f24");
        CosmosCredentials credentials = CosmosCredentials.create(privateKey, "cosmos");
        // 获取地址
        System.out.println("address:" + credentials.getAddress());
        List<SendInfo> sendList = new ArrayList<>();
        sendList.add(
                SendInfo.builder().credentials(credentials).toAddress("cosmos12kd7gu4lamw29pv4u6ug8aryr0p7wm207uwt30")
                        .amountInAtom(new BigDecimal("0.0001")).build());
        sendList.add(
                SendInfo.builder().credentials(credentials).toAddress("cosmos1u3zluamfx5pvgha0dn73ah4pyu9ckv6scvdw72")
                        .amountInAtom(new BigDecimal("0.0001")).build());
        // 生成、签名、广播交易
        Abci.TxResponse txResponse = cosmosRestApiClient.sendMultiTx(credentials, sendList, new BigDecimal("0.000001"),
                200000);
        System.out.println(txResponse);
        //
        // 获取指定高度的交易
        ServiceOuterClass.GetTxsEventResponse txsEventByHeight = cosmosRestApiClient.getTxsEventByHeight(10099441L, "");
        System.out.println(txsEventByHeight);
    }

    private CosmosCredentials credentials;
    private MsgGrpc.MsgBlockingStub stakingStub;

    public void DelegateHandler(byte[] privateKey, String grpcEndpoint) {
        this.credentials = CosmosCredentials.create(privateKey, "cosmos");
        ManagedChannel channel = ManagedChannelBuilder.forTarget(grpcEndpoint)
                .usePlaintext()
                .build();
        this.stakingStub = MsgGrpc.newBlockingStub(channel);
    }

    public MsgDelegateResponse delegateTokens(String delegatorAddress, String validatorAddress, Coin amount) {
        // Create a delegation message
        MsgDelegate msgDelegate = MsgDelegate.newBuilder()
                .setDelegatorAddress(delegatorAddress)
                .setValidatorAddress(validatorAddress)
                .setAmount(amount)
                .build();

        // Sign and broadcast the delegation message
        MsgDelegateResponse response = signAndBroadcast(msgDelegate);

        return response;
    }

    private MsgDelegateResponse signAndBroadcast(MsgDelegate msgDelegate) {
        // Assume there's a method to sign the message and broadcast it to the network
        // This is a hypothetical method and the actual implementation would depend on
        // the gRPC client and the Cosmos SDK
        byte[] signedMsg = credentials.sign(msgDelegate.toByteArray()); // Hypothetical sign method

        // Assume the signed message is included in a transaction and broadcast to the
        // network
        // The actual method for broadcasting the transaction would depend on the gRPC
        // client and the Cosmos SDK
        MsgDelegateResponse response = stakingStub.delegate(msgDelegate); // Hypothetical broadcast method

        return response;
    }
}
