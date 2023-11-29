package com.Procure.TestScriptPOM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.scm.Procure.pom.EditProfileManufacPage;
import com.scm.Procure.pom.LoginPage;
import com.scm.Procure.pom.ManufacturesHomePage;
import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.WebDriverUtils;

public class changepasswordmanufacturerTest {

	public static void main(String[] args) throws Throwable {

		FileUtils f = new FileUtils();
		ExcelUtils e = new ExcelUtils();
		WebDriverUtils w = new WebDriverUtils();

		String URL = f.readDataFromPropertyFile("url");
		String USERNAME = f.readDataFromPropertyFile("manufacturerusername");
		String PASSWORD = f.readDataFromPropertyFile("manufacturerpassword");
		String LOGINTYPE = f.readDataFromPropertyFile("logintype");
		String NEWPASSWORD = f.readDataFromPropertyFile("newmanufacturerpassword");

		WebDriver driver = new ChromeDriver();
		 Thread.sleep(20000);
		driver.get(URL);

		w.implicitWait(driver, 20);
		LoginPage l = new LoginPage(driver);
		l.login(USERNAME, PASSWORD, LOGINTYPE);

		ManufacturesHomePage m = new ManufacturesHomePage(driver);
		m.editProClick();
		EditProfileManufacPage ep = new EditProfileManufacPage(driver);
		ep.changePwd(driver, PASSWORD, NEWPASSWORD);

		m.logoutClick();
		l.login(USERNAME, NEWPASSWORD, LOGINTYPE);
		String actualtitle = driver.getTitle();
		String expectedtitle = "Manufacturer: Home";
		if (actualtitle.contains(expectedtitle)) {
			System.out.println("Homepage is displayed... and its verified with title");
		} else {
			System.out.println("Homepage is Not displayed...");
		}
		m.logoutClick();
		driver.quit();
	}
}
