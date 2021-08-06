package com.allmycoins.balance.osmosis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class OsmosisDelegationsJson {

	private OsmosisDelegationResponseJson[] delegation_responses;

	public OsmosisDelegationResponseJson[] getDelegation_responses() {
		return delegation_responses;
	}

}
