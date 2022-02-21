package com.allmycoins.balance.avalanche;

import java.util.ArrayList;
import java.util.List;

import com.allmycoins.balance.PublicAddressBalanceProvider;
import com.allmycoins.balance.etherscan.SingleBalanceJson;
import com.allmycoins.balance.etherscan.TokenTxResultJson;
import com.allmycoins.balance.etherscan.TxToBalances;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.RequestUtils;

public final class AvalancheProvider implements PublicAddressBalanceProvider {

	@Override
	public List<BalanceJson> balance(String publicAddress) {

		// Single AVAX balance
		SingleBalanceJson avalancheBalance = RequestUtils.sendRequest(new AvalancheBalanceRequest(publicAddress));
		float qty = BigDecimalUtils.decimal18(avalancheBalance.getResult());
		BalanceJson balance = new BalanceJson("AVAX", qty, "Avalanche C");

		// Tokens
		TokenTxResultJson tokenTxResultJson = RequestUtils.sendRequest(new AvalancheTokenTxRequest(publicAddress));
		List<BalanceJson> tokenBalances = TxToBalances.txToBalances(tokenTxResultJson, publicAddress, "Avalanche C");

		List<BalanceJson> balances = new ArrayList<>();
		balances.add(balance);
		balances.addAll(tokenBalances);
		return balances;
	}

	@Override
	public String privateConfigKey() {
		return "AVALANCHE_C_ADDRESS";
	}

}
