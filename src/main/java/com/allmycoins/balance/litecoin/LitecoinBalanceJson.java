package com.allmycoins.balance.litecoin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LitecoinBalanceJson {

	private LitecoinBalanceDataJson[] data;

}
