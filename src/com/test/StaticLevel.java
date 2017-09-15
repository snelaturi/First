package com.test;

public class StaticLevel {
	
	static int i=10;
	
	static {
		int i =20;
		//j=15;
		System.out.println(" static block i= "+StaticLevel.i);
		System.out.println(StaticLevel.j);
		System.out.println("static block ");
	}
	
	{
		StaticLevel.i=40;
		System.out.println("instantiation block ");
	}
	
	
	static int j=25;
	public static void main(String[] args) {
   		 new StaticLevel();
         System.out.println(i);
         System.out.println(j);
	}

}
