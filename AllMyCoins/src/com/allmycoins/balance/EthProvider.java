package com.allmycoins.balance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.amberdata.AmberdataEthTokensJson;
import com.allmycoins.json.etherscan.EtherscanBalanceJson;
import com.allmycoins.pc.BuildAmberdataEthTokensBalances;
import com.allmycoins.pc.BuildEtherscanBalance;
import com.allmycoins.request.amberdata.AmberdataEthTokensRequest;
import com.allmycoins.request.etherscan.EtherscanBalanceRequest;
import com.allmycoins.utils.RequestUtils;

public final class EthProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		return PrivateConfig.get("ETH_ADDRESS").map(this::balances).orElseGet(Collections::emptyList);
	}

	private List<BalanceJson> balances(String ethAddress) {

		// Etherscan
		EtherscanBalanceJson etherBalanceJson = RequestUtils.sendRequest(new EtherscanBalanceRequest(ethAddress));
		BalanceJson ethBalance = BuildEtherscanBalance.build(etherBalanceJson);

		// Amberdata
		AmberdataEthTokensJson amberdataEthTokensJson = RequestUtils
				.sendRequest(new AmberdataEthTokensRequest(ethAddress));
		List<BalanceJson> amberdataEthTokensBalances = BuildAmberdataEthTokensBalances.build(amberdataEthTokensJson);

		List<BalanceJson> etherBalances = new ArrayList<>();
		etherBalances.add(ethBalance);
		etherBalances.addAll(amberdataEthTokensBalances);

		return etherBalances;
	}

}
