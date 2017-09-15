package com.test.collections1;

import java.util.HashMap;

public class ImmutableEployee {

	public static void main(String[] args) {
		

		Employee emp1 = new Employee(100, "First");
		Employee emp2 = new Employee(100, "First");
		
		HashMap<Employee, Integer> map = new HashMap<Employee, Integer>();
		map.put(emp1, 1);
		map.put(emp2, 2);
		
		System.out.println(map.size());
		System.out.println(map.get(new Employee(100, "Second")));
		
		System.out.println(map.size());
	}

}

final class Employee {
	private final int empId;
	private final String ename;
	
	Employee(int empId, String ename) {
	this.empId=empId;
	this.ename=ename;
	
	}

	public int getEmpId() {
		return empId;
	}

	public String getEname() {
		return ename;
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
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + "]";
	}
	
	
	
}
