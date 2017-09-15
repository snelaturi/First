package com.test.enum1;

public class CustomEnumUser {

	public static void main(String[] args) {
		System.out.println(CustomEnum.MONDAY.customParameter);
		System.out.println(CustomEnum.MONDAY);		
		System.out.println(CustomEnum.MONDAY.getOrdinal());
		System.out.println(EnumDays.MON);
	}

}
