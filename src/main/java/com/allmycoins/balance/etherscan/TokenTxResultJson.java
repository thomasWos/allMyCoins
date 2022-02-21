package com.allmycoins.balance.etherscan;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class TokenTxResultJson {

	private List<TokenTxJson> result;

	public List<TokenTxJson> getResult() {
		return result;
	}
}
