package com.allmycoins.balance.swyftx;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import com.allmycoins.json.BalanceJson;

public final class BuildSwyftxBalances {

	public static final List<BalanceJson> build(final List<SwyftxBalanceJson> swyftxBalancesJson,
			final Map<Integer, String> assetToCodeMap) {
		return swyftxBalancesJson.stream().map(b -> balance(assetToCodeMap.get(b.getAssetId()), b))
				.filter(b -> !b.getAsset().equals("AUD")).collect(toList());
	}

	private static BalanceJson balance(String symbol, SwyftxBalanceJson swyftxBalanceJson) {
		return new BalanceJson(symbol, swyftxBalanceJson.getAvailableBalance(), "Swyftx");
	}
}
