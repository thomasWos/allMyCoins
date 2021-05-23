package com.allmycoins.balance.bitcoin;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinDataJson {

	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}
}
