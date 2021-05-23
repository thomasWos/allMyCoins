package com.allmycoins.balance.ethereum;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class EtherscanBalanceJson {

	private BigDecimal result;

	public BigDecimal getResult() {
		return result;
	}
}
