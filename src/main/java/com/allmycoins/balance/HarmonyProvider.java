package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.harmony.HarmonyBalanceJson;
import com.allmycoins.json.harmony.HarmonyDelegationsJson;
import com.allmycoins.pc.BuildHarmonyBalance;
import com.allmycoins.request.harmony.HarmonyBalanceRequest;
import com.allmycoins.request.harmony.HarmonyDelegationsRequest;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class HarmonyProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		return PrivateConfig.get("HARMONY_ADDRESS").map(this::balances).orElseGet(Collections::emptyList);
	}

	private List<BalanceJson> balances(String harmonyAddress) {
		Future<HarmonyBalanceJson> balanceJsonF = RequestUtils
				.sendRequestFuture(new HarmonyBalanceRequest(harmonyAddress));
		Future<HarmonyDelegationsJson> delegationsJsonF = RequestUtils
				.sendRequestFuture(new HarmonyDelegationsRequest(harmonyAddress));

		BalanceJson harmonyBalance = BuildHarmonyBalance.build(FutureUtils.futureResult(balanceJsonF),
				FutureUtils.futureResult(delegationsJsonF));
		return List.of(harmonyBalance);
	}

}
