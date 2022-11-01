package com.allmycoins.balance.osmosis;

import com.allmycoins.balance.cosmosjs.CosmosJsBalanceJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class OsmosisLockedCoinsJson {

	private CosmosJsBalanceJson[] coins;

	public CosmosJsBalanceJson[] getCoins() {
		return coins;
	}

}
