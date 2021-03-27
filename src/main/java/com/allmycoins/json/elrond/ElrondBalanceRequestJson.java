package com.allmycoins.json.elrond;

import lombok.Getter;

@Getter
public final class ElrondBalanceRequestJson {

	private ElrondAddressBalanceJson data;
	private String error;
	private String code;

}
