package com.allmycoins.balance.etherscan;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class TokenTxJson {

	private String from;
	private String to;
	private BigDecimal value;
	private int tokenDecimal;
	private String tokenSymbol;

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public int getTokenDecimal() {
		return tokenDecimal;
	}

	public String getTokenSymbol() {
		return tokenSymbol;
	}

	public BigDecimal getValue() {
		return value;
	}
}
