package com.practice_package;

import org.testng.annotations.Test;

public class DataProviderDifferentClass {
	
//	@Test(dataProviderClass =DataProviderExcel.class, dataProvider = "data")
//	public void dataTest(String from, String to) {
//		System.out.println(from+"------------>"+to);
//		
//		
//	}
	
	@Test(dataProviderClass =DataProviderSameClass.class, dataProvider = "getdatafromexcel")
	public void dataTest1(String from, String to) {
		System.out.println(from+"------------>"+to);
		System.out.println("hi");
		System.out.println("bye");
		
	}

}
