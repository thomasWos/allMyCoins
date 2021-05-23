package com.allmycoins.balance.ethereum2;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Eth2BalanceDataJson {

	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}
}
