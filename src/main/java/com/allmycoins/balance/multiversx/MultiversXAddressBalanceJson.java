package com.allmycoins.balance.multiversx;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
final class MultiversXAddressBalanceJson {

	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

}
