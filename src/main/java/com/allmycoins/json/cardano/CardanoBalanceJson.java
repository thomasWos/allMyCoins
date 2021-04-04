package com.allmycoins.json.cardano;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardanoBalanceJson {

	String[] info;

}
