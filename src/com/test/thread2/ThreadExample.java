package com.test.thread2;

import com.test.Util;

public class ThreadExample {
	
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.start();
		//t1.run();
		System.out.println("Thread main  : " + Thread.currentThread().getName());
		System.out.println("Thread main  : " + Thread.currentThread().getThreadGroup());
		
		Thread t2 = new Thread(new Thread2());
		t2.start();
		
		Thread t3 = new Thread(new Runnable(){
			@Override
			public void run() {
				Util.sleep(8000);
			}
		});
		t3.start();
		
		
		
		Thread t4 = new Thread(()->{
			System.out.println("Thread t3 : " + Thread.currentThread());
			Util.sleep(5000);
		});
		t4.start();
		
		
	}
	
	static class Thread1 extends Thread{
		@Override
		public void run(){
			System.out.println(" I am in run method..");
			Util.sleep(5000);
			System.out.println("Thread : " + Thread.currentThread().getName());
			System.out.println("Thread : " + Thread.currentThread().getThreadGroup());
			
		}
	}
	
	static class Thread2 implements Runnable {

		@Override
		public void run() {
             System.out.println(" I am in run method : " + Thread.currentThread());			
		}
		
	}
	
	

}
