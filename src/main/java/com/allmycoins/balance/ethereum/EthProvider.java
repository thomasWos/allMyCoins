package com.allmycoins.balance.ethereum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import com.allmycoins.balance.PublicAddressBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class EthProvider implements PublicAddressBalanceProvider {

	@Override
	public List<BalanceJson> balance(String publicAddress) {
		Future<EtherscanBalanceJson> futureEtherBalanceJson = RequestUtils
				.sendRequestFuture(new EtherscanBalanceRequest(publicAddress));

		Future<AmberdataEthTokensJson> futureAmberdataEthTokensJson = RequestUtils
				.sendRequestFuture(new AmberdataEthTokensRequest(publicAddress));

		BalanceJson ethBalance = BuildEtherscanBalance.build(FutureUtils.futureResult(futureEtherBalanceJson));
		List<BalanceJson> amberdataEthTokensBalances = BuildAmberdataEthTokensBalances
				.build(FutureUtils.futureResult(futureAmberdataEthTokensJson));

		List<BalanceJson> etherBalances = new ArrayList<>();
		etherBalances.add(ethBalance);
		etherBalances.addAll(amberdataEthTokensBalances);

		return etherBalances;
	}

	@Override
	public String privateConfigKey() {
		return "ETH_ADDRESS";
	}

}
