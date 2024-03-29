package com.allmycoins.balance.cosmosjs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class CosmosJsDelegationsJson {

	private CosmosJsDelegationResponseJson[] delegation_responses;

	public CosmosJsDelegationResponseJson[] getDelegation_responses() {
		return delegation_responses;
	}

}
