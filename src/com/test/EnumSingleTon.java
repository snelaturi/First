package com.test;

import javax.sql.DataSource;

public enum EnumSingleTon {

	INSTANCE;

	DataSource ds;

	public DataSource getDataSource(DataSource ds) {
		System.out.println("DS");
		this.ds = ds;
		return ds;
	}
	
	public static void main(String[] args) {
		EnumSingleTon.INSTANCE.getDataSource(null);
	}

}
