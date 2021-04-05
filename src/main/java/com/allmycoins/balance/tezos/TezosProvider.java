package com.allmycoins.balance.tezos;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class TezosProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "TEZOS_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		TezosBalanceJson tezosBalanceJson = RequestUtils.sendRequest(new TezosBalanceRequest(publicAddress));
		return BuildTezosBalance.build(tezosBalanceJson);
	}

}
