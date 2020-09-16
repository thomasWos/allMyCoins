package com.allmycoins.json.binance;

import java.util.List;

import lombok.Getter;

@Getter
public final class BinanceAccountJson {

//	{
//	  "makerCommission": 15,
//	  "takerCommission": 15,
//	  "buyerCommission": 0,
//	  "sellerCommission": 0,
//	  "canTrade": true,
//	  "canWithdraw": true,
//	  "canDeposit": true,
//	  "updateTime": 123456789,
//	  "accountType": "SPOT",
//	  "balances": [
//	    {
//	      "asset": "BTC",
//	      "free": "4723846.89208129",
//	      "locked": "0.00000000"
//	    },
//	    {
//	      "asset": "LTC",
//	      "free": "4763368.68006011",
//	      "locked": "0.00000000"
//	    }
//	  ],
//	  "permissions": [
//	    "SPOT"
//	  ]
//	}

	public int makerCommission;
	public int takerCommission;
	public int buyerCommission;
	public int sellerCommission;
	public boolean canTrade;
	public boolean canWithdraw;
	public boolean canDeposit;
	public long updateTime;
	public String accountType;
	public List<BinanceBalanceJson> balances;
	public List<String> permissions;

}
