package com.test.usecases.usecase3;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	 static LinkedList list = new LinkedList();
	    static Semaphore consumer = new Semaphore(0);
	    static Semaphore producer = new Semaphore(1);

	    static class Consumer extends Thread {
	        String name;
	        public Consumer(String name) {
	            this.name = name;
	        }
	        public void run() {
	            try {
	                while (true) {
	                    consumer.acquire(1);
	                    producer.acquire();
	                    System.out.println("Consumer name=\""+name+"\" consumed: "+list.removeFirst());
	                    producer.release();
	                }
	            } catch (Exception x) {
	                x.printStackTrace();
	            }
	        }
	    }

	    static class Producer extends Thread {
	        public void run() {
	            try {
	                int i = 1;
	                while (true) {
	                    producer.acquire();
	                    list.add(new Integer(i++));
	                    System.out.println("produced item="+list);
	                    producer.release();
	                    consumer.release(1);
	                    Thread.sleep(500);
	                }
	            } catch (Exception x) {
	                x.printStackTrace();
	            }
	        }
	    }

	    public static void main(String [] args) {
	        new Producer().start();
	        new Consumer("Alice").start();
	        new Consumer("Bob").start();
	        new Consumer("Sumit").start();
	        new Consumer("Sumit2").start();
	        new Consumer("Sumit3").start();
	        new Consumer("Sumit4").start();
	    }	

}
