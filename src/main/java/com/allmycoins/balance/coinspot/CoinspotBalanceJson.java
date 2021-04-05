package com.allmycoins.balance.coinspot;

import lombok.Getter;

@Getter
public final class CoinspotBalanceJson {

	// { "balance": 15.74093531, "audbalance": 1086.76, "rate": 69.04 }

	private float balance;
	private float audbalance;
	private float rate;

}
