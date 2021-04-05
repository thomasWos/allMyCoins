package com.allmycoins.balance.algorand;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class AlgorandProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "ALGORAND_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		AlgorandBalanceJson algoBalanceJson = RequestUtils.sendRequest(new AlgorandAccountRequest(publicAddress));
		return BuildAlgorandBalance.build(algoBalanceJson);
	}

}
