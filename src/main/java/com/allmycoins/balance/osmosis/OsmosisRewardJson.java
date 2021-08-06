package com.allmycoins.balance.osmosis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class OsmosisRewardJson {

	private OsmosisBalanceJson[] total;

	public OsmosisBalanceJson[] getTotal() {
		return total;
	}

}
