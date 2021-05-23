package com.allmycoins.balance.polkadot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class PolkadotAccountJson {

	private PolkadotAccountDataJson data;

	public PolkadotAccountDataJson getData() {
		return data;
	}

}
