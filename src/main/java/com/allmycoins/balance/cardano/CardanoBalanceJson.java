package com.allmycoins.balance.cardano;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardanoBalanceJson {

	private String[] info;

	public String[] getInfo() {
		return info;
	}

}
