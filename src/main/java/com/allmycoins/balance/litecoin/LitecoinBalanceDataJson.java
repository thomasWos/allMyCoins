package com.allmycoins.balance.litecoin;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public final class LitecoinBalanceDataJson {

	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

	@JsonAnySetter
	public void set(String date, BigDecimal pBalance) {
		balance = pBalance;
	}

}
