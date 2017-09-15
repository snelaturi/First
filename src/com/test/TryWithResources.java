package com.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*try (BufferedReader br = new BufferedReader(new FileReader("D:\\testing.txt"))) {

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		}*/
		//FileInputStream fis;
		try(FileInputStream fis  = new FileInputStream("D:\\testing.txt"); FileInputStream fis2  = new FileInputStream("D:\\testing.txt") ) {
			int data = fis.read();
			while(data != 1) {
				System.out.println((char)fis.read());
				data = fis.read();
			}
		}
	}

}
