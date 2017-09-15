package com.test.thread2;

import java.util.LinkedList;
import java.util.List;

public class CustomBlockingQueue<T> {

	private List<T> sharedQueue;
	private int maxSize;
	private int count=0;
	
	Object monitor = new Object();

	public CustomBlockingQueue(int maxSize) {
		sharedQueue = new LinkedList<>();
		this.maxSize = maxSize;
	}

	public  void put(T val) {
		synchronized(monitor) {
		if (count > maxSize) {
			try {
				monitor.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		sharedQueue.add(val);
		count++;
		monitor.notifyAll();
		}
	}

	public T take() {
		T t;
		synchronized(monitor) {
		if (count == 0) {
			try {
				monitor.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		t = sharedQueue.remove(0);
		count--;
		monitor.notifyAll();
		}
		return t;

	}

	public int size() {
		return sharedQueue.size();
	}

	

}
