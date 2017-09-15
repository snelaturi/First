package com.test.thread1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSequnce {

	public static void main(String[] args) {

		AtomicInteger sharedOutput = new AtomicInteger(0);
		
		Thread t1 = new Thread(new MyThread6(0, sharedOutput), "Thread1");
		Thread t2 = new Thread(new MyThread6(1, sharedOutput), "Thread2");
		Thread t3 = new Thread(new MyThread6(2, sharedOutput), "Thread3");
		
		t1.start();
		t2.start();
		t3.start();

	}
}

class MyThread6 implements Runnable {
	private AtomicInteger sharedOutput;

	private final int threadPosition;

	public MyThread6(int threadPosition, AtomicInteger sharedOutput) {
		this.threadPosition = threadPosition;
		this.sharedOutput = sharedOutput;
	}

	@Override
	public void run() {
		while (sharedOutput.get() < 100) {

			synchronized (sharedOutput) {

				if (sharedOutput.get() % 3 == this.threadPosition) {

					if (sharedOutput.get() < 100)
						System.out.println(Thread.currentThread().getName() + "  " + sharedOutput.incrementAndGet());
				}
			}
		}
	}
}
