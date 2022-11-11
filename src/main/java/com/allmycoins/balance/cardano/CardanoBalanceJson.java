package com.allmycoins.balance.cardano;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardanoBalanceJson {

	private BigDecimal controlled_amount;

	public BigDecimal getControlled_amount() {
		return controlled_amount;
	}

}
