package com.allmycoins.balance;

import java.util.List;

import com.allmycoins.json.BalanceJson;

public interface BalanceProvider {

	List<BalanceJson> balances();

}
