package com.allmycoins.balance.coinspot;

import java.util.List;
import java.util.Map;

import lombok.Getter;

@Getter
public final class CoinspotBalancesJson {

	private String status;
	private List<Map<String, CoinspotBalanceJson>> balances;

}
