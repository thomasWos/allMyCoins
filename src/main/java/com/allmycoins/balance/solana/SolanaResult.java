package com.allmycoins.balance.solana;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class SolanaResult {

	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

}
