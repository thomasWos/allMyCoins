package com.allmycoins.request.swyftx;

import static com.allmycoins.request.swyftx.SwyftxRefreshRequest.SWYFTX_URL;

import java.util.Map;

import com.allmycoins.json.swyftx.SwyftxMarketAssetJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.RequestUtils;

public final class SwyftxMarketAssetsRequest implements GetRequest<SwyftxMarketAssetJson[]> {

	public SwyftxMarketAssetsRequest() {
		/* Empty. */
	}

	@Override
	public String baseUrl() {
		return SWYFTX_URL;
	}

	@Override
	public String endPoint() {
		return "/markets/assets/";
	}

	@Override
	public Map<String, String> headers() {
		return RequestUtils.DEFAULT_JSON_HEADER;
	}

	@Override
	public Class<SwyftxMarketAssetJson[]> jsonResponseClass() {
		return SwyftxMarketAssetJson[].class;
	}

	@Override
	public String parameters() {
		return "";
	}
}
