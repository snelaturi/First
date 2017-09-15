package com.test.thread2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorExample {

	public static void main(String[] args) {
		
		List list = new CopyOnWriteArrayList<>();
		     list.add(10);
		     list.add(20);
		     list.add(30);
		     list.add(40);
		     list.add(50);
		     
		     Iterator itr = list.iterator();
		     
		     while(itr.hasNext() ) {
		    	 System.out.println(itr.next());
		    	 list.add(25);
		    	 //itr.remove();
		    	 //itr.add("45");
		    	 //itr.add(55);
		    	 //list.remove(2);
		     }
		     System.out.println("size : " + list.size());
		     
		     //list.remove(40);
		     
		     

	}

}
