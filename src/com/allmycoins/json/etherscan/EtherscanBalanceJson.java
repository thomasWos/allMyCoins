package com.allmycoins.json.etherscan;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public final class EtherscanBalanceJson {

	public int status;
	public String message;
	public BigDecimal result;

}
