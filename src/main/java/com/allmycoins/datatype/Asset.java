package com.allmycoins.datatype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Asset {

	private final Balance balance;
	private final float ratio;

}
