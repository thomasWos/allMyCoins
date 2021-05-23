package com.allmycoins.balance.cosmos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CosmosAmountJson {

	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

}
