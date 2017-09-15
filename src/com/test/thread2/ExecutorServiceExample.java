package com.test.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.test.Util;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		
		//ExecutorService executor = Executors.newFixedThreadPool(2);
		
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		
		//ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		//scheduler.scheduleAtFixedRate(command, initialDelay, period, unit)
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=1; i<=10; i++) {
			Runnable r1 = new Task();
			executor.execute(r1);
			//scheduler.execute(r1);
		}
		
		/*Runnable r1 = new Task();
		
		executor.execute(r1 );
		executor.execute(r1 );
		executor.execute(r1 );
		executor.execute(r1 );
		executor.execute(r1 );
		executor.execute(r1 );*/
		
		executor.shutdown();

	
	}
	
	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("Thread : " + Thread.currentThread().getName());
			Util.sleep(2000);
		}
		
	}

}
