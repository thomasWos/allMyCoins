package com.allmycoins.balance.avalanche;

import com.allmycoins.balance.covalent.CovalentProvider;

public final class AvalancheProvider extends CovalentProvider {

	public AvalancheProvider() {
		super("Avalanche C wallet", "avalanche-mainnet", "AVALANCHE_C_ADDRESS");
	}
}
