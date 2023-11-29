package com.ProcureTestScript_package;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addretailerandsearchorderTest {
	public static void main(String[] args) throws IOException, Exception {
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String adminUN = p.getProperty("adminun");
		String adminpwd = p.getProperty("adminpwd");
		String retailerUN = p.getProperty("retailerun");
		String retailerPWD = p.getProperty("retailerpwd");
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData (2).xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("addretailerandsearch");
		
		int rownum = sh.getLastRowNum();
		String loginadmin = sh.getRow(1).getCell(6).getStringCellValue();
		String areacode = sh.getRow(1).getCell(7).getStringCellValue();
		String expretailer = sh.getRow(0).getCell(1).getStringCellValue();
		String loginretailer = sh.getRow(2).getCell(6).getStringCellValue();
		String retailerusername = sh.getRow(0).getCell(1).getStringCellValue();
		String quantity = sh.getRow(1).getCell(8).getStringCellValue();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("login:username")).sendKeys(adminUN);
		driver.findElement(By.id("login:password")).sendKeys(adminpwd);
		WebElement sel = driver.findElement(By.xpath("//select[@name='login_type']"));
		Select s=new Select(sel);
		s.selectByVisibleText(loginadmin);
		WebElement address = driver.findElement(By.xpath("//input[@class='submit_button']"));
		address.click();
		driver.findElement(By.xpath("//a[text()='Add Retailers']")).click();
		HashMap<String, String> map=new HashMap<String, String>();
		for (int i = 0; i <=rownum; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);	
		}
		for(Entry<String, String> a:map.entrySet()) {
			driver.findElement(By.name(a.getKey())).sendKeys(a.getValue());
		}
		WebElement retailerareacode = driver.findElement(By.id("retailer:areaCode"));
		Select s1=new Select(retailerareacode);
		s1.selectByVisibleText(areacode);
		driver.findElement(By.xpath("//input[@value='Add Retailer']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
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
		Select s2=new Select(retailerlog);
		s2.selectByVisibleText("Retailer");
		driver.findElement(By.xpath("//input[@class='submit_button']")).click();
		driver.findElement(By.xpath("//a[text()='New Order']")).click();
		driver.findElement(By.xpath("//table/descendant::td[contains(text(),'momos')]/parent::tr//descendant::input[@class='quantity']")).sendKeys(quantity);
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//input[@value='Post Order']")).click();
		driver.quit();
		
	}

}
