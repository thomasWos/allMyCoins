package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.algorand.AlgorandBalanceJson;
import com.allmycoins.pc.BuildAlgorandBalance;
import com.allmycoins.request.algorand.AlgorandAccountRequest;
import com.allmycoins.utils.RequestUtils;

public final class AlgorandProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		return PrivateConfig.get("ALGORAND_ADDRESS").map(this::algorandBalance).map(List::of)
				.orElseGet(Collections::emptyList);
	}

	private BalanceJson algorandBalance(String algorandAddress) {
		AlgorandBalanceJson algoBalanceJson = RequestUtils.sendRequest(new AlgorandAccountRequest(algorandAddress));
		return BuildAlgorandBalance.build(algoBalanceJson);
	}

}
