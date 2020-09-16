package com.allmycoins.request;

public interface PostRequest<T> extends Request<T> {

	String body();

}
