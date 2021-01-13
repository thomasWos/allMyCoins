package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;

public interface PublicAddressBalanceProvider extends BalanceProvider {

	BalanceJson balance(String publicAddress);

	@Override
	default List<BalanceJson> balances() {
		List<String> addList = PrivateConfig.get(privateConfigKey()).map(s -> List.of(s.split(",")))
				.orElseGet(Collections::emptyList);
		return addList.parallelStream().map(a -> balance(a.trim())).collect(Collectors.toList());
	}

	String privateConfigKey();

}
