package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws Throwable {
		WebDriver  driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//header[@style='opacity: 1;']/descendant::div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none']")).click();
		WebElement target = driver.findElement(By.xpath("//header[@style='opacity: 1;']/descendant::div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none']/parent::button/following-sibling::div/descendant::a[contains(text(),'Cakes & Dairy')]"));
		Actions a=new Actions(driver);
		Thread.sleep(5000);
		a.moveToElement(target).perform();
		Thread.sleep(5000);
		List<WebElement> fruits = driver.findElements(By.xpath("//header[@style='opacity: 1;']/descendant::div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none']/parent::button/following-sibling::div/descendant::ul[@class='jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800']//li"));
		Thread.sleep(5000);
		List<WebElement> fruits1 = driver.findElements(By.xpath("//header[@style='opacity: 1;']/descendant::div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none']/parent::button/following-sibling::div/descendant::ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs']//li"));
for(WebElement b :fruits) {
	System.out.println(b.getText());
}
for(WebElement c:fruits1) {
	System.out.println(c.getText());
}
	}
	
}
