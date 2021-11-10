package com.allmycoins.balance.avalanche;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class AvalancheBalanceJson {
	private BigDecimal result;

	public BigDecimal getResult() {
		return result;
	}
}
