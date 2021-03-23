package com.allmycoins.balance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.bscscan.BnbBalanceJson;
import com.allmycoins.json.bscscan.BscTokenTxResultJson;
import com.allmycoins.pc.BuildBscBalance;
import com.allmycoins.request.bscscan.BnbBalanceRequest;
import com.allmycoins.request.bscscan.BscTokenTxRequest;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class BscProvider implements PublicAddressBalanceProvider {

	@Override
	public List<BalanceJson> balance(String publicAddress) {

		Future<BnbBalanceJson> futureBnbBalanceJson = RequestUtils
				.sendRequestFuture(new BnbBalanceRequest(publicAddress));

		Future<BscTokenTxResultJson> futuretokenTxResultJson = RequestUtils
				.sendRequestFuture(new BscTokenTxRequest(publicAddress));

		BnbBalanceJson bnbBalanceJson = FutureUtils.futureResult(futureBnbBalanceJson);
		BscTokenTxResultJson tokenTxResultJson = FutureUtils.futureResult(futuretokenTxResultJson);

		List<BalanceJson> balances = new ArrayList<>();
		balances.add(BuildBscBalance.build(bnbBalanceJson));
		balances.addAll(BuildBscBalance.build(tokenTxResultJson, publicAddress));
		return balances;
	}

	@Override
	public String privateConfigKey() {
		return "BSC_ADDRESS";
	}

}
