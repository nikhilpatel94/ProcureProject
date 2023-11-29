package com.practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scm.genericutils.ExcelUtils;

public class DataProviderSameClass {
	
	@Test(dataProvider = "data1")
	public void DataTest(String from, String to) {
		System.out.println(from+"----------->"+to);
	}
	
	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="Bang";
		obj[0][1]="mys";
		
		obj[1][0]="dvg";
		obj[1][1]="delhi";
		
		return obj;
	}

	@DataProvider
	public Object[][] data1() {
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="hyd";
		obj[0][1]="dharwad";
		
		obj[1][0]="hubli";
		obj[1][1]="surat";
		
		return obj;
	}
	@DataProvider
	public Object[][] getdatafromexcel() throws Throwable {
		ExcelUtils e=new ExcelUtils();
		Object[][] value = e.ReadMultipledataDataProviderExcel("DataProvide");
		return value;
	}
}
