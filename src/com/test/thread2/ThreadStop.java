package com.test.thread2;

import com.test.Util;

public class ThreadStop {

	public static void main(String[] args) {
		Processor target = new Processor();
		Thread t1 = new Thread(target, "RunningThread");
		t1.start();
		Util.sleep(2000);
		target.stop();
	}

}

class Processor implements Runnable {
	private boolean isRunning = true;

	public void stop() {
		isRunning = false;
	}

	@Override
	public void run() {
		while (isRunning) {
			System.out.println(Thread.currentThread() + " Running.... ");
		}
		System.out.println("Stopped running..");
	}

}
