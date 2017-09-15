package com.test.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> System.out.println("am in run method"));
		t1.start();
		
		
		List<Integer> list = Arrays.asList(1,2,3,5,7,8,9);
		
		//list.forEach(() -> System.out.println());
		
		list.forEach(System.out::println);
		
		
		
		
	}

}

class MyClass {
	
	void instanceMethod1(){
		System.out.println("am in instanceMethod1");
	}
	
void instanceMethod2(){
	System.out.println("am in instanceMethod2");
	}
	
}
