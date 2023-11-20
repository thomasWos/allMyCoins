package com.allmycoins.balance.multiversx;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
final class MultiversXEsdtBalanceJson {

	private String ticker;

	private Long decimals;

	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

	public String getTicker() {
		return ticker;
	}

	public Long getDecimals() {
		return decimals;
	}

}
