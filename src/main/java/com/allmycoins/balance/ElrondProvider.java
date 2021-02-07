package com.allmycoins.balance;

import java.util.concurrent.Future;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.elrond.ElrondBalanceRequestJson;
import com.allmycoins.json.elrond.ElrondDelegationJson;
import com.allmycoins.pc.BuildElrondBalance;
import com.allmycoins.request.elrond.ElrondAddressBalanceRequest;
import com.allmycoins.request.elrond.ElrondDelegationRequest;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class ElrondProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "ELROND_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		Future<ElrondBalanceRequestJson> elrondBalanceRequestJsonF = RequestUtils
				.sendRequestFuture(new ElrondAddressBalanceRequest(publicAddress));

		Future<ElrondDelegationJson> elrondDelegationJsonF = RequestUtils
				.sendRequestFuture(new ElrondDelegationRequest(publicAddress));

		ElrondBalanceRequestJson elrondBalanceRequestJson = FutureUtils.futureResult(elrondBalanceRequestJsonF);
		ElrondDelegationJson elrondDelegationJson = FutureUtils.futureResult(elrondDelegationJsonF);

		return BuildElrondBalance.build(elrondBalanceRequestJson, elrondDelegationJson);
	}

}
