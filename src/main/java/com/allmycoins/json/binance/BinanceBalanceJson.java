package com.allmycoins.json.binance;

import lombok.Getter;

@Getter
public final class BinanceBalanceJson {

	private String asset;
	private float free;
	private float locked;

	public boolean isPositive() {
		return free + locked > 0;
	}
}
