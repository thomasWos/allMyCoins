package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.cryptocom.CryptoComAccountSummaryJson;
import com.allmycoins.pc.BuildCryptoComBalances;
import com.allmycoins.request.cryptocom.CryptoComAccountSummaryRequest;
import com.allmycoins.utils.RequestUtils;

public final class CryptocomProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		Optional<String> apiKeyOpt = PrivateConfig.get("CRYPTO_COM_API_KEY");
		Optional<String> secretKeyOpt = PrivateConfig.get("CRYPTO_COM_SECRET_KEY");
		if (apiKeyOpt.isPresent() && secretKeyOpt.isPresent()) {

			String apiKey = apiKeyOpt.get();
			String secretKey = secretKeyOpt.get();

			// crypto.com - Exchanger only
			CryptoComAccountSummaryJson cryptoComAccountSummaryJson = RequestUtils
					.sendRequest(new CryptoComAccountSummaryRequest(apiKey, secretKey));
			return BuildCryptoComBalances.build(cryptoComAccountSummaryJson);
		}

		return Collections.emptyList();
	}

}
