package com.practice_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BigBasketPOM {
	
	@FindBy(xpath = "//header[@style='opacity: 1;']/descendant::div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none']")
	private WebElement shopBY_Btn;
	
	@FindBy(xpath = "//header[@style='opacity: 1;']/descendant::div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none']/parent::button/following-sibling::div/descendant::a[contains(text(),'Cakes & Dairy')]")
	private WebElement caterory;
	
	@FindBy(xpath = "//header[@style='opacity: 1;']/descendant::div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none']/parent::button/following-sibling::div/descendant::ul[@class='jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800']//li")
	private List<WebElement> sub1;
	
	@FindBy(xpath = "//header[@style='opacity: 1;']/descendant::div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none']/parent::button/following-sibling::div/descendant::ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs']//li")
	private List<WebElement> sub2;
	
	public BigBasketPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getShopBY_Btn() {
		return shopBY_Btn;
	}

	public WebElement getCaterory() {
		return caterory;
	}

	public List<WebElement> getSub1() {
		return sub1;
	}

	public List<WebElement> getSub2() {
		return sub2;
	}

	
}
