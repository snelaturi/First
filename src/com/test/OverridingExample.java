package com.test;

import java.io.IOException;

public class OverridingExample {

	public static void main(String[] args) {
		Bar bar = new Bar();
		bar.doStuff(5, 6);
		//bar.doStuff1(null);
	}
}

class Foo {
	public void doStuff(int a, int s){
		System.out.println("Foo class");
	}
	public void doMoreStuff(int a, String s){
		System.out.println("Foo class");
	}
	
	public void doStuff1(String str) throws Exception {
		System.out.println("doStuff1 Foo >> " + str);
	}
	
}

class Bar extends Foo{
	public void doStuff(long a, long s){
		System.out.println("Bar class");
	}
	
	public void doStuff1(String obj) {
		System.out.println("doStuff1 Bar >> " + obj);
	}
}
