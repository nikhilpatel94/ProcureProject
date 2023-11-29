package com.Procure.EditProfileModule;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.Procure.pom.EditProfileManufacPage;
import com.scm.Procure.pom.LoginPage;
import com.scm.Procure.pom.ManufacturesHomePage;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.NONBaseClass;
import com.scm.genericutils.WebDriverUtils;
@Listeners(com.scm.genericutils.ListnerImpliNONBASE.class)
public class changepasswordmanufacturerTest extends NONBaseClass{
@Test(retryAnalyzer = com.scm.genericutils.RetryImpliClass.class)
	public void changepasswordmanufacturer() throws Throwable {

		FileUtils f = new FileUtils();
		WebDriverUtils w = new WebDriverUtils();

		String URL = f.readDataFromPropertyFile("url");
		String USERNAME = f.readDataFromPropertyFile("manufacturerusername");
		String PASSWORD = f.readDataFromPropertyFile("manufacturerpassword");
		String LOGINTYPE = f.readDataFromPropertyFile("logintype");
		String NEWPASSWORD = f.readDataFromPropertyFile("newmanufacturerpassword");

		//WebDriver driver = new ChromeDriver();
		// Thread.sleep(20000);
		driver.get(URL);

		w.implicitWait(driver, 20);
		LoginPage l = new LoginPage(driver);
		l.login(USERNAME, PASSWORD, LOGINTYPE);

		ManufacturesHomePage m = new ManufacturesHomePage(driver);
		m.editProClick();
		//AssertJUnit.fail();
		EditProfileManufacPage ep = new EditProfileManufacPage(driver);
		ep.changePwd(driver, PASSWORD, NEWPASSWORD);

		m.logoutClick();
		l.login(USERNAME, NEWPASSWORD, LOGINTYPE);
		String actualtitle = driver.getTitle();
		String expectedtitle = "Manufacturer: Home";
		AssertJUnit.assertEquals(actualtitle, expectedtitle);
		m.logoutClick();
		driver.quit();
	}


}
