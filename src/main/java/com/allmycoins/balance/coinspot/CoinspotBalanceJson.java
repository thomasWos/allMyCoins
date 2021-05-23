package com.allmycoins.balance.coinspot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CoinspotBalanceJson {

	private float balance;
	private float audbalance;

	public float getAudbalance() {
		return audbalance;
	}

	public float getBalance() {
		return balance;
	}

}
