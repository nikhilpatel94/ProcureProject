package com.ProcureTestScript.generic;

import java.io.FileInputStream;
import java.time.Duration;

import java.util.HashMap;

import java.util.Map.Entry;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.WebDriverUtils;

public class updatemanufacturerTest {

	public static void main(String[] args) throws Throwable {

		FileUtils f = new FileUtils();
		ExcelUtils e = new ExcelUtils();
		WebDriverUtils w = new WebDriverUtils();

		String URL = f.readDataFromPropertyFile("url");
		String adminUN = f.readDataFromPropertyFile("adminun");
		String adminpwd = f.readDataFromPropertyFile("adminpwd");

		String loginadmin = e.excelTestData2("addretailerandsearch", 1, 6);

		WebDriver driver = new ChromeDriver();
		// Thread.sleep(20000);
		driver.get(URL);
		w.implicitWait(driver, 20);
		driver.findElement(By.id("login:username")).sendKeys(adminUN);
		driver.findElement(By.id("login:password")).sendKeys(adminpwd);
		WebElement sel = driver.findElement(By.xpath("//select[@name='login_type']"));
		w.DropDowntext(sel, loginadmin);
		driver.findElement(By.xpath("//input[@class='submit_button']")).click();
		driver.findElement(By.xpath("//a[.='Manufacturers']")).click();
		String oUn = e.excelAutomation_TD("manufacturer", 1, 3);
		WebElement editIcon = driver.findElement(By.xpath("(//td[contains(.,'" + oUn + "')]/..)[2]//img"));
		Actions action = new Actions(driver);
		action.scrollToElement(editIcon);
		editIcon.click();
		e.ReadMultipleDataAutomation_TD( "manufacturer");
		driver.findElement(By.xpath("//input[@value='Update Manufacturer']")).click();
		System.out.println(driver.switchTo().alert().getText());
		w.alert(driver);
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		driver.quit();
	}
}
