package com.scm.Procure.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.genericutils.WebDriverUtils;

public class OrderItemsPage extends WebDriverUtils{
	@FindBy(xpath="//input[@value='Post Order']")
	private WebElement postOrder_btn;

	public OrderItemsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPostOrder_btn() {
		return postOrder_btn;
	}

	//Business logic
	public void postOrderClick(WebDriver driver) {
		ScrollbarToBottom(driver);
		postOrder_btn.click();
	}
}
