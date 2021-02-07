package com.allmycoins.balance;

import java.util.List;

import com.allmycoins.json.BalanceJson;

public interface PublicAddressSingleBalanceProvider extends PublicAddressBalanceProvider {

	@Override
	default List<BalanceJson> balance(String publicAddress) {
		return List.of(singleBalance(publicAddress));
	}

	BalanceJson singleBalance(String publicAddress);

}
