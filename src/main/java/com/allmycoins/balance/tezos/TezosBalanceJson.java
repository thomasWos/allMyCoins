package com.allmycoins.balance.tezos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TezosBalanceJson {

	private BigDecimal total_balance;

}
