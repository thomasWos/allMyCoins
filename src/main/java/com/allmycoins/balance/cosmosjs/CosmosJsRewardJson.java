package com.allmycoins.balance.cosmosjs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CosmosJsRewardJson {

	private CosmosJsBalanceJson[] total;

	public CosmosJsBalanceJson[] getTotal() {
		return total;
	}

}
