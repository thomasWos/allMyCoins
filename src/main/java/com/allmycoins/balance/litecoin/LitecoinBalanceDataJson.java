package com.allmycoins.balance.litecoin;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Getter;

@Getter
public final class LitecoinBalanceDataJson {

	private BigDecimal balance;

	@JsonAnySetter
	public void set(String date, BigDecimal pBalance) {
		balance = pBalance;
	}

}
