package com.allmycoins.datatype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Balance {

	private final String asset;
	private final float quantity;
	private final float currencyValue;
	private final String source;

}
