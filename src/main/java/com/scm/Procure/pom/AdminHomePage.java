package com.scm.Procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	//declearation
	@FindBy(xpath="//a[text()='Add Retailers']")
	private WebElement addRetailer_Btn;
	
	@FindBy(xpath="//a[text()='Retailers']")
	private WebElement Retailers_Btn;
	
	@FindBy(xpath="//a[.='Manufacturers']")
	private WebElement Manufacturers_Btn;
	
	@FindBy(xpath="//a[text()='Invoice']")
	private WebElement Invoice_Btn;
	
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement logout_Btn;
	
	
	//Initilization

	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
//Utilization
	public WebElement getAddRetailer_Btn() {
		return addRetailer_Btn;
	}

	public WebElement getRetailers_Btn() {
		return Retailers_Btn;
	}

	public WebElement getManufacturers_Btn() {
		return Manufacturers_Btn;
	}

	public WebElement getInvoice_Btn() {
		return Invoice_Btn;
	}
	
	public WebElement getLogout_Btn() {
		return logout_Btn;
	}

	//Business logic
	public void addRetailerClick() {
		addRetailer_Btn.click();
	}
	
	public void RetailersClick() {
		Retailers_Btn.click();
	}
	
	public void ManufacturersClick() {
		Manufacturers_Btn.click();
	}
	
	public void InvoiceClick() {
		Invoice_Btn.click();
	}
	public void logoutClick() {
		logout_Btn.click();
	}
}
