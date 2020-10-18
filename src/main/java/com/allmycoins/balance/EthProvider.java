package com.allmycoins.balance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.amberdata.AmberdataEthTokensJson;
import com.allmycoins.json.etherscan.EtherscanBalanceJson;
import com.allmycoins.pc.BuildAmberdataEthTokensBalances;
import com.allmycoins.pc.BuildEtherscanBalance;
import com.allmycoins.request.amberdata.AmberdataEthTokensRequest;
import com.allmycoins.request.etherscan.EtherscanBalanceRequest;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class EthProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		return PrivateConfig.get("ETH_ADDRESS").map(this::balances).orElseGet(Collections::emptyList);
	}

	private List<BalanceJson> balances(String ethAddress) {

		Future<EtherscanBalanceJson> futureEtherBalanceJson = RequestUtils
				.sendRequestFuture(new EtherscanBalanceRequest(ethAddress));

		Future<AmberdataEthTokensJson> futureAmberdataEthTokensJson = RequestUtils
				.sendRequestFuture(new AmberdataEthTokensRequest(ethAddress));

		BalanceJson ethBalance = BuildEtherscanBalance.build(FutureUtils.futureResult(futureEtherBalanceJson));
		List<BalanceJson> amberdataEthTokensBalances = BuildAmberdataEthTokensBalances
				.build(FutureUtils.futureResult(futureAmberdataEthTokensJson));

		List<BalanceJson> etherBalances = new ArrayList<>();
		etherBalances.add(ethBalance);
		etherBalances.addAll(amberdataEthTokensBalances);

		return etherBalances;
	}

}
