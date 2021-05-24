package com.allmycoins.balance.elrond;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserUndelegatedJson {

	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

}
