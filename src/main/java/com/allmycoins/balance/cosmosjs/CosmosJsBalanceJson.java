package com.allmycoins.balance.cosmosjs;

import java.math.BigDecimal;

public final class CosmosJsBalanceJson {

	private String denom;
	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

	public String getDenom() {
		return denom;
	}
}
