package com.scm.Procure.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditManufacturerPage {
	
	@FindBy(xpath="//input[@value='Update Manufacturer']")
	private WebElement updatemanufact_btn;
	
	public EditManufacturerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getUpdatemanufact_btn() {
		return updatemanufact_btn;
	}



	public void filldata(WebDriver driver, HashMap<String, String> map) {
	for (Entry<String, String> set : map.entrySet()) {

		WebElement ele = driver.findElement(By.name(set.getKey()));

		ele.clear();

		ele.sendKeys(set.getValue());
	}
	updatemanufact_btn.click();
	}
}
