package com.allmycoins.balance.cosmosjs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CosmosJsBankJson {

	private CosmosJsBalanceJson[] balances;

	public CosmosJsBalanceJson[] getBalances() {
		return balances;
	}

}
