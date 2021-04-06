package com.allmycoins.balance.ethereum2;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Eth2BalanceDataJson {

	private BigDecimal balance;

}
