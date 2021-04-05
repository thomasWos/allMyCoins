package com.allmycoins.balance.cryptocom;

import java.util.List;

import lombok.Getter;

@Getter
public final class CryptoComResultJson {

//    "accounts": [
//    {
//        "balance": 99999999.905000000000000000,
//        "available": 99999996.905000000000000000,
//        "order": 3.000000000000000000,
//        "stake": 0,
//        "currency": "CRO"
//    }
//	]

	private List<CryptoComAccountJson> accounts;

}
