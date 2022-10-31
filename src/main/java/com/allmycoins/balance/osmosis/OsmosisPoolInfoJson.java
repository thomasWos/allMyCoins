package com.allmycoins.balance.osmosis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class OsmosisPoolInfoJson {

	private PoolInfoJson pool;

	public PoolInfoJson getPool() {
		return pool;
	}
}
