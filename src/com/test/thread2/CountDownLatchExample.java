package com.test.thread2;

import java.util.concurrent.CountDownLatch;

import com.test.Util;

public class CountDownLatchExample {

	public static void main(String[] args) {

		CustomCountDownLatch latch = new CustomCountDownLatch(2);
		Thread t1 = new Thread(new Thread1(latch), "Thread1");
		Thread t2 = new Thread(new Thread2(latch), "Thread2");
		t1.start();
		t2.start();
		try {
			latch.await();
			System.out.println("All tasks are finished...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	static class Thread1 implements Runnable {
		CustomCountDownLatch latch;
		Thread1(CustomCountDownLatch latch){
			this.latch=latch;
		}
		@Override
		public void run() {
          System.out.println(Thread.currentThread().getName() +" - START - count " + latch.getCount());
             Util.sleep(3000);
             latch.countDown();
          System.out.println(Thread.currentThread().getName() +" - END- count " + latch.getCount());
         
		}
	}
	static class Thread2 implements Runnable {
		CustomCountDownLatch latch;
		Thread2(CustomCountDownLatch latch){
			this.latch=latch;
		}
		
		@Override
		public void run() {
          System.out.println(Thread.currentThread().getName() +" - START- count " + latch.getCount());
             Util.sleep(10000);
             latch.countDown();
          System.out.println(Thread.currentThread().getName() +" - END- count " + latch.getCount());
          
		}
	}
	
}
