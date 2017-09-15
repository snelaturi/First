package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo2 {

	public static void main(String[] args) {

		Child2 child2= new Child2();
		
		try { // serialization
			FileOutputStream fos = new FileOutputStream("myclass.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(child2);
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		System.out.println("done.");
		// deserialization
				try {
					FileInputStream fis = new FileInputStream("myclass.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
					Child2 a3 = (Child2) ois.readObject();
					ois.close();
					fis.close();
					
				} catch (FileNotFoundException fnfe) {
					fnfe.printStackTrace();
				} catch (IOException ioex) {
					ioex.printStackTrace();
				} catch (ClassNotFoundException CNFE) {
					CNFE.printStackTrace();
				}
		
	}

}

class Parent {
	Parent(){
		System.out.println("Parent");
	}
}

class Child1 extends Parent  {
	Child1(){
		System.out.println("Child1");
	}
}

class Child2 extends Child1  implements Serializable {
	Child2(){
		System.out.println("Child2");
	}
}
