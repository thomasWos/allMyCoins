package com.allmycoins.balance.cardano;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.RequestUtils;

public final class CardanoProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "CARDANO_STAKE_KEY";
	}

	@Override
	public BalanceJson singleBalance(String stakeKey) {
		CardanoBalanceJson balanceJson = RequestUtils.sendRequest(new CardanoAccountRequest(stakeKey));
		float qty = BigDecimalUtils.decimal(balanceJson.getControlled_amount(), 6);
		return new BalanceJson("ADA", qty, "Cardano wallet");
	}

}
