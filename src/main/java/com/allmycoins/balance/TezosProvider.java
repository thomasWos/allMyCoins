package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.tezos.TezosBalanceJson;
import com.allmycoins.pc.BuildTezosBalance;
import com.allmycoins.request.tezos.TezosBalanceRequest;
import com.allmycoins.utils.RequestUtils;

public final class TezosProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		return PrivateConfig.get("TEZOS_ADDRESS").map(this::tezosBalance).map(List::of)
				.orElseGet(Collections::emptyList);
	}

	private BalanceJson tezosBalance(String tezosAddress) {
		TezosBalanceJson tezosBalanceJson = RequestUtils.sendRequest(new TezosBalanceRequest(tezosAddress));
		return BuildTezosBalance.build(tezosBalanceJson);
	}

}
