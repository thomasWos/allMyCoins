package com.allmycoins.datatype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Balance {

	private final String asset;
	private final float qty;
	private final float usd;
	private final String src;

}
