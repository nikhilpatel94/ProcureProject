package com.scm.Procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturesHomePage {
	
	@FindBy(xpath="//a[text()='Edit Profile']")
	private WebElement EditProfileLink;
	
	@FindBy(xpath="//a[text()='Add Products']")
	private WebElement addproductLink;
	
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement Logout_Btn;
	
	public ManufacturesHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEditProfileLink() {
		return EditProfileLink;
	}

	public WebElement getAddproductLink() {
		return addproductLink;
	}

	public WebElement getLogout_Btn() {
		return Logout_Btn;
	}
	
	public void editProClick() {
		EditProfileLink.click();
	}

	public void addProClick(WebDriver driver ) {
		addproductLink.click();
		String actualaddproducttitle = driver.getTitle();
		String expectedproductpagetitle= "Add Product";
		if(actualaddproducttitle.equals(expectedproductpagetitle))
		{
			System.out.println("addProduct page is displayed... and its verified with title");
		}
		else
		{
			System.out.println("addProduct page is Not displayed...");
		}
	}
	
	public void logoutClick() {
		Logout_Btn.click();
	}
}
