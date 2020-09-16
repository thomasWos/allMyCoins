package com.allmycoins.json.binance;

import lombok.Getter;

@Getter
public final class BinanceBalanceJson {

//  {
//    "asset": "BTC",
//    "free": "4723846.89208129",
//    "locked": "0.00000000"
//  }

	public String asset;
	public float free;
	public float locked;

	public boolean isPositive() {
		return free > 0;
	}

}
