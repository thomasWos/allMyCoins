package com.allmycoins.balance.elrond;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ElrondAddressBalanceJson {

	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

}
