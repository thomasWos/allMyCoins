package com.allmycoins.balance.okex;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.BalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public class OkexProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		Optional<String> apiKeyOpt = PrivateConfig.get("OKEX_API_KEY");
		Optional<String> secretKeyOpt = PrivateConfig.get("OKEX_SECRET_KEY");
		Optional<String> passphraseOpt = PrivateConfig.get("OKEX_PASSPHRASE");

		if (apiKeyOpt.isPresent() && secretKeyOpt.isPresent() && passphraseOpt.isPresent()) {
			String apiKey = apiKeyOpt.get();
			String secretKey = secretKeyOpt.get();
			String passphrase = passphraseOpt.get();

			OkexSpotAccountJson[] okexSpotAccountsJson = RequestUtils
					.sendRequest(new OkexSpotAccountRequest(apiKey, secretKey, passphrase));
			return BuildOkexSpotBalances.build(okexSpotAccountsJson);
		}

		return Collections.emptyList();
	}

}
