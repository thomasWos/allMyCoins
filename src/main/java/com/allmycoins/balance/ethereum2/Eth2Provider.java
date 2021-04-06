package com.allmycoins.balance.ethereum2;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.RequestUtils;

public final class Eth2Provider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "ETH2_0_VALIDATOR_PUBLIC_KEY";
	}

	@Override
	public BalanceJson singleBalance(String publicKey) {
		Eth2BalanceJson eth2BalanceJson = RequestUtils.sendRequest(new Eth2BalanceRequest(publicKey));
		float qty = BigDecimalUtils.decimal(eth2BalanceJson.getData().getBalance(), 9);
		return new BalanceJson("ETH", qty, "ETH2.0");
	}

}
