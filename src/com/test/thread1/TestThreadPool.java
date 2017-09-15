package com.test.thread1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		Runnable r1 = new WorkerThread();
		Runnable r2 = new WorkerThread();
		Runnable r3 = new WorkerThread();
		Runnable r4 = new WorkerThread();
		Runnable r5 = new WorkerThread();
		service.execute(r1);service.execute(r2);service.execute(r3);service.execute(r4);service.execute(r5);
		
		
		
		service.execute(r5);
		service.shutdown();
		//service.execute(r1);
		
	}

}

class WorkerThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "Therad START");
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "Therad END");
	}
	
}