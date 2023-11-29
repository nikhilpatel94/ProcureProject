package com.scm.Procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutils.WebDriverUtils;

public class LoginPage extends WebDriverUtils{
	
	@FindBy(id="login:username")
	private WebElement username_tfd;
	
	@FindBy(id="login:password")
	private WebElement password_tfd;
	
	@FindBy(xpath="//select[@name='login_type']")
	private WebElement loginType_dd;
	
	@FindBy(xpath="//input[@class='submit_button']")
	private WebElement login_Btn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername_tfd() {
		return username_tfd;
	}

	public WebElement getPassword_tfd() {
		return password_tfd;
	}

	public WebElement getLoginType_dd() {
		return loginType_dd;
	}

	public WebElement getLogin_Btn() {
		return login_Btn;
	}

	//Business logic
	public void login(String un,String pwd, String logintype) {
		username_tfd.sendKeys(un);
		password_tfd.sendKeys(pwd);
		DropDowntext(loginType_dd, logintype);
		login_Btn.click();
		
		
	}
	
}
