package com.allmycoins.datatype;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class BalancesResult {

	private List<Balance> balances;
	private float totalCurrency;

}
