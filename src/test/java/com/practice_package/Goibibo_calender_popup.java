package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibibo_calender_popup {
	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		String month="February";
		String year="2024";
		String day="8";
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		//"//div[text()='November 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='8']"
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
				break;
				
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
			}
			
		
		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();
	}

}
