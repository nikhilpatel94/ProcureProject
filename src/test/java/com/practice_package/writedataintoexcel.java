package com.practice_package;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writedataintoexcel {
public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("./src/main/resources/TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	sh.createRow(5).createCell(0).setCellValue("qspiders");
	FileOutputStream fos=new FileOutputStream("./src/main/resources/TestData.xlsx");
	wb.write(fos);
	wb.close();
}
	
	
}
