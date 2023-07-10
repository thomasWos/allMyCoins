package com.allmycoins.balance.ethereum;

import com.allmycoins.balance.covalent.CovalentProvider;

public final class EthProvider extends CovalentProvider {

	public EthProvider() {
		super("ETH wallet", "eth-mainnet", "ETH_ADDRESS");
	}
}
