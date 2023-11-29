package com.Procure.Admin;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.Procure.pom.AdminHomePage;
import com.scm.Procure.pom.EditManufacturerPage;
import com.scm.genericutils.BaseClass;
import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.WebDriverUtils;
@Listeners(com.scm.genericutils.ListenerImplimentation.class)
public class updatemanufacturerTest extends BaseClass {
	@Test(retryAnalyzer = com.scm.genericutils.RetryImpliClass.class)
	public void updatemanufacturer() throws Throwable {

		ExcelUtils e = new ExcelUtils();
		WebDriverUtils w = new WebDriverUtils();

		AdminHomePage a = new AdminHomePage(driver);
		a.ManufacturersClick();
		//AssertJUnit.fail();
		String oUn = e.excelAutomation_TD("manufacturer", 1, 3);
		WebElement editIcon = driver.findElement(By.xpath("(//td[contains(.,'" + oUn + "')]/..)[2]//img"));
		Actions action = new Actions(driver);
		action.scrollToElement(editIcon);
		editIcon.click();
		EditManufacturerPage em = new EditManufacturerPage(driver);
		em.filldata(driver, e.ReadMultipleDataAutomation_TD("manufacturer"));
		System.out.println(driver.switchTo().alert().getText());
		w.alert(driver);

	}
}
