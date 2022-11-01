package com.allmycoins.balance.algorand;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class AlgorandBalanceJson {

	private int amount;

	public int getAmount() {
		return amount;
	}

}
