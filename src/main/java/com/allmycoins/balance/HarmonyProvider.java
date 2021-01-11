package com.allmycoins.balance;

import java.util.concurrent.Future;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.harmony.HarmonyBalanceJson;
import com.allmycoins.json.harmony.HarmonyDelegationsJson;
import com.allmycoins.pc.BuildHarmonyBalance;
import com.allmycoins.request.harmony.HarmonyBalanceRequest;
import com.allmycoins.request.harmony.HarmonyDelegationsRequest;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class HarmonyProvider implements PublicAddressBalanceProvider {

	@Override
	public BalanceJson balance(String publicAddress) {
		Future<HarmonyBalanceJson> balanceJsonF = RequestUtils
				.sendRequestFuture(new HarmonyBalanceRequest(publicAddress));
		Future<HarmonyDelegationsJson> delegationsJsonF = RequestUtils
				.sendRequestFuture(new HarmonyDelegationsRequest(publicAddress));

		return BuildHarmonyBalance.build(FutureUtils.futureResult(balanceJsonF),
				FutureUtils.futureResult(delegationsJsonF));
	}

	@Override
	public String privateConfigKey() {
		return "HARMONY_ADDRESS";
	}

}
