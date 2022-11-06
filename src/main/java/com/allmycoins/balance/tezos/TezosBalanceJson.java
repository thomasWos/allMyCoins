package com.allmycoins.balance.tezos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TezosBalanceJson {

	private BigDecimal spendable_balance;

	public BigDecimal getSpendable_balance() {
		return spendable_balance;
	}

}
