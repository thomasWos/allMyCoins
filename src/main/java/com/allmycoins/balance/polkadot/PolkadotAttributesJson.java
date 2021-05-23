package com.allmycoins.balance.polkadot;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class PolkadotAttributesJson {

	private BigDecimal balance_total;

	public BigDecimal getBalance_total() {
		return balance_total;
	}

}
