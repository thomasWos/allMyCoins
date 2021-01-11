package com.allmycoins.balance;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.tezos.TezosBalanceJson;
import com.allmycoins.pc.BuildTezosBalance;
import com.allmycoins.request.tezos.TezosBalanceRequest;
import com.allmycoins.utils.RequestUtils;

public final class TezosProvider implements PublicAddressBalanceProvider {

	@Override
	public BalanceJson balance(String publicAddress) {
		TezosBalanceJson tezosBalanceJson = RequestUtils.sendRequest(new TezosBalanceRequest(publicAddress));
		return BuildTezosBalance.build(tezosBalanceJson);
	}

	@Override
	public String privateConfigKey() {
		return "TEZOS_ADDRESS";
	}

}
