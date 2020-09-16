package com.allmycoins.json.cryptocom;

import lombok.Getter;

@Getter
public final class CryptoComAccountJson {

//  "balance": 99999999.905000000000000000,
//  "available": 99999996.905000000000000000,
//  "order": 3.000000000000000000,
//  "stake": 0,
//  "currency": "CRO"

	public float balance;
	public float available;
	public float order;
	public float stake;
	public String currency;

}
