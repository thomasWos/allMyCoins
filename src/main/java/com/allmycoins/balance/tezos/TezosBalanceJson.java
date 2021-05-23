package com.allmycoins.balance.tezos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TezosBalanceJson {

	private BigDecimal total_balance;

	public BigDecimal getTotal_balance() {
		return total_balance;
	}

}
