package com.allmycoins.balance.algorand;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class AlgorandBalanceJson {

	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

}
