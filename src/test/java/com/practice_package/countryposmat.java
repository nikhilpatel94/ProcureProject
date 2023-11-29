package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class countryposmat {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		List<WebElement> Names = driver.findElements(By.xpath("//table/tbody/tr/td/span[@class='u-hide-phablet']"));
        List<WebElement> matches = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
       List<WebElement> pos = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
       for(int i=0;i<Names.size();i++) {
    	String countryname = Names.get(i).getText();
    	String countrymat = matches.get(i).getText();
    String countrypos = pos.get(i).getText();
    System.out.println(countryname+"   "+countrymat+"    "+countrypos+"  ");
    	
    	   
       }
	}


}

