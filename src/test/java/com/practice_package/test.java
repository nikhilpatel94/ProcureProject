package com.practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://olympics.com/en/olympic-games/tokyo-2020/athletes");
	WebElement ele = driver.findElement(By.xpath("//h2[text()='Medalists']"));
	int y=ele.getLocation().getY();
	JavascriptExecutor j= (JavascriptExecutor)driver;
	j.executeScript("window.scrollTo(0,"+y+")");
}

}
