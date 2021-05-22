package com.allmycoins.balance.okex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.BalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class OkexProvider implements BalanceProvider {

	private static final Predicate<OkexBalanceJson> QTY_PREDICATE = s -> s.getAvailBal() > 0.001;

	@Override
	public List<BalanceJson> balances() {
		Optional<String> apiKeyOpt = PrivateConfig.get("OKEX_API_KEY");
		Optional<String> secretKeyOpt = PrivateConfig.get("OKEX_SECRET_KEY");
		Optional<String> passphraseOpt = PrivateConfig.get("OKEX_PASSPHRASE");

		if (apiKeyOpt.isPresent() && secretKeyOpt.isPresent() && passphraseOpt.isPresent()) {
			String apiKey = apiKeyOpt.get();
			String secretKey = secretKeyOpt.get();
			String passphrase = passphraseOpt.get();

			OkexResponseJson okexResponseJson = RequestUtils
					.sendRequest(new OkexUnifiedAccountRequest(apiKey, secretKey, passphrase));

			OkexBalanceJson[] balances = okexResponseJson.getData()[0].getDetails();
			return Arrays.stream(balances).filter(QTY_PREDICATE).map(this::build).collect(Collectors.toList());
		}

		return Collections.emptyList();
	}

	private BalanceJson build(OkexBalanceJson okexBalanceJson) {
		String currency = okexBalanceJson.getCcy();
		float qty = okexBalanceJson.getAvailBal();
		return new BalanceJson(currency, qty, "OKEX");
	}
}
