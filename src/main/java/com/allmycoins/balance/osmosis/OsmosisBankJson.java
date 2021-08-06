package com.allmycoins.balance.osmosis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class OsmosisBankJson {

	private OsmosisBalanceJson[] balances;

	public OsmosisBalanceJson[] getBalances() {
		return balances;
	}

}
