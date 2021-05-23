package com.allmycoins.balance.litecoin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class LitecoinBalanceJson {

	private LitecoinBalanceDataJson[] data;

	public LitecoinBalanceDataJson[] getData() {
		return data;
	}
}
