package com.allmycoins.json.cosmos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CosmosBalanceJson {

	private CosmosAmountJson total;

}
