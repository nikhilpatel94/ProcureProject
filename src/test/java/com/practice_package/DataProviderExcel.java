package com.practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.scm.genericutils.Ipathconstants;

public class DataProviderExcel {
	@DataProvider
	public Object[][] data() throws Throwable {
	FileInputStream fis=new FileInputStream("./src/test/resources/dataprovider.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("DataProvide");
	int rowcount = sh.getLastRowNum()+1;
	short cellcount = sh.getRow(0).getLastCellNum();
	Object[][] obj = new Object[5][2];
	for (int i = 0; i < rowcount; i++) {
		for (int j = 0; j < cellcount; j++) {
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
		
	}
	return obj;
	
	}							
}
