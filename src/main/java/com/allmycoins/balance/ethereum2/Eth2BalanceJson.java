package com.allmycoins.balance.ethereum2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Eth2BalanceJson {

	private Eth2BalanceDataJson data;

	public Eth2BalanceDataJson getData() {
		return data;
	}

}
