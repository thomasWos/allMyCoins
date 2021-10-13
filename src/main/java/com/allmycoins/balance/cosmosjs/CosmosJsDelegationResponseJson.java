package com.allmycoins.balance.cosmosjs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CosmosJsDelegationResponseJson {

	private CosmosJsBalanceJson balance;

	public CosmosJsBalanceJson getBalance() {
		return balance;
	}

}
