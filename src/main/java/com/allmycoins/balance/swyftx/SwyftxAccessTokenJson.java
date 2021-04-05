package com.allmycoins.balance.swyftx;

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
