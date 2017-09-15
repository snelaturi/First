package com.test;

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

public class SerializationDemo {

	public static void main(String[] args) {

		A a1 = new A();
		a1.i = 15;
		a1.obj= new A();
		a1.j = 10;

		try { // serialization
			FileOutputStream fos = new FileOutputStream("myclass.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a1);
			oos.close();
			fos.close();
			System.out.println("object serielized 1..." + a1.i);
			System.out.println("object serielized 2..." + a1.j);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		
		A a2 = new A();
		  a2.i=20;
		  a2.j=10;
          System.out.println(a2.i);
		// deserialization
		try {
			FileInputStream fis = new FileInputStream("myclass.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			A a3 = (A) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("object DEEEEserielized 1..." + a3.i);
			System.out.println("object DEEEEserielized 2..." + a3.j);
			System.out.println("object DEEEEserielized 2..." + a3.obj);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} catch (ClassNotFoundException CNFE) {
			CNFE.printStackTrace();
		}
	}

}

class A implements Serializable, ObjectInputValidation {
    transient int i = 10;
    transient A obj ;
	int j = 0;

	private static final long serialVersionUID = 1L;
	A() {

	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
        out.defaultWriteObject();
    }
	
	 private Object writeReplace() throws ObjectStreamException {
	        System.out.println("writeReplace");
	        return this;
	    }
	 
	 private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
	        System.out.println("readObject");
	        in.registerValidation(this, 0);
	        in.defaultReadObject();
	    }
	 
	 @Override
	    public void validateObject() throws InvalidObjectException {
	        System.out.println("validateObject");
	    }
	    private Object readResolve() throws ObjectStreamException {
	        System.out.println("readResolve");
	        return this;
	    }
	
	
	
	
	

}
