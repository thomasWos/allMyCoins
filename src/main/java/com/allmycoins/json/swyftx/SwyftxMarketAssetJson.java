package com.allmycoins.json.swyftx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public final class SwyftxMarketAssetJson {

//	{
//	    "id": "1",
//	    "name": "Australian Dollars",
//	    "code": "AUD",
//	    "minimum_order": "0.001",
//	    "price_scale": 6,
//	    "deposit_enabled": true,
//	    "withdraw_enabled": true,
//	    "min_confirmations": 3,
//	    "min_withdrawal": 5,
//	    "minimum_order_increment": 0.000001,
//	    "mining_fee": 5,
//	    "primary": true,
//	    "secondary": true
//	}

	private int id;
	private String code;
}
