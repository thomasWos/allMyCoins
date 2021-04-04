package com.allmycoins.balance;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.cardano.CardanoBalanceJson;
import com.allmycoins.pc.BuildCardanoBalance;
import com.allmycoins.request.cardano.CardanoAccountRequest;
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
