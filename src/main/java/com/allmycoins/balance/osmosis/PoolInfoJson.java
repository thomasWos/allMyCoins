package com.allmycoins.balance.osmosis;

import com.allmycoins.balance.cosmosjs.CosmosJsBalanceJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class PoolInfoJson {

	@JsonProperty("total_shares")
	private CosmosJsBalanceJson totalShares;

	@JsonProperty("pool_assets")
	private PoolAssetJson[] poolAssets;

	public CosmosJsBalanceJson getTotalShares() {
		return totalShares;
	}

	public PoolAssetJson[] getPoolAssets() {
		return poolAssets;
	}
}
