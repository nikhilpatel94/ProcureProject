package com.practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readdatafromexcel {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/main/resources/TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
	int cellcount = sh.getRow(0).getLastCellNum();
	for (int i = 0; i <= rowcount; i++) {
		for (int j = 0; j < cellcount; j++) {
			String value = sh.getRow(i).getCell(j).getStringCellValue();
			System.out.print(value);
			System.out.print("    ");
			
		}
		System.out.println();
	}
	
	}
	}


