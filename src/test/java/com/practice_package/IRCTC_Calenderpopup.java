package com.practice_package;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class IRCTC_Calenderpopup {
	
	public static void main(String[] args) {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.irctc.co.in/nget/train-search");
	String month = "December";
	String day = "7";
	driver.findElement(By.tagName("p-calendar")).click();
	for(;;) {
	try {
	driver.findElement(By.xpath("//span[text()='"+month+"']/ancestor::span/descendant::a[text()='"+day+"']")).click();
	break;

	} catch (Exception e) {
	driver.findElement(By.xpath("//span[contains(@class,'pi-chevron-right')]")).click();

	}
	}
	}

	}



