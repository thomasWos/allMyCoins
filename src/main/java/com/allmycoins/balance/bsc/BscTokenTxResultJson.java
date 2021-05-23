package com.allmycoins.balance.bsc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class BscTokenTxResultJson {

	private List<BscTokenTxJson> result;

	public List<BscTokenTxJson> getResult() {
		return result;
	}
}
