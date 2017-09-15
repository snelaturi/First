package com.test.enum1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumExample {

	private static final String Object = null;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException {
		
		Constructor cons = EnumExample1.class.getDeclaredConstructor();
        cons.setAccessible(true);
        
		EnumExample1 enumexample = (EnumExample1) cons.newInstance(null);
		System.out.println(enumexample);
		
		String s=null;
		Object obj= (Object)null;
		System.out.println(obj);
		//s.toString();
		
	}

	
	
}

enum Test1 {
	SUNDAY,MONDAY;
}

class EnumExample1{
	private EnumExample1(){
		System.out.println("private constructor... ");
	}
}