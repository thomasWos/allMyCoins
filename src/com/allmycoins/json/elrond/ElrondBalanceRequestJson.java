package com.allmycoins.json.elrond;

import lombok.Getter;

@Getter
public final class ElrondBalanceRequestJson {

	// {"data":{"balance":"5743955479452054794"},"error":"","code":"successful"}

	private ElrondAddressBalanceJson data;
	private String error;
	private String code;

}
