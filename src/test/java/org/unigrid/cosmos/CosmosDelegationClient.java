package org.unigrid.cosmos;

import org.unigrid.cosmos.CosmosRestApiClient;
import cosmos.staking.v1beta1.Tx.MsgDelegate;

import java.math.BigDecimal;
import java.util.HashMap;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import org.unigrid.cosmos.crypto.CosmosCredentials;
import org.unigrid.cosmos.util.ATOMUnitUtil;

import cosmos.base.v1beta1.CoinOuterClass.Coin;
import cosmos.tx.v1beta1.ServiceOuterClass;
import cosmos.tx.v1beta1.TxOuterClass.*;

public class CosmosDelegationClient extends CosmosRestApiClient {

    public CosmosDelegationClient(String baseUrl, String chainId, String token) {
        super(baseUrl, chainId, token);
    }

   public void delegateTokens(String delegatorAddress, String validatorAddress, BigDecimal amountInAtom, CosmosCredentials credentials) throws Exception {
        // Step 1: Create MsgDelegate message
        Coin delegateAmount = Coin.newBuilder()
                .setDenom("ugd")
                .setAmount(ATOMUnitUtil.atomToMicroAtom(amountInAtom).toPlainString())
                .build();
        MsgDelegate msgDelegate = MsgDelegate.newBuilder()
                .setDelegatorAddress(delegatorAddress)
                .setValidatorAddress(validatorAddress)
                .setAmount(delegateAmount)
                .build();

        // Step 2: Create TxBody object
        TxBody txBody = TxBody.newBuilder()
                .addMessages(Any.pack(msgDelegate, "/"))
                .build();

        // Step 3: Create AuthInfo object
        Coin feeCoin = Coin.newBuilder()
                .setDenom("ugd")
                .setAmount(ATOMUnitUtil.atomToMicroAtom(new BigDecimal("0.01")).toPlainString())  // Assume a fee of 0.01 ATOM
                .build();
        Fee fee = Fee.newBuilder()
                .setGasLimit(200000)  // Assume a gas limit of 200,000
                .addAmount(feeCoin)
                .build();
        SignerInfo signerInfo = getSignInfo(credentials, new HashMap<>());  // Assume getSignInfo is a method to get the SignerInfo
        AuthInfo authInfo = AuthInfo.newBuilder()
                .setFee(fee)
                .addSignerInfos(signerInfo)
                .build();

        // Step 4: Use signDoc method to sign the transaction
        ByteString signedTx = getSignBytes(credentials, txBody, authInfo, new HashMap<>());

        // Step 5: Create Tx object
        Tx tx = Tx.newBuilder()
                .setBody(txBody)
                .setAuthInfo(authInfo)
                .addSignatures(signedTx)
                .build();

        // Step 6: Broadcast Tx object to the network
        ServiceOuterClass.BroadcastTxRequest broadcastTxRequest = ServiceOuterClass.BroadcastTxRequest.newBuilder()
                .setTxBytes(tx.toByteString())
                .setMode(ServiceOuterClass.BroadcastMode.BROADCAST_MODE_SYNC)
                .build();
        ServiceOuterClass.BroadcastTxResponse broadcastTxResponse = broadcastTx(broadcastTxRequest);
    }
}