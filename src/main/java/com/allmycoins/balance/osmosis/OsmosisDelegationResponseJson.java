package com.allmycoins.balance.osmosis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class OsmosisDelegationResponseJson {

	private OsmosisBalanceJson balance;

	public OsmosisBalanceJson getBalance() {
		return balance;
	}

}
