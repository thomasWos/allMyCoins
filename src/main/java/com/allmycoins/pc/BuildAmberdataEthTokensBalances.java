package com.allmycoins.pc;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.amberdata.AmberdataEthTokensJson;
import com.allmycoins.json.amberdata.EthTokenRecordJson;

public class BuildAmberdataEthTokensBalances {

	public static List<BalanceJson> build(AmberdataEthTokensJson ethTokensJson) {
		return ethTokensJson.getPayload().getRecords().stream().map(BuildAmberdataEthTokensBalances::balance).distinct()
				.collect(Collectors.toList());
	}

	private static BalanceJson balance(EthTokenRecordJson ethTokenRecord) {
		float qty = ethTokenRecord.getAmount().divide(BigDecimal.valueOf(10).pow(ethTokenRecord.getDecimals()))
				.floatValue();
		return new BalanceJson(ethTokenRecord.getSymbol(), qty, "ETH wallet");
	}
}
