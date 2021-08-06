package com.allmycoins.balance.osmosis;

import java.math.BigDecimal;

public final class OsmosisBalanceJson {

	private String denom;
	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

	public String getDenom() {
		return denom;
	}
}
