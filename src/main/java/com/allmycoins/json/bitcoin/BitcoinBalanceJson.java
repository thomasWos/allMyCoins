package com.allmycoins.json.bitcoin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinBalanceJson {

	private BitcoinDataJson data;

}
