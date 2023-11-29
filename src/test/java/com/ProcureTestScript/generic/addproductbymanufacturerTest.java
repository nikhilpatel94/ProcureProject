package com.ProcureTestScript.generic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.WebDriverUtils;

public class addproductbymanufacturerTest {
	

	
		@Test
	public void test() throws Throwable
	{
		// Read data from properties file
			FileUtils f=new FileUtils();
			ExcelUtils e=new ExcelUtils();
			WebDriverUtils w=new WebDriverUtils();
			
			String URL = f.readDataFromPropertyFile("url");
			String USERNAME = f.readDataFromPropertyFile("manufacturerusername");
			String PASSWORD = f.readDataFromPropertyFile("manufacturerpassword");
			String LOGINTYPE = f.readDataFromPropertyFile("logintype");
		
			
		WebDriver driver= new ChromeDriver();	
		//Thread.sleep(20000);
		//driver.manage().window().maximize();
		w.implicitWait(driver, 20);
		driver.get(URL);
		WebElement username = driver.findElement(By.id("login:username"));
		username.click();
		username.sendKeys(USERNAME);
		WebElement password = driver.findElement(By.id("login:password"));
		password.clear();
		password.sendKeys(PASSWORD);
		WebElement dropdown = driver.findElement(By.id("login:type"));
		//dropdown.click();
		
		w.DropDowntext(dropdown, LOGINTYPE);
	
		WebElement address = driver.findElement(By.xpath("//input[@class='submit_button']"));
		address.click();
		
		String actualtitle = driver.getTitle();
		String expectedtitle="Manufacturer: Home";
		if(actualtitle.contains(expectedtitle))
		{
			System.out.println("Homepage is displayed... and its verified with title");
		}
		else
		{
			System.out.println("Homepage is Not displayed...");
		}
		
		// Click On add product Link
		WebElement addProductLink = driver.findElement(By.xpath("//a[text()='Add Products']"));
		addProductLink.click();
		
		String actualaddproducttitle = driver.getTitle();
		String expectedproductpagetitle= "Add Product";
		if(actualaddproducttitle.equals(expectedproductpagetitle))
		{
			System.out.println("addProduct page is displayed... and its verified with title");
		}
		else
		{
			System.out.println("addProduct page is Not displayed...");
		}
		
		String unitType =e.excelScm_TestData("sheet1", 0, 4);
		String category = e.excelScm_TestData("sheet1", 1, 4);
		String desc =e.excelScm_TestData("sheet1", 0, 7);
		
		
		
		e.ReadMultipleDataScm_TestData(driver, "sheet1");
		
		
		
		// Handle Unit type dropdown
		WebElement unitdropdown = driver.findElement(By.xpath("//select[@name='cmbProductUnit']"));
		w.DropDowntext(unitdropdown, unitType);
		
		
		// Handle category dropdown
		WebElement categorydropdown = driver.findElement(By.xpath("//select[@name='cmbProductCategory']"));
		w.DropDowntext(categorydropdown, category);
		
		
		// click on Enable button
		driver.findElement(By.xpath("//input[@value='1']")).click();
		
		// click and enter the description
		 WebElement description = driver.findElement(By.xpath("//textarea[@id='product:description']"));
		 description.click();
		 description.sendKeys(desc);
		 
		 //click on add button
		 driver.findElement(By.xpath("//input[@value='Add Product']")).click();
		 
		 // Handle alert and print the text
		 String text = driver.switchTo().alert().getText();
		 System.out.println(text);
		 w.alert(driver);
		 
		 		
	}
}


