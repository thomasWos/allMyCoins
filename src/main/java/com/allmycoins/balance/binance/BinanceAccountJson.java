package com.allmycoins.balance.binance;

import java.util.List;

import lombok.Getter;

@Getter
public final class BinanceAccountJson {

	private int makerCommission;
	private int takerCommission;
	private int buyerCommission;
	private int sellerCommission;
	private boolean canTrade;
	private boolean canWithdraw;
	private boolean canDeposit;
	private long updateTime;
	private String accountType;
	private List<BinanceBalanceJson> balances;
	private List<String> permissions;

}
