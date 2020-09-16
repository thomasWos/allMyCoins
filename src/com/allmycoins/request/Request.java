package com.allmycoins.request;

import java.util.Map;

public interface Request<T> {

	/**
	 * Request base url;
	 * 
	 * @return request base url
	 */
	String baseUrl();

	/**
	 * The enpoint. e.g /api/v3/ticker/price"
	 * 
	 * @return the enpoint
	 */
	String endPoint();

	/**
	 * Headers for the request.
	 * 
	 * @return the headers for the request.
	 */
	Map<String, String> headers();

	/**
	 * Class for the response.
	 * 
	 * @return class for the response
	 */
	Class<T> jsonResponseClass();

}
