package com.allmycoins.balance.covalent;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.allmycoins.balance.PublicAddressBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public class CovalentProvider implements PublicAddressBalanceProvider {

	private String balanceSource;
	private String network;
	private String configKey;

	public CovalentProvider(final String pBalanceSource, final String pNetwork, final String pConfigKey) {
		balanceSource = pBalanceSource;
		network = pNetwork;
		configKey = pConfigKey;
	}

	@Override
	public final List<BalanceJson> balance(String publicAddress) {
		Future<CovalentBalancesJson> futureAmberdataEthTokensJson = RequestUtils
				.sendRequestFuture(new CovalentBalancesRequest(network, publicAddress));

		CovalentBalancesJson covalentBalancesJson = FutureUtils.futureResult(futureAmberdataEthTokensJson);

		List<CovalentBalanceItemJson> list = List.of(covalentBalancesJson.getData().getItems());

		return list.stream()
				.map(i -> new BalanceJson(i.getContract_ticker_symbol(),
						BigDecimalUtils.decimal(i.getBalance(), i.getContract_decimals()), balanceSource))
				.collect(Collectors.toList());
	}

	@Override
	public final String privateConfigKey() {
		return configKey;
	}
}
