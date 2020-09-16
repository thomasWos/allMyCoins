package com.allmycoins.json.cryptocom;

import lombok.Getter;

@Getter
public final class CryptoComAccountSummaryJson {

//	{
//	    "id": 11,
//	    "method": "private/get-account-summary",
//	    "code": 0,
//	    "result": {
//	        "accounts": [
//	            {
//	                "balance": 99999999.905000000000000000,
//	                "available": 99999996.905000000000000000,
//	                "order": 3.000000000000000000,
//	                "stake": 0,
//	                "currency": "CRO"
//	            }
//	        ]
//	    }
//	}

	public long id;
	public String method;
	public int code;
	public CryptoComResultJson result;

}
