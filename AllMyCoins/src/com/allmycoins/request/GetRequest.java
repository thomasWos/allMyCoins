package com.allmycoins.request;

public interface GetRequest<T> extends Request<T> {

	/**
	 * Parameters as string
	 * 
	 * @return parameters as string
	 */
	String parameters();

}
