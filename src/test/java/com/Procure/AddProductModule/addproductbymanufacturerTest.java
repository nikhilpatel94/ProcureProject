package com.Procure.AddProductModule;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.Procure.pom.AddProductManufacPage;
import com.scm.Procure.pom.LoginPage;
import com.scm.Procure.pom.ManufacturesHomePage;
import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.NONBaseClass;
import com.scm.genericutils.WebDriverUtils;
@Listeners(com.scm.genericutils.ListnerImpliNONBASE.class)
public class addproductbymanufacturerTest extends NONBaseClass{

	@Test(retryAnalyzer = com.scm.genericutils.RetryImpliClass.class)
	public void addproductbymanufacturer() throws Throwable {
		// Read data from properties file
		FileUtils f = new FileUtils();
		ExcelUtils e = new ExcelUtils();
		WebDriverUtils w = new WebDriverUtils();

		String URL = f.readDataFromPropertyFile("url");
		String USERNAME = f.readDataFromPropertyFile("manufacturerusername");
		String PASSWORD = f.readDataFromPropertyFile("manufacturerpassword");
		String LOGINTYPE = f.readDataFromPropertyFile("logintype");

		//WebDriver driver = new ChromeDriver();
		// Thread.sleep(20000);
		w.implicitWait(driver, 20);
		driver.get(URL);

		LoginPage l = new LoginPage(driver);
		l.login(USERNAME, PASSWORD, LOGINTYPE);
		//AssertJUnit.fail();
		String actualtitle = driver.getTitle();
		String expectedtitle = "Manufacturer: Home";
		AssertJUnit.assertEquals(actualtitle, expectedtitle);
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
