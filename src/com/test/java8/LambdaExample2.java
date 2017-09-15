package com.test.java8;

public class LambdaExample2 {

	public static void main(String[] args) {
		
		AddFunctionalInterface in = ()-> System.out.println("add ");
		LambdaExample2 obj = new LambdaExample2();
		
		AddFunctionalInterface in2 = ()-> LambdaExample2.otherMethod();
		
		AddFunctionalInterface in3 = LambdaExample2::otherMethod;
		in3.add();
		in2.add();
		in.add();
		
	}
	
	public static void otherMethod(){
		System.out.println(" am in other method");
	}
	
}
