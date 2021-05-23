package com.allmycoins.balance.bitcoin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class BitcoinBalanceJson {

	private BitcoinDataJson data;

	public BitcoinDataJson getData() {
		return data;
	}

}
