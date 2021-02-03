package com.allmycoins.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.allmycoins.exception.AllMyCoinsException;

public final class FutureUtils {

	public static <E> E futureResult(Future<E> pFuture) {
		try {
			return pFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new AllMyCoinsException("Error getting future result: " + e);
		}
	}

	public static <E> List<Future<E>> runAllCallables(List<? extends Callable<E>> pCallables) {
		List<Future<E>> balanceFutures = new ArrayList<>();
		pCallables.forEach(c -> balanceFutures.add(runCallable(c)));
		return balanceFutures;
	}

	public static <E> Future<E> runCallable(Callable<E> pCallable) {
		FutureTask<E> futureTask = new FutureTask<>(pCallable);
		Thread t = new Thread(futureTask);
		t.start();
		return futureTask;
	}

}
