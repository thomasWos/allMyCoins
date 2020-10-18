package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.elrond.ElrondBalanceRequestJson;
import com.allmycoins.json.elrond.ElrondDelegationJson;
import com.allmycoins.pc.BuildElrondBalance;
import com.allmycoins.request.elrond.ElrondAddressBalanceRequest;
import com.allmycoins.request.elrond.ElrondDelegationRequest;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public class ElrondProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		return PrivateConfig.get("ELROND_ADDRESS").map(this::balances).orElseGet(Collections::emptyList);
	}

	private List<BalanceJson> balances(String eldondAddress) {

		Future<ElrondBalanceRequestJson> elrondBalanceRequestJsonF = FutureUtils
				.runCallable(() -> RequestUtils.sendRequest(new ElrondAddressBalanceRequest(eldondAddress)));

		Future<ElrondDelegationJson> elrondDelegationJsonF = FutureUtils
				.runCallable(() -> RequestUtils.sendRequest(new ElrondDelegationRequest(eldondAddress)));

		ElrondBalanceRequestJson elrondBalanceRequestJson = FutureUtils.futureResult(elrondBalanceRequestJsonF);
		ElrondDelegationJson elrondDelegationJson = FutureUtils.futureResult(elrondDelegationJsonF);

		BalanceJson elrondBalance = BuildElrondBalance.build(elrondBalanceRequestJson, elrondDelegationJson);
		return List.of(elrondBalance);
	}

}
