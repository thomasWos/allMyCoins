package com.allmycoins.balance.solana;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class SolanaProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "SOLANA_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		SolanaBalanceJson solanaBalanceJson = RequestUtils.sendRequest(new SolanaBalanceRequest(publicAddress));
		return BuildSolanaBalance.build(solanaBalanceJson);
	}
}
