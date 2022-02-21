package com.allmycoins.balance.etherscan;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class SingleBalanceJson {
	private BigDecimal result;

	public BigDecimal getResult() {
		return result;
	}
}
