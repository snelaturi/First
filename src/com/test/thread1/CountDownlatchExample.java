package com.test.thread1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import com.test.Util;

public class CountDownlatchExample {

	public static void main(String[] args) {
		
		//CyclicBarrier barrier = new CyclicBarrier(2);
		
		
		CountDownLatch latch = new CountDownLatch(2);
		Thread supervisor = new Thread(new Supervisor(latch));
		
		Thread worker1 = new Thread(new Worker1(latch,1));
		Thread worker2 = new Thread(new Worker1(latch,2));
		Thread worker3 = new Thread(new Worker1(latch,3));
		Thread worker4 = new Thread(new Worker1(latch,4));
		Thread worker5 = new Thread(new Worker1(latch,5));
		Thread worker6 = new Thread(new Worker1(latch,6));
		supervisor.start();
		worker1.start();worker2.start();worker3.start();
		worker4.start();worker5.start();worker6.start();
		
		System.out.println(" main end");
	}

}

class Worker1 implements Runnable {
	CountDownLatch latch;
	int workerIdentifier;

	public Worker1(CountDownLatch latch, int workerIdentifier) {
		this.latch = latch;
		this.workerIdentifier = workerIdentifier;
	}

	public void run() {
		System.out.println("In worker: " + workerIdentifier );
		
		System.out.println("latch count : " + latch.getCount() );
		Util.sleep(5000);
		latch.countDown();
	}

}

class Supervisor implements Runnable {
	CountDownLatch latch;

	public Supervisor(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			System.out.println("waiting for worker task to finish");
			latch.await();
		} catch (InterruptedException e) {
			System.out.println("Error: ");
			e.printStackTrace();
		}
		System.out.println("All worker task completed");
	}
}