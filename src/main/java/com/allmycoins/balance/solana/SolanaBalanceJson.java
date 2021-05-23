package com.allmycoins.balance.solana;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class SolanaBalanceJson {

	private SolanaResult result;

	public SolanaResult getResult() {
		return result;
	}

}
