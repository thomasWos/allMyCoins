package com.allmycoins.balance;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.algorand.AlgorandBalanceJson;
import com.allmycoins.pc.BuildAlgorandBalance;
import com.allmycoins.request.algorand.AlgorandAccountRequest;
import com.allmycoins.utils.RequestUtils;

public final class AlgorandProvider implements PublicAddressBalanceProvider {

	@Override
	public BalanceJson balance(String publicAddress) {
		AlgorandBalanceJson algoBalanceJson = RequestUtils.sendRequest(new AlgorandAccountRequest(publicAddress));
		return BuildAlgorandBalance.build(algoBalanceJson);
	}

	@Override
	public String privateConfigKey() {
		return "ALGORAND_ADDRESS";
	}

}
