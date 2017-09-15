package com.test;

public class PassByvalPassByRefExample {
	
	public static void main(String[] args) {
		int a=4;
		int b=5;
		Object obj = new Object();
		m1(a,b,obj);
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println(obj.hashCode());
	}
	
	
	public static void m1(int a, int b,Object obj){
		int temp=a;
		a=b;
		b=temp;
		//obj = null;
		//System.out.println(obj.hashCode());
		//System.out.println("a=" + a);
		//System.out.println("b=" + b);
	}

}
