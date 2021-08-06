package com.allmycoins.balance.polkadot;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.RequestUtils;

public final class PolkadotProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "POLKADOT_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		var polkadotAccountJson = RequestUtils.sendRequest(new PolkadotAccountRequest(publicAddress));
		float qty = BigDecimalUtils.decimal(polkadotAccountJson.getData().getAttributes().getBalance_total(), 10);
		return new BalanceJson("DOT", qty, "Polkadot wallet");
	}

}
