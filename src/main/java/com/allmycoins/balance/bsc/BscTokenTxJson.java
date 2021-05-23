package com.allmycoins.balance.bsc;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BscTokenTxJson {

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

	public void setTokenDecimal(int tokenDecimal) {
		this.tokenDecimal = tokenDecimal;
	}
}
