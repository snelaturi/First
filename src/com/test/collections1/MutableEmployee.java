package com.test.collections1;

import java.util.HashMap;

public class MutableEmployee {

	public static void main(String[] args) {

		Employee1 emp1 = new Employee1(100, "First");
		Employee1 emp2 = new Employee1(100, "First");

		HashMap<Employee1, Integer> map = new HashMap<Employee1, Integer>();
		map.put(emp1, 1);
		map.put(emp2, 2);

		System.out.println(map.size());

		emp1.setEname("Second");

		System.out.println(map.get(new Employee(100, "First")));

		System.out.println(map.size());
	}

}

class Employee1 {
	private int empId;
	private String ename;

	Employee1(int empId, String ename) {
		this.empId = empId;
		this.ename = ename;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee1 other = (Employee1) obj;
		if (empId != other.empId)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		return true;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + "]";
	}

}