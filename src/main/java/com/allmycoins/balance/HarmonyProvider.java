package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.harmony.HarmonyBalanceJson;
import com.allmycoins.json.harmony.HarmonyDelegationsJson;
import com.allmycoins.pc.BuildHarmonyBalance;
import com.allmycoins.request.harmony.HarmonyBalanceRequest;
import com.allmycoins.request.harmony.HarmonyDelegationsRequest;
import com.allmycoins.utils.RequestUtils;

public final class HarmonyProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		return PrivateConfig.get("HARMONY_ADDRESS").map(this::balances).orElseGet(Collections::emptyList);
	}

	private List<BalanceJson> balances(String harmonyAddress) {
		HarmonyBalanceJson balanceJson = RequestUtils.sendRequest(new HarmonyBalanceRequest(harmonyAddress));
		HarmonyDelegationsJson delegationsJson = RequestUtils
				.sendRequest(new HarmonyDelegationsRequest(harmonyAddress));

		BalanceJson harmonyBalance = BuildHarmonyBalance.build(balanceJson, delegationsJson);
		return List.of(harmonyBalance);
	}

}
