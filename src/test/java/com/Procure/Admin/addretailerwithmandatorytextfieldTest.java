package com.Procure.Admin;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.Procure.pom.AddRetailerPage;
import com.scm.Procure.pom.AdminHomePage;
import com.scm.genericutils.BaseClass;
import com.scm.genericutils.ExcelUtils;
@Listeners(com.scm.genericutils.ListenerImplimentation.class)
public class addretailerwithmandatorytextfieldTest extends BaseClass {
	@Test(retryAnalyzer = com.scm.genericutils.RetryImpliClass.class,groups = "smoke")
	public void addretailerwithmandatorytextfield() throws Throwable {

		ExcelUtils e = new ExcelUtils();


		String areacode = e.excelTestData2("addretailerandsearch", 1, 7);
		String expretailer = e.excelTestData2("addretailerandsearch", 0, 1);
		String retailerusername = e.excelTestData2("addretailerandsearch", 0, 1);

		AdminHomePage a = new AdminHomePage(driver);
		a.addRetailerClick();
		//AssertJUnit.fail();
		AddRetailerPage a1 = new AddRetailerPage(driver);
		a1.fillAllFileds(driver, e.readMultipleData("addretailerandsearch"), areacode);
		a.RetailersClick();

		String actretailer = driver.findElement(By.xpath(
				"//table[@class='table_displayData']/descendant::td[contains(text(),'" + retailerusername + "')]"))
				.getText();
		AssertJUnit.assertEquals(actretailer, expretailer);
	}
	
	
}
