package com.allmycoins.balance.multiversx;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class MultiversXAddressBalanceJson {

	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

}
