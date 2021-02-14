package com.allmycoins.balance;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.solana.SolanaBalanceJson;
import com.allmycoins.pc.BuildSolanaBalance;
import com.allmycoins.request.solana.SolanaBalanceRequest;
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
