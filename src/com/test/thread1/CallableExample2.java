package com.test.thread1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(1);
		Future<Integer> future = pool.submit(new CallableThread("abcdefafafasfdaf"));
		
		System.out.println(future.get());
		pool.shutdown();
		
	}
	
	public static class CallableThread implements Callable<Integer> {

		String value;
		
		CallableThread(String value) {
			this.value=value;
		}
		
		@Override
		public Integer call() throws Exception {
			Thread.sleep(5000);
			return Integer.valueOf(value.length());
		}
		
	}

}
