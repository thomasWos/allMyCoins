package com.allmycoins.balance.coinspot;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.BalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class CoinspotProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		Optional<String> coinspotApiKeyOpt = PrivateConfig.get("COINSPOT_API_KEY");
		Optional<String> coinspotSecretKeyOpt = PrivateConfig.get("COINSPOT_SECRET_KEY");
		if (coinspotApiKeyOpt.isPresent() && coinspotSecretKeyOpt.isPresent()) {

			String apiKey = coinspotApiKeyOpt.get();
			String secretKey = coinspotSecretKeyOpt.get();

			CoinspotBalancesJson coinspotBalancesJson = RequestUtils
					.sendRequest(new CoinspotBalancesRequest(apiKey, secretKey));
			return BuildCoinspotBalances.build(coinspotBalancesJson);
		}

		return Collections.emptyList();
	}

}
