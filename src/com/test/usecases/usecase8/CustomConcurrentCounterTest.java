package com.test.usecases.usecase8;

public class CustomConcurrentCounterTest {

	public static void main(String[] args) {
		
		CustomConcurrentCounter counter = new CustomConcurrentCounter();
		 
		Thread t1 = new Thread(new Incrementer(counter));
		Thread t2 = new Thread(new Incrementer(counter));
		Thread t3 = new Thread(new Incrementer(counter));
		
		t1.start();
		t2.start();
		t3.start();
			t1.interrupt();
			t2.interrupt();
			t3.interrupt();
		}
	}

	class Incrementer implements Runnable{
		CustomConcurrentCounter counter;
		Incrementer(CustomConcurrentCounter counter ){
			this.counter= counter;
		}
		@Override
		public void run() {
			while(!Thread.interrupted()){
				counter.increment();
				System.out.println("After increment: "+counter.getCount());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
			
		}
		
	}