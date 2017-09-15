package com.sapient.classloaders;

public class ClassA {
	
	public static void main(String[] args) {
		
		try {
			
			
			Object c = null;
			ClassB obj = null;
			try {
				System.out.println(" ClassB :: "+ClassB.class.getClassLoader().toString());
				System.out.println("Class loader :::::: " + new CustomClassLoader(CustomClassLoader.class).loadClass("com.sapient.classloaders.ClassB").getClassLoader());
				 obj  = (ClassB)new CustomClassLoader(CustomClassLoader.class).loadClass("com.sapient.classloaders.ClassB").newInstance();
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			obj.print();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
