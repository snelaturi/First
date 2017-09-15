package com.test.thread2;

import com.test.Util;

public class CustomBlockingQueueTest {

	public static void main(String[] args) {

		CustomBlockingQueue<Integer> cbq = new CustomBlockingQueue<>(2);
		
		Thread producer = new Thread(new Producer(cbq),"Producer");
		Thread consumer = new Thread(new Consumer(cbq),"Consumer");
		producer.start();
		consumer.start();
		
	}

}

class Producer implements Runnable {
	CustomBlockingQueue<Integer> cbq;
	Producer(CustomBlockingQueue<Integer> cbq){
		this.cbq=cbq;
	}
	@Override
	public void run() {
        for(int i =1;i<=10;i++) {
        	System.out.println(Thread.currentThread().getName() +"  produced " + i);
        	cbq.put(i);
        	Util.sleep(000);
        }
	}
	
}

class Consumer implements Runnable {
	CustomBlockingQueue<Integer> cbq;
	Consumer(CustomBlockingQueue<Integer> cbq){
		this.cbq=cbq;
	}
	@Override
	public void run() {
        while(true) {
        	Integer val = cbq.take();
        	System.out.println(Thread.currentThread().getName() +"  consumed " + val);
        }
	}
	
}
