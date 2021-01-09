package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.bitcoin.BitcoinBalanceJson;
import com.allmycoins.pc.BuildBitcoinBalance;
import com.allmycoins.request.bitcoin.BitcoinBalanceRequest;
import com.allmycoins.utils.RequestUtils;

public final class BitcoinProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		return PrivateConfig.get("BTC_ADDRESS").map(this::bitcoinBalance).map(List::of)
				.orElseGet(Collections::emptyList);
	}

	private BalanceJson bitcoinBalance(String btcAddress) {
		BitcoinBalanceJson bitcoinBalanceJson = RequestUtils.sendRequest(new BitcoinBalanceRequest(btcAddress));
		return BuildBitcoinBalance.build(bitcoinBalanceJson);
	}

}
