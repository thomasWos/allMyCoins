package com.allmycoins.balance.ethereum;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class EthTokenRecordJson {

	private String address;
	private BigDecimal amount;
	private int decimals;
	private String symbol;

	public String getAddress() {
		return address;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public int getDecimals() {
		return decimals;
	}

	public String getSymbol() {
		return symbol;
	}

}
