package com.allmycoins.balance.bitcoin;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinDataJson {

	private BigDecimal balance;

}
