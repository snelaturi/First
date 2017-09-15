package com.test.thread2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.test.Util;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
			  	System.out.println("STARTED");
			  	Util.sleep(5000);
			  	System.out.println("Barrier completed..");
			}
		};
		
		CyclicBarrier barrier = new CyclicBarrier(3, r);
		
		Thread t1 = new Thread(new Thread1(barrier),"Thread1");
		Thread t2 = new Thread(new Thread2(barrier),"Thread2");
		Thread t3 = new Thread(new Thread1(barrier),"Thread3");
		t1.start();t2.start();t3.start();
		
	}
	
	static class Thread1 implements Runnable {
		CyclicBarrier barrier;
		Thread1(CyclicBarrier barrier){
			this.barrier=barrier;
		}
		@Override
		public void run() {
          System.out.println(Thread.currentThread().getName() +" - START - count ");
             Util.sleep(3000);
             try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
          System.out.println(Thread.currentThread().getName() +" - END- count ");
         
		}
	}
	static class Thread2 implements Runnable {
		CyclicBarrier barrier;
		Thread2(CyclicBarrier barrier){
			this.barrier=barrier;
		}
		
		@Override
		public void run() {
          System.out.println(Thread.currentThread().getName() +" - START- count ");
             Util.sleep(10000);
             try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
          System.out.println(Thread.currentThread().getName() +" - END- count ");
          
		}
	}

}
