package com.scm.Procure.pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutils.WebDriverUtils;

public class AddProductManufacPage extends WebDriverUtils {
	
	@FindBy(xpath="//select[@name='cmbProductUnit']")
	private WebElement unit_dd;
	
	@FindBy(xpath="//select[@name='cmbProductCategory']")
	private WebElement category_dd;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement enableRadio_Btn;
	
	@FindBy(xpath="//textarea[@id='product:description']")
	private WebElement description_Tfd;
	
	@FindBy(xpath="//input[@value='Add Product']")
	private WebElement addProduct_Btn;
	
	public AddProductManufacPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getUnit_dd() {
		return unit_dd;
	}



	public WebElement getCategory_dd() {
		return category_dd;
	}



	public WebElement getEnableRadio_Btn() {
		return enableRadio_Btn;
	}



	public WebElement getDescription_Tfd() {
		return description_Tfd;
	}



	public WebElement getAddProduct_Btn() {
		return addProduct_Btn;
	}


	//Business Flow

	public void fillAllFields(WebDriver driver, HashMap<String, String> map, String unit, String category, String desc) {
		
	for(Entry<String, String> set: map.entrySet())
	{
		if(set.getKey().contains("product:name"))
		{
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
		}
		else if ((set.getKey().contains("product:price") ))
		{
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());       
		       
		}
	}
	DropDowntext(unit_dd, unit);
	DropDowntext(category_dd, category);
	enableRadio_Btn.click();
	description_Tfd.sendKeys(desc);
	addProduct_Btn.click();
	}
	
	
	
	
}
