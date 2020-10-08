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
//  }

	private String address;
	private String holder;
	private BigDecimal amount;
	private int decimals;
	private String name;
	private String symbol;
	private Boolean isERC20;
	private Boolean isERC721;
	private Boolean isERC777;
	private Boolean isERC884;
	private Boolean isERC998;

}
