package com.scm.genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcelUtils {
	/**
	 * THis method is used to read data from Automation_TD excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return 
	 * @throws Throwable
	 */
	 public String excelAutomation_TD(String sheetname,int row,int cell) throws Throwable {
		 FileInputStream fis=new FileInputStream(Ipathconstants.excelAutomation_TD);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
	 }
	 /**
	  * THis method is used to read data from Scm_TestData excel file
	  * @param sheetname
	  * @param row
	  * @param cell
	 * @return 
	  * @throws Throwable
	  */
	 public String excelScm_TestData(String sheetname,int row,int cell) throws Throwable {
		 FileInputStream fis=new FileInputStream(Ipathconstants.excelScm_TestData);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
	 }
	 
	 /**
	  * THis method is used to read data from TestData2 excel file
	  * @param sheetname
	  * @param row
	  * @param cell
	 * @return 
	  * @throws Throwable
	  */
	 public String excelTestData2(String sheetname,int row,int cell) throws Throwable {
		 FileInputStream fis=new FileInputStream(Ipathconstants.excelTestData2);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
	 }
	 /**
	  * THis method is used to count rows in excel file
	  * @param Sheetname
	  * @return
	  * @throws Throwable
	  */
	 public int getLastRowNo(String Sheetname) throws Throwable {
		 FileInputStream fis=new FileInputStream(Ipathconstants.excelTestData2);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int count = sh.getLastRowNum();
		return count;
	 }
	 
	 public int getLastRowNoScm_TestData(String Sheetname) throws Throwable {
		 FileInputStream fis=new FileInputStream(Ipathconstants.excelScm_TestData);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int count = sh.getLastRowNum();
		return count;
	 }

	 public void writeDatatoexcel(String sheetname,int row,int cell, String data) throws Throwable {
		 FileInputStream fis=new FileInputStream(Ipathconstants.excelAutomation_TD);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(Ipathconstants.excelAutomation_TD);
		wb.write(fos);wb.close();
	 }
	 
	 /**
	  * THis method is used to read multiple data  from excel file
	  * @param sheetname
	  * @param driver
	 * @return 
	  * @throws Throwable
	  */
	 public HashMap<String, String> readMultipleData(String sheetname) throws Throwable {
		 FileInputStream fis=new FileInputStream(Ipathconstants.excelTestData2);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map=new HashMap<String, String>();
		for (int i = 0; i <=count; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);	
		}
		return map;
		 
		 
	 }
	 public HashMap<String, String> ReadMultipleDataScm_TestData(WebDriver driver,String Sheetname) throws Throwable {
		 FileInputStream fis=new FileInputStream(Ipathconstants.excelScm_TestData);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int count = sh.getLastRowNum();
	 HashMap<String,String> map=new HashMap<String,String>();
		
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			
		}
		return map;
	 }
	 public HashMap<String, String> ReadMultipleDataAutomation_TD(String Sheetname) throws Throwable {
		 FileInputStream fis=new FileInputStream(Ipathconstants.excelAutomation_TD);
		 Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int count = sh.getLastRowNum();
	 HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i <= count; i++) {

			String key = sh.getRow(i).getCell(0).getStringCellValue();

			String value = sh.getRow(i).getCell(1).getStringCellValue();

			map.put(key, value);

		}
		return map;	
	 }
	 
	 public Object[][] ReadMultipledataDataProviderExcel(String Sheetname) throws Throwable {
		 FileInputStream fis=new FileInputStream("./src/test/resources/dataprovider.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(Sheetname);
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
