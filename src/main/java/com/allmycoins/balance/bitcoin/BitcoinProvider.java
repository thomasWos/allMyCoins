package com.allmycoins.balance.bitcoin;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class BitcoinProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "BTC_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		BitcoinBalanceJson bitcoinBalanceJson = RequestUtils.sendRequest(new BitcoinBalanceRequest(publicAddress));
		return BuildBitcoinBalance.build(bitcoinBalanceJson);
	}

}
