package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class KSRTC_Calender_Popup_Test {
	
public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.ksrtc.in/oprs-web/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.id("txtJourneyDate")).click();
	driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='7']")).click();
    driver.quit();
	
	
	
}

	
 


	}
	


