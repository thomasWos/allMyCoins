package com.allmycoins.balance.ethereum;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public final class EtherscanBalanceJson {

	private int status;
	private String message;
	private BigDecimal result;

}
