package com.test;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Demo {

	public static void main(String[] args) {
		/*	
		ArrayList<Object> list = new ArrayList<>();
		list.iterator();
		Employee emp1 = new Employee();
		Employee emp2 = null;
		try {
			emp2 = (Employee) emp1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		System.out.println(emp1 == emp2);
		System.out.println(emp1.b == emp2.b);
		
		System.out.println(15 >> 1);
		
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("abc");
*/	
		System.out.println(Math.abs(-98));	
	}

}

class Employee implements Serializable, Cloneable {
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	B b; 
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}

class B {
	
}
