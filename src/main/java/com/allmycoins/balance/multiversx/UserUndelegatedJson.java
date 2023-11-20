package com.allmycoins.balance.multiversx;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
final class UserUndelegatedJson {

	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

}
