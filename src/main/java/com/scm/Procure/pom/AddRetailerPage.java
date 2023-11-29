package com.scm.Procure.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutils.WebDriverUtils;

public class AddRetailerPage extends WebDriverUtils{
	
	@FindBy(xpath="//input[@value='Add Retailer']")
	private WebElement AddRetailer_Btn;
	
	@FindBy(id="retailer:areaCode")
	private WebElement areaCode_DD;
	
	
	public WebElement getAreaCode_DD() {
		return areaCode_DD;
	}

	public AddRetailerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddRetailer_Btn() {
		return AddRetailer_Btn;
	}
	
	//Business logic
	public void fillAllFileds(WebDriver driver, HashMap<String, String> map, String code) {
	for(Entry<String, String> a:map.entrySet()) {
		driver.findElement(By.name(a.getKey())).sendKeys(a.getValue());
	}
	DropDowntext(areaCode_DD, code);
	AddRetailer_Btn.click();
	 alert(driver);
	
		}

}
