package com.allmycoins.balance.bsc;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BscTokenTxJson {

	private String from;
	private String to;
	private BigDecimal value;
	private int tokenDecimal;
	private String tokenSymbol;

}
