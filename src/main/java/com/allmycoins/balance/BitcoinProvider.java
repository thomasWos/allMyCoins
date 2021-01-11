package com.allmycoins.balance;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.bitcoin.BitcoinBalanceJson;
import com.allmycoins.pc.BuildBitcoinBalance;
import com.allmycoins.request.bitcoin.BitcoinBalanceRequest;
import com.allmycoins.utils.RequestUtils;

public final class BitcoinProvider implements PublicAddressBalanceProvider {

	@Override
	public BalanceJson balance(String publicAddress) {
		BitcoinBalanceJson bitcoinBalanceJson = RequestUtils.sendRequest(new BitcoinBalanceRequest(publicAddress));
		return BuildBitcoinBalance.build(bitcoinBalanceJson);
	}

	@Override
	public String privateConfigKey() {
		return "BTC_ADDRESS";
	}

}
