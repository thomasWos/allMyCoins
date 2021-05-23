package com.allmycoins.balance.harmony;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class HarmonyBalanceJson {

	private BigDecimal result;

	public BigDecimal getResult() {
		return result;
	}
}
