package com.ProcureTestScript.generic;

import java.io.FileInputStream;
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

import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.WebDriverUtils;

public class checkinvoicebyidTest {
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
		driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		WebElement search = driver.findElement(By.id("cmbFilter"));
		String searchval="invoiceId";
		w.DropDownvalue(search, searchval);
		String expeid = "3";
		driver.findElement(By.id("txtInvoiceId")).sendKeys(expeid);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		String actualid = driver.findElement(By.xpath(
				"//th[contains(text(),'Invoice ID')]/parent::tr/following-sibling::tr/child::td[contains(text(),'"
						+ expeid + "')][1]"))
				.getText();
		if (actualid.contains(actualid)) {
			System.out.println("invoice is displayed");
		} else {
			System.out.println("invoice is not displayed");
		}
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		driver.quit();

	}
}
