package com.allmycoins.balance.binance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class BinanceBalanceJson {

	private String asset;
	private float free;
	private float locked;

	public String getAsset() {
		return asset;
	}

	public float getFree() {
		return free;
	}

	public float getLocked() {
		return locked;
	}

	public boolean isPositive() {
		return free + locked > 0;
	}
}
