package com.Procure.TestScriptPOM;

import org.testng.annotations.Test;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.scm.Procure.pom.AddProductManufacPage;
import com.scm.Procure.pom.LoginPage;
import com.scm.Procure.pom.ManufacturesHomePage;
import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.WebDriverUtils;

public class addproductbymanufacturerTest {

	@Test
	public void test() throws Throwable {
		// Read data from properties file
		FileUtils f = new FileUtils();
		ExcelUtils e = new ExcelUtils();
		WebDriverUtils w = new WebDriverUtils();

		String URL = f.readDataFromPropertyFile("url");
		String USERNAME = f.readDataFromPropertyFile("manufacturerusername");
		String PASSWORD = f.readDataFromPropertyFile("manufacturerpassword");
		String LOGINTYPE = f.readDataFromPropertyFile("logintype");

		WebDriver driver = new ChromeDriver();
		// Thread.sleep(20000);
		// driver.manage().window().maximize();
		w.implicitWait(driver, 20);
		driver.get(URL);

		LoginPage l = new LoginPage(driver);
		l.login(USERNAME, PASSWORD, LOGINTYPE);

		String actualtitle = driver.getTitle();
		String expectedtitle = "Manufacturer: Home";
		if (actualtitle.contains(expectedtitle)) {
			System.out.println("Homepage is displayed... and its verified with title");
		} else {
			System.out.println("Homepage is Not displayed...");
		}

		ManufacturesHomePage m = new ManufacturesHomePage(driver);
		m.addProClick(driver);

		String unitType = e.excelScm_TestData("sheet1", 0, 4);
		String category = e.excelScm_TestData("sheet1", 1, 4);
		String desc = e.excelScm_TestData("sheet1", 0, 7);

		AddProductManufacPage a = new AddProductManufacPage(driver);
		a.fillAllFields(driver, e.ReadMultipleDataScm_TestData(driver, "sheet1"), unitType, category, desc);
		// Handle alert and print the text
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		w.alert(driver);

	}
}
