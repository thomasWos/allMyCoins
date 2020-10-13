package com.allmycoins.utils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.allmycoins.exception.AllMyCoinsException;

public final class FutureUtils {

	public static <E> List<E> futureResult(Future<List<E>> pFuture) {
		try {
			return pFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new AllMyCoinsException("Error getting future result: " + e.getMessage());
		}
	}

	public static <E> List<Future<E>> invokeAllCallables(List<? extends Callable<E>> balanceProviders) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		List<Future<E>> balanceFutures = Collections.emptyList();
		try {
			balanceFutures = cachedThreadPool.invokeAll(balanceProviders);
		} catch (InterruptedException e) {
			throw new AllMyCoinsException("Error cachedThreadPool: " + e.getMessage());
		}
		return balanceFutures;
	}

}
