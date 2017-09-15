package com.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEnumDemo {

	public static void main(String[] args) {

		try { // serialization
			FileOutputStream fos = new FileOutputStream("enum.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(MONTH.FEB);
			oos.close();
			fos.close();
			//System.out.println("object serielized 1..." + a1.i);
			//System.out.println("object serielized 2..." + a1.j);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}

	}

}

enum MONTH {
	JAN,FEB;
}
