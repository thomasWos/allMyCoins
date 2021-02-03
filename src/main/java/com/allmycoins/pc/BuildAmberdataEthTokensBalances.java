package com.allmycoins.pc;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.amberdata.AmberdataEthTokensJson;
import com.allmycoins.json.amberdata.EthTokenRecordJson;

public final class BuildAmberdataEthTokensBalances {

	public static List<BalanceJson> build(AmberdataEthTokensJson ethTokensJson) {
		return ethTokensJson.getPayload().getRecords().stream()
				.filter(t -> t.getDecimals() > 0 && t.getAmount().floatValue() > 0.0f)
				.filter(BuildAmberdataEthTokensBalances::specialPredicate).map(BuildAmberdataEthTokensBalances::balance)
				.distinct().collect(Collectors.toList());
	}

	private static BalanceJson balance(EthTokenRecordJson ethTokenRecord) {
		float qty = ethTokenRecord.getAmount().divide(BigDecimal.valueOf(10).pow(ethTokenRecord.getDecimals()))
				.floatValue();
		return new BalanceJson(ethTokenRecord.getSymbol(), qty, "ETH wallet");
	}

	private static boolean specialPredicate(EthTokenRecordJson tokenRecordJson) {
		if (tokenRecordJson.getSymbol().equals("SNX")) {
			return tokenRecordJson.getAddress().equals("0xc011a73ee8576fb46f5e1c5751ca3b9fe0af2a6f");
		}
		return true;
	}

}
