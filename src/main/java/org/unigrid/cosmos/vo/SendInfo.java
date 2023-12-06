package org.unigrid.cosmos.vo;

import org.unigrid.cosmos.crypto.CosmosCredentials;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SendInfo {
    CosmosCredentials credentials;
    String toAddress;
    BigDecimal amountInAtom;
}
