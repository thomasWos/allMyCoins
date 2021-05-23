package com.allmycoins.balance.polkadot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class PolkadotAccountDataJson {

	private PolkadotAttributesJson attributes;

	public PolkadotAttributesJson getAttributes() {
		return attributes;
	}

}
