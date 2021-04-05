package com.allmycoins.balance.harmony;

import java.util.concurrent.Future;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class HarmonyProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "HARMONY_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		Future<HarmonyBalanceJson> balanceJsonF = RequestUtils
				.sendRequestFuture(new HarmonyBalanceRequest(publicAddress));
		Future<HarmonyDelegationsJson> delegationsJsonF = RequestUtils
				.sendRequestFuture(new HarmonyDelegationsRequest(publicAddress));

		return BuildHarmonyBalance.build(FutureUtils.futureResult(balanceJsonF),
				FutureUtils.futureResult(delegationsJsonF));
	}

}
