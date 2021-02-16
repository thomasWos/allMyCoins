package com.allmycoins.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.allmycoins.exception.AllMyCoinsException;
import com.allmycoins.request.GetRequest;
import com.allmycoins.request.PostRequest;

public final class RequestUtils {

	private static final Logger LOGGER = Logger.getLogger(RequestUtils.class.getName());

	private static final int TOO_MANY_REQUESTS = 429;

	public static final String CONTENT_TYPE = "Content-Type";
	public static final String APP_JSON = "application/json";
	public static final Map<String, String> DEFAULT_JSON_HEADER = Map.of(CONTENT_TYPE, APP_JSON);

	public static String buildParameters(Map<String, String> parametersMap) {
		return parametersMap.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue())
				.collect(Collectors.joining("&"));
	}

	public static <T> T sendRequest(GetRequest<T> request) {

		String paramStr = request.parameters();

		paramStr = !paramStr.isEmpty() ? "?" + paramStr : "";
		String url = request.baseUrl() + request.endPoint() + paramStr;
		LOGGER.info(() -> "Send GET request URL: " + url);

		Builder requestBuilder = HttpRequest.newBuilder().uri(buildUrl(url)).GET();
		request.headers().forEach(requestBuilder::setHeader);

		// Sync request
		HttpResponse<String> response = httpRequest(requestBuilder);

		int statusCode = response.statusCode();
		LOGGER.info(() -> "Response code: " + statusCode + " - " + request.getClass().getSimpleName());
		if (statusCode == TOO_MANY_REQUESTS) {
			LOGGER.info(response::body);
			// Wait and try again
			SleepUtils.sleep(1000);
			return sendRequest(request);

		}
		LOGGER.fine(response::body);
		return JacksonUtils.deserialize(response.body(), request.jsonResponseClass());
	}

	public static <T> T sendRequest(PostRequest<T> postRequest) {

		String url = postRequest.baseUrl() + postRequest.endPoint();
		LOGGER.info(() -> "Send POST request URL: " + url);

		Builder requestBuilder = HttpRequest.newBuilder().uri(buildUrl(url))
				.POST(HttpRequest.BodyPublishers.ofString(postRequest.body()));
		postRequest.headers().forEach(requestBuilder::setHeader);

		// Sync request
		HttpResponse<String> response = httpRequest(requestBuilder);

		int statusCode = response.statusCode();
		LOGGER.info(() -> "Response code: " + statusCode + " - " + postRequest.getClass().getSimpleName());
		if (statusCode == TOO_MANY_REQUESTS) {
			LOGGER.info(response::body);
			// Try again
			return sendRequest(postRequest);
		}
		return JacksonUtils.deserialize(response.body(), postRequest.jsonResponseClass());
	}

	public static <T> Future<T> sendRequestFuture(GetRequest<T> request) {
		return FutureUtils.runCallable(() -> sendRequest(request));
	}

	public static <T> Future<T> sendRequestFuture(PostRequest<T> request) {
		return FutureUtils.runCallable(() -> sendRequest(request));
	}

	private static URI buildUrl(String url) {
		try {
			return new URI(url);
		} catch (URISyntaxException e) {
			throw new AllMyCoinsException("Error building url: " + e);
		}
	}

	private static HttpResponse<String> httpRequest(Builder requestBuilder) {
		HttpResponse<String> response;
		try {
			response = HttpClient.newBuilder().build().send(requestBuilder.build(), BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			throw new AllMyCoinsException("Error sending http request: " + e);
		}
		return response;
	}

}
