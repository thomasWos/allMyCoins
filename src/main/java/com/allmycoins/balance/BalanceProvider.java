package com.allmycoins.balance;

import java.util.List;
import java.util.concurrent.Callable;

import com.allmycoins.json.BalanceJson;

public interface BalanceProvider extends Callable<List<BalanceJson>> {

	List<BalanceJson> balances();

	@Override
	default List<BalanceJson> call() throws Exception {
		return balances();
	}

}
