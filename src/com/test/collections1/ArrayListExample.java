package com.test.collections1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		list.add("10");
		list.add("11");
		
		list.remove(5);
		list.remove(5);
		list.remove(5);
		list.remove(5);
		list.remove(5);
		list.remove(5);
		
		int newCapacity = 10 + (15 >> 1);
		System.out.println("New capacity : " + (29 >> 1));
		
	}

}
