package com.allmycoins.balance.bsc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import com.allmycoins.balance.PublicAddressBalanceProvider;
import com.allmycoins.balance.etherscan.SingleBalanceJson;
import com.allmycoins.balance.etherscan.TokenTxResultJson;
import com.allmycoins.balance.etherscan.TxToBalances;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class BscProvider implements PublicAddressBalanceProvider {

	@Override
	public List<BalanceJson> balance(String publicAddress) {

		Future<SingleBalanceJson> futureBnbBalanceJson = RequestUtils
				.sendRequestFuture(new BnbBalanceRequest(publicAddress));

		Future<TokenTxResultJson> futuretokenTxResultJson = RequestUtils
				.sendRequestFuture(new BscTokenTxRequest(publicAddress));

		SingleBalanceJson bnbBalanceJson = FutureUtils.futureResult(futureBnbBalanceJson);
		TokenTxResultJson tokenTxResultJson = FutureUtils.futureResult(futuretokenTxResultJson);

		BalanceJson singleBalance = new BalanceJson("BNB", BigDecimalUtils.decimal18(bnbBalanceJson.getResult()),
				"BSC wallet");
		List<BalanceJson> tokenBalances = TxToBalances.txToBalances(tokenTxResultJson, publicAddress, "BSC wallet");

		List<BalanceJson> balances = new ArrayList<>();
		balances.add(singleBalance);
		balances.addAll(tokenBalances);
		return balances;
	}

	@Override
	public String privateConfigKey() {
		return "BSC_ADDRESS";
	}

}
