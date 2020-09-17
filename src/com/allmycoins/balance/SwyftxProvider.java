package com.allmycoins.balance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.swyftx.SwyftxAccessTokenJson;
import com.allmycoins.json.swyftx.SwyftxBalanceJson;
import com.allmycoins.json.swyftx.SwyftxMarketAssetJson;
import com.allmycoins.pc.BuildSwyftxBalances;
import com.allmycoins.request.swyftx.SwyftxBalancesRequest;
import com.allmycoins.request.swyftx.SwyftxLogoutRequest;
import com.allmycoins.request.swyftx.SwyftxMarketAssetsRequest;
import com.allmycoins.request.swyftx.SwyftxRefreshRequest;
import com.allmycoins.utils.RequestUtils;

public final class SwyftxProvider implements BalanceProvider {

	private static final String APP_ACCOUNT_BALANCE_PERMISSION = "app.account.balance";
	private static final Logger LOGGER = Logger.getLogger(SwyftxProvider.class.getName());
	private static final Predicate<SwyftxBalanceJson> NOT_EMPTY = b -> b.getAvailableBalance() != 0.0;

	@Override
	public List<BalanceJson> balances() {

		List<BalanceJson> swyftxBalances = Collections.emptyList();

		Optional<String> swyftxApiKeyOpt = PrivateConfig.get("SWYFTX_API_KEY");
		if (swyftxApiKeyOpt.isPresent()) {

			String swyftxApiKey = swyftxApiKeyOpt.get();

			SwyftxAccessTokenJson accessToken = RequestUtils.sendRequest(new SwyftxRefreshRequest(swyftxApiKey));

			String token = accessToken.getAccessToken();
			if (accessToken.getScope().contains(APP_ACCOUNT_BALANCE_PERMISSION)) {
				/* All Swyftx balances, by asset id. */
				List<SwyftxBalanceJson> balancesJson = Arrays
						.asList(RequestUtils.sendRequest(new SwyftxBalancesRequest(token)));

				balancesJson = balancesJson.stream().filter(NOT_EMPTY).collect(Collectors.toList());

				Set<Integer> balancesAssetIds = balancesJson.stream().filter(NOT_EMPTY)
						.map(SwyftxBalanceJson::getAssetId).collect(Collectors.toSet());

				/* All Swyftx market assets. */
				List<SwyftxMarketAssetJson> marketAssetsJson = Arrays
						.asList(RequestUtils.sendRequest(new SwyftxMarketAssetsRequest()));

				/* Ids to symbol of market assets that are part of the balances. */
				Map<Integer, String> assetToSymbolMap = marketAssetsJson.stream()
						.filter(a -> balancesAssetIds.contains(a.getId()))
						.collect(Collectors.toMap(SwyftxMarketAssetJson::getId, SwyftxMarketAssetJson::getCode));

				return BuildSwyftxBalances.build(balancesJson, assetToSymbolMap);

			} else {
				LOGGER.warning("Swyftx key permissions invalid.");
			}

			RequestUtils.sendRequest(new SwyftxLogoutRequest(token));
			return swyftxBalances;
		}

		return swyftxBalances;
	}

}
