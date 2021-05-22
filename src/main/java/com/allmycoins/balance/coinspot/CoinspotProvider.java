package com.allmycoins.balance.coinspot;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Predicate;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.BalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class CoinspotProvider implements BalanceProvider {

	private final Predicate<Entry<String, CoinspotBalanceJson>> IS_AUD_BALANCE = e -> e.getKey().equals("AUD");

	private final Predicate<Entry<String, CoinspotBalanceJson>> POSITIVE_BALANCE = e -> e.getValue()
			.getAudbalance() > 0.01;

	@Override
	public List<BalanceJson> balances() {
		Optional<String> coinspotApiKeyOpt = PrivateConfig.get("COINSPOT_API_KEY");
		Optional<String> coinspotSecretKeyOpt = PrivateConfig.get("COINSPOT_SECRET_KEY");
		if (coinspotApiKeyOpt.isPresent() && coinspotSecretKeyOpt.isPresent()) {

			String apiKey = coinspotApiKeyOpt.get();
			String secretKey = coinspotSecretKeyOpt.get();

			CoinspotBalancesJson coinspotBalancesJson = RequestUtils
					.sendRequest(new CoinspotBalancesRequest(apiKey, secretKey));

			return build(coinspotBalancesJson);
		}
		return Collections.emptyList();
	}

	public final List<BalanceJson> build(CoinspotBalancesJson coinspotBalancesJson) {
		return coinspotBalancesJson.getBalances().stream().map(m -> m.entrySet().iterator().next())
				.filter(IS_AUD_BALANCE.negate().and(POSITIVE_BALANCE)).map(e -> toBalalance(e.getKey(), e.getValue()))
				.collect(toList());
	}

	private BalanceJson toBalalance(String symbol, CoinspotBalanceJson coinspotBalanceJson) {
		return new BalanceJson(symbol, coinspotBalanceJson.getBalance(), "Coinspot");
	}
}
