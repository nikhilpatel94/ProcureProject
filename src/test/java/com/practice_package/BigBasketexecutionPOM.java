package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketexecutionPOM {
	public static void main(String[] args) throws Throwable {
		WebDriver  driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BigBasketPOM b=new  BigBasketPOM(driver);
		b.getShopBY_Btn().click();
		WebElement target=b.getCaterory();
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
		List<WebElement> fruits = b.getSub1();
		List<WebElement> fruits1 = b.getSub2();
		for(WebElement d :fruits) {
			System.out.println(d.getText());
		}
		for(WebElement c:fruits1) {
			System.out.println(c.getText());
		}
}
}
