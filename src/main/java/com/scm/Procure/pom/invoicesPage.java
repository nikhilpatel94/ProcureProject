package com.scm.Procure.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.scm.genericutils.WebDriverUtils;

public class invoicesPage extends WebDriverUtils {
	@FindBy(id="cmbFilter")
	private WebElement search_DD;
	
	@FindBy(id="txtInvoiceId")
	private WebElement search_Tfd;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement search_Btn;
	
	public invoicesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearch_DD() {
		return search_DD;
	}

	public WebElement getSearch_Tfd() {
		return search_Tfd;
	}

	public WebElement getSearch_Btn() {
		return search_Btn;
	}
	//Business logic
	public void search(String searchval,  String expeid, WebDriver driver ) {
		DropDownvalue(search_DD, searchval);
		search_Tfd.sendKeys(expeid);
		search_Btn.click();
		String actualid = driver.findElement(By.xpath(
				"//th[contains(text(),'Invoice ID')]/parent::tr/following-sibling::tr/child::td[contains(text(),'"
						+ expeid + "')][1]"))
				.getText();
		Assert.assertEquals(actualid, expeid);
//		if (actualid.contains(actualid)) {
//			System.out.println("invoice is displayed");
//		} else {
//			System.out.println("invoice is not displayed");
//		}
		
	}

}
