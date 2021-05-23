package com.allmycoins.balance.ethereum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class AmberdataEthTokensJson {

	private EthTokenPayloadJson payload;

	public EthTokenPayloadJson getPayload() {
		return payload;
	}
}
