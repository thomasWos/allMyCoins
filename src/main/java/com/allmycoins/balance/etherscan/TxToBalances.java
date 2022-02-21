package com.allmycoins.balance.etherscan;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

public final class TxToBalances {

	public static final List<BalanceJson> txToBalances(TokenTxResultJson tokenTxResultJson, String address,
			String networkSrc) {
		List<TokenTxJson> toTx = tokenTxResultJson.getResult().stream().filter(t -> address.equalsIgnoreCase(t.getTo()))
				.collect(Collectors.toList());

		Function<TokenTxJson, BalanceJson> toBalanceJson = tx -> new BalanceJson(tx.getTokenSymbol(),
				BigDecimalUtils.decimal(tx.getValue(), tx.getTokenDecimal()), networkSrc);

		Map<String, BalanceJson> toTxMap = toTx.stream().map(toBalanceJson)
				.collect(Collectors.toMap(BalanceJson::getAsset, Function.identity(),
						(b1, b2) -> new BalanceJson(b1.getAsset(), b1.getQty() + b2.getQty(), b1.getSrc())));

		List<TokenTxJson> fromTx = tokenTxResultJson.getResult().stream()
				.filter(t -> address.equalsIgnoreCase(t.getFrom())).collect(Collectors.toList());

		Map<String, BalanceJson> fromTxMap = fromTx.stream().map(toBalanceJson)
				.collect(Collectors.toMap(BalanceJson::getAsset, Function.identity(),
						(b1, b2) -> new BalanceJson(b1.getAsset(), b1.getQty() + b2.getQty(), b1.getSrc())));

		fromTxMap.forEach((asset, fromBalance) -> {
			BalanceJson balance = toTxMap.get(asset);
			BalanceJson newBalance = new BalanceJson(asset, balance.getQty() - fromBalance.getQty(), balance.getSrc());
			toTxMap.put(asset, newBalance);
		});

		return toTxMap.values().stream().filter(b -> b.getQty() > 0.0f).collect(Collectors.toList());
	}

}
