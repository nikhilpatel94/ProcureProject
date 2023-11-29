package com.ProcureTestScript.generic;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.WebDriverUtils;

public class addretailerandsearchorderTest {
	
	
	
	
	public static void main(String[] args) throws Throwable {
		
		FileUtils f=new FileUtils();
		ExcelUtils e=new ExcelUtils();
		WebDriverUtils w=new WebDriverUtils();
		
		String URL=f.readDataFromPropertyFile("url");
		String adminUN = f.readDataFromPropertyFile("adminun");
		String adminpwd = f.readDataFromPropertyFile("adminpwd");
		String retailerUN =f.readDataFromPropertyFile("retailerun");
		String retailerPWD = f.readDataFromPropertyFile("retailerpwd");
		
		int rownum=e.getLastRowNo("addretailerandsearch");
		String loginadmin = e.excelTestData2("addretailerandsearch", 1, 6);
		String areacode = e.excelTestData2("addretailerandsearch", 1, 7);
		String expretailer = e.excelTestData2("addretailerandsearch", 0, 1);
		String loginretailer = e.excelTestData2("addretailerandsearch", 2, 6);
		String retailerusername = e.excelTestData2("addretailerandsearch", 0, 1);
		String quantity = e.excelTestData2("addretailerandsearch", 1, 8);
		
		
		
		WebDriver driver=new ChromeDriver();
		Thread.sleep(20000);
		
		driver.get(URL);
		w.implicitWait(driver, 20);
		
		driver.findElement(By.id("login:username")).sendKeys(adminUN);
		driver.findElement(By.id("login:password")).sendKeys(adminpwd);
		WebElement sel = driver.findElement(By.xpath("//select[@name='login_type']"));
		w.DropDowntext(sel, loginadmin);
		
		WebElement address = driver.findElement(By.xpath("//input[@class='submit_button']"));
		address.click();
		driver.findElement(By.xpath("//a[text()='Add Retailers']")).click();
		e.readMultipleData("addretailerandsearch");
		
		
		WebElement retailerareacode = driver.findElement(By.id("retailer:areaCode"));
		w.DropDowntext(retailerareacode, areacode);
		
		driver.findElement(By.xpath("//input[@value='Add Retailer']")).click();
		w.alert(driver);
		
		driver.findElement(By.xpath("//a[text()='Retailers']")).click();
		String actretailer = driver.findElement(By.xpath("//table[@class='table_displayData']/descendant::td[contains(text(),'"+retailerusername+"')]")).getText();
		if(actretailer.contains(expretailer)) {
			System.out.println("retailer got created");
		}
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		driver.findElement(By.id("login:username")).sendKeys(retailerUN);
		driver.findElement(By.id("login:password")).sendKeys(retailerPWD);
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='submit_button']")));
		WebElement retailerlog = driver.findElement(By.xpath("//select[@name='login_type']"));
		w.DropDowntext(retailerlog, "Retailer");
		
		driver.findElement(By.xpath("//input[@class='submit_button']")).click();
		driver.findElement(By.xpath("//a[text()='New Order']")).click();
		driver.findElement(By.xpath("//table/descendant::td[contains(text(),'momos')]/parent::tr//descendant::input[@class='quantity']")).sendKeys(quantity);
		w.ScrollbarToBottom(driver);
		
		driver.findElement(By.xpath("//input[@value='Post Order']")).click();
		driver.quit();
		
	}

}
