package com.allmycoins.balance.bsc;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class BnbBalanceJson {
	private BigDecimal result;

	public BigDecimal getResult() {
		return result;
	}
}
