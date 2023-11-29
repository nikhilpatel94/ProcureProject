package com.ProcureTestScript_package;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class addproductbymanufacturerTest {
	

	
		@Test
	public void test() throws IOException, Exception
	{
		// Read data from properties file
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("manufacturerusername");
		String PASSWORD = pobj.getProperty("manufacturerpassword");
		String LOGINTYPE = pobj.getProperty("logintype");
		
			
		WebDriver driver= new ChromeDriver();	
		//Thread.sleep(20000);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		WebElement username = driver.findElement(By.id("login:username"));
		username.click();
		username.sendKeys(USERNAME);
		WebElement password = driver.findElement(By.id("login:password"));
		password.clear();
		password.sendKeys(PASSWORD);
		WebElement dropdown = driver.findElement(By.id("login:type"));
		//dropdown.click();
		
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(LOGINTYPE);
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
		
		// Excel Utility
		FileInputStream fis2 = new FileInputStream("./src/test/resources/Scm_TestData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis2);
		 Sheet sh = wb.getSheet("sheet1");
		int count = sh.getLastRowNum();
		
		// Dropdown
		String unitType = sh.getRow(0).getCell(4).getStringCellValue();
		String category = sh.getRow(1).getCell(4).getStringCellValue();
		
		// Enter data in description
		String desc = sh.getRow(0).getCell(7).getStringCellValue();
		
		
		
		HashedMap<String,String> map=new HashedMap<String,String>();
		
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			
		}
		for(Entry<String, String> set: map.entrySet())
		{
			if(set.getKey().contains("product:name"))
			{
				driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
			}
			else if ((set.getKey().contains("product:price") ))
			{
				driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());       
			       
			}
		}
		
		// Handle Unit type dropdown
		WebElement unitdropdown = driver.findElement(By.xpath("//select[@name='cmbProductUnit']"));
		Select select2 = new Select(unitdropdown);
		select2.selectByVisibleText(unitType);
		
		// Handle category dropdown
		WebElement categorydropdown = driver.findElement(By.xpath("//select[@name='cmbProductCategory']"));
		Select select3 = new Select(categorydropdown);
		select3.selectByVisibleText(category);
		
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
		 driver.switchTo().alert().accept();
		 driver.close();		
	}
}


