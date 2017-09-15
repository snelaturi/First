package com.test.collections1;

import java.util.ArrayList;
import java.util.Iterator;

public class FailFastDemo1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			list.remove(2);
		}

	}

}
