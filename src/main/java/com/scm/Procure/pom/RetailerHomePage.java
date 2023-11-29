package com.scm.Procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {
	
	@FindBy(xpath="//a[text()='New Order']")
	private WebElement Neworder_Btn;
	
	
	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logout_Btn;
	
	public RetailerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNeworder_Btn() {
		return Neworder_Btn;
	}

	public WebElement getLogout_Btn() {
		return logout_Btn;
	}
	
	
	//Business Logic
	
	public void newOrderClick() {
		Neworder_Btn.click();
	}
	public void logoutClick() {
		logout_Btn.click();
	}
	
}
