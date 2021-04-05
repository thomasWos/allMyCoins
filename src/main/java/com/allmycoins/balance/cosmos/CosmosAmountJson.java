package com.allmycoins.balance.cosmos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CosmosAmountJson {

	private BigDecimal amount;

}
