package com.allmycoins.balance.coinspot;

import java.util.List;
import java.util.Map;

import lombok.Getter;

@Getter
public final class CoinspotBalancesJson {

//	{
//		  "status": "ok",
//		  "balances": [
//		    { "AUD": { "balance": 0.00256, "audbalance": 0.00256, "rate": 1 } },
//		    { "BTC": { "balance": 1.01793199, "audbalance": 14627.1, "rate": 14369.43 } },
//		    { "LTC": { "balance": 15.74093531, "audbalance": 1086.76, "rate": 69.04 } }
//		  ]
//		}

	private String status;
	private List<Map<String, CoinspotBalanceJson>> balances;

}
