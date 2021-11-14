package com.allmycoins.balance.avalanche;

import java.util.List;

import com.allmycoins.balance.PublicAddressBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.RequestUtils;

public final class AvalancheProvider implements PublicAddressBalanceProvider {

	@Override
	public List<BalanceJson> balance(String publicAddress) {
		AvalancheBalanceJson avalancheBalance = RequestUtils.sendRequest(new AvalancheBalanceRequest(publicAddress));
		float qty = BigDecimalUtils.decimal18(avalancheBalance.getResult());
		BalanceJson balance = new BalanceJson("AVAX", qty, "Avalanche C");
		return List.of(balance);
	}

	@Override
	public String privateConfigKey() {
		return "AVALANCHE_C_ADDRESS";
	}

}
