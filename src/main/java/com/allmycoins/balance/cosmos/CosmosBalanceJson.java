package com.allmycoins.balance.cosmos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CosmosBalanceJson {

	private CosmosAmountJson total;

	public CosmosAmountJson getTotal() {
		return total;
	}

}
