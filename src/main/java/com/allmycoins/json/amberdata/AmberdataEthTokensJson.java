package com.allmycoins.json.amberdata;

import lombok.Getter;

@Getter
public final class AmberdataEthTokensJson {

//	{
//		  "status": 200,
//		  "title": "OK",
//		  "description": "Successful request",
//		  "payload": {
//		    "records": [{
//		        "address": "0xfa6f7881e52fdf912c4a285d78a3141b089ce859",
//		        "holder": "0x06012c8cf97bead5deae237070f9587f8e7a266d",
//		        "amount": "100000100000000000000000000",
//		        "decimals": "18",
//		        "name": "Avocado",
//		        "symbol": "AVO",
//		        "isERC20": true,
//		        "isERC721": false,
//		        "isERC777": false,
//		        "isERC884": false,
//		        "isERC998": false
//		      },
//		    ],
//		    "totalRecords": "82"
//		  }
//		}

	private int status;
	private String title;
	private String description;
	private EthTokenPayloadJson payload;

}