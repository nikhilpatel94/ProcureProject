package com.Procure.TestScriptPOM;

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

import com.scm.Procure.pom.AddRetailerPage;
import com.scm.Procure.pom.AdminHomePage;
import com.scm.Procure.pom.LoginPage;
import com.scm.Procure.pom.OrderItemsPage;
import com.scm.Procure.pom.RetailerHomePage;
import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.WebDriverUtils;

public class addretailerandsearchorderTest {

	public static void main(String[] args) throws Throwable {

		FileUtils f = new FileUtils();
		ExcelUtils e = new ExcelUtils();
		WebDriverUtils w = new WebDriverUtils();

		String URL = f.readDataFromPropertyFile("url");
		String adminUN = f.readDataFromPropertyFile("adminun");
		String adminpwd = f.readDataFromPropertyFile("adminpwd");
		String retailerUN = f.readDataFromPropertyFile("retailerun");
		String retailerPWD = f.readDataFromPropertyFile("retailerpwd");

		int rownum = e.getLastRowNo("addretailerandsearch");
		String loginadmin = e.excelTestData2("addretailerandsearch", 1, 6);
		String areacode = e.excelTestData2("addretailerandsearch", 1, 7);
		String expretailer = e.excelTestData2("addretailerandsearch", 0, 1);
		String loginretailer = e.excelTestData2("addretailerandsearch", 2, 6);
		String retailerusername = e.excelTestData2("addretailerandsearch", 0, 1);
		String quantity = e.excelTestData2("addretailerandsearch", 1, 8);

		WebDriver driver = new ChromeDriver();
		//Thread.sleep(20000);

		driver.get(URL);
		w.implicitWait(driver, 20);

		LoginPage l = new LoginPage(driver);
		l.login(adminUN, adminpwd, loginadmin);
		AdminHomePage a = new AdminHomePage(driver);
		a.addRetailerClick();
		AddRetailerPage a1 = new AddRetailerPage(driver);
		a1.fillAllFileds(driver, e.readMultipleData("addretailerandsearch"), areacode);
		a.RetailersClick();

		String actretailer = driver.findElement(By.xpath(
				"//table[@class='table_displayData']/descendant::td[contains(text(),'" + retailerusername + "')]"))
				.getText();
		if (actretailer.contains(expretailer)) {
			System.out.println("retailer got created");
		}
		a.logoutClick();
		l.login(retailerUN, retailerPWD, "Retailer");
		RetailerHomePage r = new RetailerHomePage(driver);
		r.newOrderClick();
		driver.findElement(By.xpath(
				"//table/descendant::td[contains(text(),'momos')]/parent::tr//descendant::input[@class='quantity']"))
				.sendKeys(quantity);
		OrderItemsPage o = new OrderItemsPage(driver);
		o.postOrderClick(driver);
		driver.quit();

	}

}
