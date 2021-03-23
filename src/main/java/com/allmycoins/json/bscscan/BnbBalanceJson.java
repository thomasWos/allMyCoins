package com.allmycoins.json.bscscan;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public final class BnbBalanceJson {

	private int status;
	private String message;
	private BigDecimal result;

}
