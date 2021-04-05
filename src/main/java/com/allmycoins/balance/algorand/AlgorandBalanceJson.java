package com.allmycoins.balance.algorand;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlgorandBalanceJson {

	private BigDecimal balance;

}
