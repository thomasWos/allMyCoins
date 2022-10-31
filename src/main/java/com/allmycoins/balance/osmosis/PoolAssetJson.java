package com.allmycoins.balance.osmosis;

import com.allmycoins.balance.cosmosjs.CosmosJsBalanceJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class PoolAssetJson {

	private CosmosJsBalanceJson token;

	public CosmosJsBalanceJson getToken() {
		return token;
	}
}
