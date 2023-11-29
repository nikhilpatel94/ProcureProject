package com.scm.genericutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.scm.Procure.pom.AdminHomePage;
import com.scm.Procure.pom.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	FileUtils f = new FileUtils();
	ExcelUtils e = new ExcelUtils();
	WebDriverUtils w = new WebDriverUtils();
	DataBaseUtils d=new DataBaseUtils();
	
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable {
		
		d.connectDB();
	}
	

	
@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
public void config_BC() {
		//driver= new EdgeDriver();
		//driver=new SafariDriver();
		driver=new ChromeDriver();
//		if (b.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver();
//			}
//		else if(b.equalsIgnoreCase("edge")) {
//			driver= new EdgeDriver();
//		}
//		
		sdriver=driver;
	}
	
	@BeforeMethod(alwaysRun = true)
public void config_BM() throws Throwable {
		String URL = f.readDataFromPropertyFile("url");
		String adminUN = f.readDataFromPropertyFile("adminun");
		String adminpwd = f.readDataFromPropertyFile("adminpwd");
		String loginadmin = e.excelTestData2("addretailerandsearch", 1, 6);
		//Thread.sleep(10000);
		driver.get(URL);
		
		w.implicitWait(driver, 20);
		LoginPage l = new LoginPage(driver);
		l.login(adminUN, adminpwd, loginadmin);
		
	}
	@AfterMethod(alwaysRun = true)
public void config_AM() throws InterruptedException {
		AdminHomePage a = new AdminHomePage(driver);
		a.logoutClick();
		Thread.sleep(5000);
	}
	@AfterClass(alwaysRun = true)
public void config_AC() {
		driver.quit();
		
	}

	@AfterSuite(alwaysRun = true)
public void config_AS() throws Throwable {
		d.disconnect();
		
	}

}
