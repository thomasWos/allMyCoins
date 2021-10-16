package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;

public interface PublicAddressBalanceProvider extends BalanceProvider {

	List<BalanceJson> balance(String publicAddress);

	@Override
	default List<BalanceJson> balances() {
		List<String> addressList = PrivateConfig.get(privateConfigKey()).map(s -> List.of(s.split(",")))
				.orElseGet(Collections::emptyList);
		return addressList.parallelStream().map(address -> balance(address.trim())).flatMap(List::stream)
				.collect(Collectors.toList());
	}

	String privateConfigKey();

}
