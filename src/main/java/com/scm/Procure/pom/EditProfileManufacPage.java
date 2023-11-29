package com.scm.Procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutils.WebDriverUtils;

public class EditProfileManufacPage extends WebDriverUtils{
	
	@FindBy(xpath="//input[@value='Change Password']")
	private WebElement changepwd_Btn;
	
	@FindBy(id="oldPassword")
	private WebElement oldpassword_tfd;
	
	@FindBy(id="newPassword")
	private WebElement newpassword_tfd;

	@FindBy(id="confirmPassword")
	private WebElement confirpassword_tfd;
	
	
	public EditProfileManufacPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getChangepwd_Btn() {
		return changepwd_Btn;
	}


	public WebElement getOldpassword_tfd() {
		return oldpassword_tfd;
	}


	public WebElement getNewpassword_tfd() {
		return newpassword_tfd;
	}


	public WebElement getConfirpassword_tfd() {
		return confirpassword_tfd;
	}
	
	//Business logic
	public void changePwd(WebDriver driver,  String oldpwd, String newpwd) {
		changepwd_Btn.click();
		oldpassword_tfd.sendKeys(oldpwd);
		newpassword_tfd.sendKeys(newpwd);
		confirpassword_tfd.sendKeys(newpwd);
		changepwd_Btn.click();	
		alert(driver);
	}
}
