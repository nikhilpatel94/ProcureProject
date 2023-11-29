package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Countrynamepresent {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		String name = "South Africa";
		List<WebElement> Names = driver.findElements(By.xpath("//table/tbody/tr/td/span[@class='u-hide-phablet']"));
		
		for(WebElement a:Names) {
			
			String countryname = a.getText();
			if(countryname.equals(name)) {
			
				System.out.println("true");
			}
		
	}

}
}

