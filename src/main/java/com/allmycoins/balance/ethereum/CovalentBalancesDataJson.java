package com.allmycoins.balance.ethereum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CovalentBalancesDataJson {

	private CovalentBalanceItemJson[] items;

	public CovalentBalanceItemJson[] getItems() {
		return items;
	}
}
