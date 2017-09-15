package com.test.serialize1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDemo {

	public static void main(String[] args) {
		System.out.println("hi");
		
		//Days a = new Days();
		Object a = null;
		try {

			FileOutputStream fos = new FileOutputStream("Serialize.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.close();
			fos.close();

			System.out.println("Serialization Done.");

			FileInputStream fis = new FileInputStream("Serialize.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Parent1 deseA = (Parent1) ois.readObject();
			fis.close();
			ois.close();

			 System.out.println(deseA.i);
			 System.out.println(deseA.a1);
			 System.out.println(deseA.a2);
			 System.out.println(deseA.a3);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

class Parent1 implements Serializable {
	
	private static final long serialVersionUID = 45632178L;
	
	transient int i=10;
	transient int a1=20;
	int a2=30;
	int a3=40;
	
	Parent1(){
		System.out.println("Parent1 constructor.. ");
	}
	
}

class Chaild extends Parent1 implements Serializable {
		
	private static final long serialVersionUID = -4358119663905440474L;
	
	int j=20;
	
	Chaild(){
		System.out.println("Chaild constructor...");
	}
	
}

enum Days {
	SUNDAY,
	MONDAY;
}
