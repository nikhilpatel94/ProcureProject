package com.Procure.TestScriptPOM;

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

import com.scm.Procure.pom.AdminHomePage;
import com.scm.Procure.pom.LoginPage;
import com.scm.Procure.pom.invoicesPage;
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
		LoginPage l = new LoginPage(driver);
		l.login(adminUN, adminpwd, loginadmin);

		AdminHomePage a = new AdminHomePage(driver);
		a.InvoiceClick();
		invoicesPage i = new invoicesPage(driver);
		String searchval = "invoiceId";
		String expeid = "3";
		i.search(searchval, expeid, driver);
		a.logoutClick();
		driver.quit();

	}
}
