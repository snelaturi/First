package com.test.thread1;

import java.util.concurrent.atomic.AtomicInteger;

public class CustomAtomicInteger extends Object {

	public static void main(String[] args) {

		AtomicInteger atomic = new AtomicInteger();
		int expect =0;
		int update =0;
		System.out.println(atomic.compareAndSet(expect, update));
		
	}

}

class Increment {
	int count;

	public int setCount(){
		AtomicInteger atomic = new AtomicInteger();
		int expect =1;
		int update =2;
		System.out.println(atomic.compareAndSet(expect, update));
		return 1;
	}
	
	public int getCount() {
		return this.count;
	}

}
