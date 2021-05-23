package com.allmycoins.balance.coinspot;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CoinspotBalancesJson {

	private List<Map<String, CoinspotBalanceJson>> balances;

	public List<Map<String, CoinspotBalanceJson>> getBalances() {
		return balances;
	}
}
