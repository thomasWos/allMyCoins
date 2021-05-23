package com.allmycoins.balance.binance;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class BinanceAccountJson {

	private List<BinanceBalanceJson> balances;

	public List<BinanceBalanceJson> getBalances() {
		return balances;
	}
}
