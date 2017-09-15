package com.test.collections1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class FailFastDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(2);
		list.add(6);
		list.add(2);
		
		Iterator<Integer> itr1 = list.iterator();
		Iterator<Integer> itr2 = list.iterator();
		
		itr1.next();
		itr2.remove();
		itr1.next();
		while(itr1.hasNext()) {
			
		}
		
		
		//Thread t1 = new Thread(new MyThread(list,true));
		//Thread t2 = new Thread(new MyThread(list,false));
		
		//t1.start();
		//t2.start();
	}

}

class MyThread implements Runnable {
	private Vector<Integer> integerList;
	private boolean isWrite;
	MyThread(Vector<Integer> integerList, boolean isWrite){
		this.integerList=integerList;
		this.isWrite=isWrite;
	}

	@Override
	public void run() {
		if(isWrite){
			integerList.add(2);	
			System.out.println("write");
		} else {
			integerList.remove(0);
			System.out.println("read");
		}
		
	}
	
}
