package com.allmycoins.json;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class BalanceJson {

	private final String asset;
	private final float qty;
	private final String src;

}
