package com.test.thread2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedThreadPool {

	public static void main(String[] args) {

	
		Thread task = new Thread(()-> {
			System.out.println("Thread : " + Thread.currentThread().getName());
		});
		
		ScheduledExecutorService schedulor = Executors.newSingleThreadScheduledExecutor();
		schedulor.scheduleAtFixedRate(task, 0, 20, TimeUnit.SECONDS);

        schedulor.submit(task);
        schedulor.submit(task);
        schedulor.submit(task);schedulor.submit(task);
		
		schedulor.shutdown();
	}
	
	
}
