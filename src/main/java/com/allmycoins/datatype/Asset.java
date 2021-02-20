package com.allmycoins.datatype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Asset {
	private final Balance balance;
	private final float ratio;
	private final int marketCapRank;
}
