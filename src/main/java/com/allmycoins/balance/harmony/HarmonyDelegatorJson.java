package com.allmycoins.balance.harmony;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class HarmonyDelegatorJson {

	private BigDecimal amount;
	private BigDecimal reward;

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getReward() {
		return reward;
	}
}
