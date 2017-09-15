package com.test.serialize1;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableExample {
public static void main(String[] args) {
	
	Parent a = new Parent("John",5);
	try {

		FileOutputStream fos = new FileOutputStream("External.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a);
		oos.close();
		fos.close();

		System.out.println("Serialization Done.");

		FileInputStream fis = new FileInputStream("External.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Parent deseA = (Parent) ois.readObject();
		fis.close();
		ois.close();

		 System.out.println(deseA.name);
		 System.out.println(deseA.pid);
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

class Parent implements Externalizable {

	String name;
	int pid;
	
	Parent(String name, int pid) {
		this.name=name;
		this.pid=pid;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.name);
		out.writeInt(pid);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.pid = in.readInt();
		this.name = (String) in.readObject();
	}
	
}
