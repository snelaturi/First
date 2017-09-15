package com.test.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExample {

	public static void main(String[] args) {
		
		
		List<Integer> list = Arrays.asList(1,5,6,7,4,4,4,5,6);
		
		long value = list.stream().filter(x -> x > 4).count();
		System.out.println("count :" + value);
		
		 
		List<?> list1 = new ArrayList<Integer>();
		
		for( int i =1; i<=100000;i++) {
			
		}

	}

}
