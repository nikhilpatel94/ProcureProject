package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkartpriceproduct {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//span[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone"+Keys.ENTER);
		List<WebElement> iphoneprod = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> iphoneprice = driver.findElements(By.xpath("//div[@class='_4rR01T']/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		for(int i=0;i<iphoneprod.size();i++) {
			String product = iphoneprod.get(i).getText();
			String price = iphoneprice.get(i).getText();
			System.out.println(product+"      "+price);
		}
		
		
		
	}

}
