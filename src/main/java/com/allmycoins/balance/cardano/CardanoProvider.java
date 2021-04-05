package com.allmycoins.balance.cardano;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class CardanoProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "CARDANO_STAKE_KEY";
	}

	@Override
	public BalanceJson singleBalance(String stakeKey) {
		CardanoBalanceJson balanceJson = RequestUtils.sendRequest(new CardanoAccountRequest(stakeKey));
		return BuildCardanoBalance.build(balanceJson);
	}

}
