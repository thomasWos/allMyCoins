package com.allmycoins.json.coinspot;

import lombok.Getter;

@Getter
public final class CoinspotBalanceJson {

	// { "balance": 15.74093531, "audbalance": 1086.76, "rate": 69.04 }

	public float balance;
	public float audbalance;
	public float rate;

}
