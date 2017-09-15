package com.test.serialize1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class SerializeDemo1 {

	public static void main(String[] args) {

		// B a = new B();
		A a = new A();
		try {

			FileOutputStream fos = new FileOutputStream("A.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.close();
			fos.close();

			System.out.println("Serialization Done.");

			FileInputStream fis = new FileInputStream("A.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			A deseA = (A) ois.readObject();
			fis.close();
			ois.close();

			 System.out.println(deseA.i);
			 System.out.println(deseA.name);
			//System.out.println(deseA.k);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class A implements Serializable, ObjectInputValidation {

	int i=10;
	String name;

	A() {
		System.out.println("default constructor");
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		System.out.println("write Object ");
		A a2 = new A();
		a2.i=20;
		//out.writeObject(a2);
		out.defaultWriteObject();
	}
	
	Object writeReplace() throws ObjectStreamException {
	    System.out.println("writeReplace");
	    A a3 = new A();
		a3.i=30;
		return a3;
	  }
	Object readResolve() throws ObjectStreamException {
	     System.out.println("readresolve");
	     return new A();
	    }
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("read Object");
		in.defaultReadObject();
	}
	//@Override
	public void validateObject() throws InvalidObjectException {
		System.out.println("validate Object");
		
	}

}

/*
 * class Parent { Parent(){ System.out.println("Parent"); } }
 * 
 * class Child1 extends Parent { Child1(int a){ System.out.println("Child1"); }
 * Child1(){ System.out.println("Child1 default"); } }
 * 
 * class Child2 extends Child1 implements Serializable { Child2(){ super(4);
 * System.out.println("Child2"); } }
 */
