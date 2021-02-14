package com.allmycoins.balance;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.tezos.TezosBalanceJson;
import com.allmycoins.pc.BuildTezosBalance;
import com.allmycoins.request.tezos.TezosBalanceRequest;
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
