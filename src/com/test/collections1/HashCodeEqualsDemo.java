package com.test.collections1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class HashCodeEqualsDemo {

	public static void main(String[] args) {
		
	//HashMap<Product, Integer> map = new HashMap<>();
	
	Product p1 = new Product(100, "First");
	Product p5 = new Product(100, "First");
	Product p2 = new Product(500, "Second");
	Product p3 = new Product(500, "Third");
	Product p4 = new Product(80, "Third");
	
	System.out.println(p1.hashCode());
	System.out.println(p5.hashCode());
	
	System.out.println(p1.equals(p5));
	
	HashMap<Product, String> map = new HashMap<>();
	map.put(p1, "p1");
	map.put(p5, "p5");
	
	System.out.println(map.get(p1));
	
	List<Product> list = new ArrayList<Product>();
	list.add(p1);
	list.add(p2);
	list.add(p3);
	list.add(p4);
 
	Collections.sort(list, new CustomSorting());
	
	for (Product product : list) {
		System.out.println(product);
	}
	
	}
}

class Product implements Comparable<Object>{
	private int pid;
	private String pname;
	
	Product(int pid, String pname) {
		this.pid=pid;
		this.pname=pname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	/*public int hashCode() {
		System.out.println("in hashcode : ");
		return 34;
	}
	
	public boolean equals(Object obj) {
		System.out.println("in equals : ");
		return true;
	}*/

	@Override
	public int hashCode() {
		System.out.println("hashcode..");
		final int prime = 31;
		int result = 1;
		result = prime * result + pid;
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		return result;
	}

	/*@Override
	public boolean equals(Object obj) {
		System.out.println("equlas method..");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (pid != other.pid)
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		return true;
	}*/

	@Override
	public int compareTo(Object o) {
		Product p =	(Product)o;
		if(p.pid == this.pid) {
			return this.pname.compareTo(p.getPname());
		} else {
			return p.pid - this.pid;
		}
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + "]";
	}
	
	
	
	
}

class CustomSorting implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		
		return o2.getPname().compareTo(o1.getPname());
	}
	
}
