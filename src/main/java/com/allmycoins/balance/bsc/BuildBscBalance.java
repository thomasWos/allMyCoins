package com.allmycoins.balance.bsc;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

public final class BuildBscBalance {

	public static BalanceJson build(BnbBalanceJson bnbBalanceJson) {
		float qty = BigDecimalUtils.decimal18(bnbBalanceJson.getResult());
		return new BalanceJson("BNB", qty, "BSC wallet");
	}

	public static List<BalanceJson> build(BscTokenTxResultJson tokenTxResultJson, String address) {

		List<BscTokenTxJson> toTx = tokenTxResultJson.getResult().stream()
				.filter(t -> address.equalsIgnoreCase(t.getTo())).collect(Collectors.toList());

		Map<String, BalanceJson> toTxMap = toTx.stream().map(BuildBscBalance::toBalanceJson)
				.collect(Collectors.toMap(BalanceJson::getAsset, Function.identity(),
						(b1, b2) -> new BalanceJson(b1.getAsset(), b1.getQty() + b2.getQty(), b1.getSrc())));

		List<BscTokenTxJson> fromTx = tokenTxResultJson.getResult().stream()
				.filter(t -> address.equalsIgnoreCase(t.getFrom())).collect(Collectors.toList());

		Map<String, BalanceJson> fromTxMap = fromTx.stream().map(BuildBscBalance::toBalanceJson)
				.collect(Collectors.toMap(BalanceJson::getAsset, Function.identity(),
						(b1, b2) -> new BalanceJson(b1.getAsset(), b1.getQty() + b2.getQty(), b1.getSrc())));

		fromTxMap.forEach((asset, fromBalance) -> {
			BalanceJson balance = toTxMap.get(asset);
			BalanceJson newBalance = new BalanceJson(asset, balance.getQty() - fromBalance.getQty(), balance.getSrc());
			toTxMap.put(asset, newBalance);
		});

		return toTxMap.values().stream().filter(b -> b.getQty() > 0.0f).collect(Collectors.toList());
	}

	private static BalanceJson toBalanceJson(BscTokenTxJson tx) {
		return new BalanceJson(tx.getTokenSymbol(), BigDecimalUtils.decimal(tx.getValue(), tx.getTokenDecimal()),
				"BSC wallet");
	}

}
