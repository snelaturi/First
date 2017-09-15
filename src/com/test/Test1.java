package com.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test1 {
	public static void main(String[] args) {
           
		Test test = new Test(new MyClass(), 10);
		
		try { //serialization
			FileOutputStream fos = new FileOutputStream("myclass.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(test);
			oos.close();
			fos.close();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		
	}
}

class Test implements Serializable{

	private MyClass b;
	private int x;

	Test(MyClass b, int x) {

	}
	

}

class MyClass {
	private int y;
}