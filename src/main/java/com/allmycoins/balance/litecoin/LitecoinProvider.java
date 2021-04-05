package com.allmycoins.balance.litecoin;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class LitecoinProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "LTC_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		LitecoinBalanceJson litecoinBalanceJson = RequestUtils.sendRequest(new LitecoinBalanceRequest(publicAddress));
		float qty = litecoinBalanceJson.getData()[0].getBalance().floatValue();
		return new BalanceJson("LTC", qty, "LTC wallet");
	}

}
