package com.allmycoins.balance.ethereum;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.allmycoins.balance.PublicAddressBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class EthProvider2 implements PublicAddressBalanceProvider {

	@Override
	public List<BalanceJson> balance(String publicAddress) {
		Future<CovalentBalancesJson> futureAmberdataEthTokensJson = RequestUtils
				.sendRequestFuture(new CovalentBalancesRequest(publicAddress));

		CovalentBalancesJson covalentBalancesJson = FutureUtils.futureResult(futureAmberdataEthTokensJson);

		List<CovalentBalanceItemJson> list = List.of(covalentBalancesJson.getData().getItems());

		return list.stream()
				.map(i -> new BalanceJson(i.getContract_ticker_symbol(),
						BigDecimalUtils.decimal(i.getBalance(), i.getContract_decimals()), "ETH wallet"))
				.collect(Collectors.toList());
	}

	@Override
	public String privateConfigKey() {
		return "ETH_ADDRESS";
	}
}
