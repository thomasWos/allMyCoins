package com.allmycoins.json.amberdata;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public final class EthTokenRecordJson {

//	{
//	    "address": "0xfa6f7881e52fdf912c4a285d78a3141b089ce859",
//	    "holder": "0x06012c8cf97bead5deae237070f9587f8e7a266d",
//	    "amount": "100000100000000000000000000",
//	    "decimals": "18",
//	    "name": "Avocado",
//	    "symbol": "AVO",
//	    "isERC20": true,
//	    "isERC721": false,
//	    "isERC777": false,
//	    "isERC884": false,
//	    "isERC998": false
//      "price": {
//       "amount": {
//         "currency": "usd",
//         "quote": "233.901383764",
//         "total": "0.000000000000000000000000000000000000000000000"
//         }
//       }
//  }

	public String address;
	public String holder;
	public BigDecimal amount;
	public int decimals;
	public String name;
	public String symbol;
	public boolean isERC20;
	public boolean isERC721;
	public boolean isERC777;
	public boolean isERC884;
	public boolean isERC998;

	// Can be null for some records
	public EthTokenPriceJson price;

}
