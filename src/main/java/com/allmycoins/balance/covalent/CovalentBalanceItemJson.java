package com.allmycoins.balance.covalent;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CovalentBalanceItemJson {

	private String contract_ticker_symbol;

	private BigDecimal balance;

	private int contract_decimals;

	public String getContract_ticker_symbol() {
		return contract_ticker_symbol;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public int getContract_decimals() {
		return contract_decimals;
	}
}
