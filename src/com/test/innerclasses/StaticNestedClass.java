package com.test.innerclasses;

public class StaticNestedClass {
	private static int a=20;
	static StaticNestedClass outer= null;
	private String text = "I am Outer private!";
	public static void main(String[] args) {
		outer = new StaticNestedClass();
		StaticNestedClass.Nested nested = outer.new Nested();
		nested.test();
		
		StaticNestedClass.localclassMethod();
		
		A a1 = new A();
		a1.display();
	}
	
	 public class Nested {
		 private String text = "I am Inner private!";
		 public void test(){
			System.out.println(" I am in inner class.. " + a + outer.text);
			
		 }

	  }
	 
	 public static void localclassMethod(){
		 
		 int val=90;
		class LocalClass {
			 public void testLocalClass(){
				 System.out.println(" I am in testLocalClass method()" + val);
			 }
		 }
		 
		 LocalClass lc= new LocalClass();
		 lc.testLocalClass();
	 }

}

class A{
	public void display(){
		//StaticNestedClass.Nested nested = new StaticNestedClass.Nested();
		//nested.test();
	}
}
