package com.allmycoins.balance.elrond;

import java.util.concurrent.Future;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
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

		Future<ElrondLegacyDelegationJson> elrondLegacyDelegationJsonF = RequestUtils
				.sendRequestFuture(new ElrondLegacyDelegationRequest(publicAddress));

		Future<ElrondDelegationJson[]> elrondDelegationsJsonF = RequestUtils
				.sendRequestFuture(new ElrondDelegationsRequest(publicAddress));

		ElrondBalanceRequestJson elrondBalanceRequestJson = FutureUtils.futureResult(elrondBalanceRequestJsonF);
		ElrondLegacyDelegationJson elrondLegacyDelegationJson = FutureUtils.futureResult(elrondLegacyDelegationJsonF);
		ElrondDelegationJson[] elrondDelegationsJson = FutureUtils.futureResult(elrondDelegationsJsonF);

		return BuildElrondBalance.build(elrondBalanceRequestJson, elrondLegacyDelegationJson, elrondDelegationsJson);
	}

}
