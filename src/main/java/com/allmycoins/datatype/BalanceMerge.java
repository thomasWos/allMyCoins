package com.allmycoins.datatype;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class BalanceMerge {

	private final String asset;
	private final float qty;
	private final Set<String> sources;

}
