package com.test.exceptions1;

public class TestClass {

	public static void main(String[] args) {
		
		try{
			System.out.println("start");
             throw new OutOfMemoryError();
			//display();
			//System.out.println("try block end");
			
		} catch(Throwable e){
			e.printStackTrace();
		}
		
		System.out.println("after try block");
		
	}
	
	
}
