package com.allmycoins.json.swyftx;

import lombok.Getter;

@Getter
public final class SwyftxAccessTokenJson {

//	{
//	  "accessToken": "eyJhbGciOiJSUzI1N...",
//	  "scope": "app.account.read ..."
//	}

	private String accessToken;
	private String scope;

}
