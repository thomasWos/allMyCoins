package com.allmycoins.balance;

import java.util.concurrent.Future;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.solana.SolanaBalanceJson;
import com.allmycoins.pc.BuildSolanaBalance;
import com.allmycoins.request.solana.SolanaBalanceRequest;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class SolanaProvider implements PublicAddressBalanceProvider {

	@Override
	public BalanceJson balance(String publicAddress) {

		Future<SolanaBalanceJson> solanaBalanceJsonF = RequestUtils
				.sendRequestFuture(new SolanaBalanceRequest(publicAddress));

		SolanaBalanceJson solanaBalance = FutureUtils.futureResult(solanaBalanceJsonF);

		return BuildSolanaBalance.build(solanaBalance);
	}

	@Override
	public String privateConfigKey() {
		return "SOLANA_ADDRESS";
	}

}
