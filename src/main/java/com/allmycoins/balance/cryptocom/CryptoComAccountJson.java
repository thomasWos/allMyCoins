package com.allmycoins.balance.cryptocom;

import lombok.Getter;

@Getter
public final class CryptoComAccountJson {

//  "balance": 99999999.905000000000000000,
//  "available": 99999996.905000000000000000,
//  "order": 3.000000000000000000,
//  "stake": 0,
//  "currency": "CRO"

	private float balance;
	private float available;
	private float order;
	private float stake;
	private String currency;

}
