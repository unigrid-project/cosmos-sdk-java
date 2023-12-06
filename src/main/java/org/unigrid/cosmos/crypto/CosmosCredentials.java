package org.unigrid.cosmos.crypto;

import org.unigrid.cosmos.util.AddressUtil;
import lombok.Getter;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;

@Getter
public class CosmosCredentials {

    private ECKey ecKey;
    private String address;

    private CosmosCredentials() {

    }

    public static CosmosCredentials create(ECKey ecKey, String addressPrefix) {
        CosmosCredentials credentials = new CosmosCredentials();
        credentials.ecKey = ecKey;
        credentials.address = AddressUtil.ecKeyToAddress(ecKey, addressPrefix);
        return credentials;
    }

    public static CosmosCredentials create(byte[] privateKey, String addressPrefix) {
        ECKey ecKey = ECKey.fromPrivate(privateKey);
        return create(ecKey, addressPrefix);
    }
        /**
     * Signs the given data using the ECKey of this credentials.
     *
     * @param data The data to sign.
     * @return The signature as a byte array.
     */
    public byte[] sign(byte[] data) {
        // Check if the ECKey is null
        if (this.ecKey == null) {
            throw new IllegalStateException("ECKey not initialized in CosmosCredentials");
        }

        // Sign the data
        return this.ecKey.sign(Sha256Hash.wrap(data)).encodeToDER();
    }

}
