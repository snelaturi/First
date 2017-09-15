package com.test;

public class InheritanceDemo {

	public static void main(String[] args) {
		
		Vehicle t = new Car();
		System.out.println(t.val);
	
	}

}

class Vehicle{
	final int val =10;
	String licensePlate = null;

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}

class Car extends Vehicle {
	int val=20;
	public void setLicensePlate(String license) {
        this.licensePlate = license.toLowerCase();
    }
}

class Truck extends Vehicle {
	public void setLicensePlate(String license) {
        this.licensePlate = license.toLowerCase();
    }
}
