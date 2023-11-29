package com.ProcureTestScript_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class checkinvoicebyidTest {
	public static void main(String[] args) throws IOException, Exception {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String adminUN = p.getProperty("adminun");
		String adminpwd = p.getProperty("adminpwd");
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData (2).xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("addretailerandsearch");
		String loginadmin = sh.getRow(1).getCell(6).getStringCellValue();
	WebDriver driver=new ChromeDriver();
	//Thread.sleep(20000);
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.id("login:username")).sendKeys(adminUN);
	driver.findElement(By.id("login:password")).sendKeys(adminpwd);
	WebElement sel = driver.findElement(By.xpath("//select[@name='login_type']"));
	Select s=new Select(sel);
	s.selectByVisibleText(loginadmin);
 driver.findElement(By.xpath("//input[@class='submit_button']")).click();
 driver.findElement(By.xpath("//a[text()='Invoice']")).click();
WebElement search = driver.findElement(By.id("cmbFilter"));
Select s1=new Select(search);
s1.selectByValue("invoiceId");
String expeid="3";
driver.findElement(By.id("txtInvoiceId")).sendKeys(expeid);
driver.findElement(By.xpath("//input[@value='Search']")).click();
String actualid = driver.findElement(By.xpath("//th[contains(text(),'Invoice ID')]/parent::tr/following-sibling::tr/child::td[contains(text(),'"+expeid+"')][1]")).getText();
	if(actualid.contains(actualid)) {
		System.out.println("invoice is displayed");
	}
	else {
		System.out.println("invoice is not displayed");
	}
	driver.findElement(By.xpath("//input[@value='Log out']")).click();
driver.quit();

}
}
