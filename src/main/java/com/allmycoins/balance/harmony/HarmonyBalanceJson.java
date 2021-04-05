package com.allmycoins.balance.harmony;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public final class HarmonyBalanceJson {

	// {"jsonrpc":"2.0","id":"1","result":126357610000000000}

	private String jsonrpc;
	private int id;
	private BigDecimal result;

}
