package com.practice_package;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.Counta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {
	
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
	
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> alllinks = driver.findElements(By.xpath("//a[@href]"));
		int totallin = alllinks.size();
		System.out.println(totallin);
		ArrayList<String> arrLink = new ArrayList<String>();
		int count=0;
		
		for(WebElement a:alllinks) {
			String eachlink = a.getAttribute("href");
			try {
				URL url=new URL(eachlink);
				HttpURLConnection urlconn= (HttpURLConnection)url.openConnection();
				int statuscode=urlconn.getResponseCode();
				
				if(statuscode>=400) {
					count++;
					arrLink.add(eachlink);
					System.out.println(eachlink+"-----"+statuscode);
					
				}
			} catch (MalformedURLException e) {
			}
		}
		System.out.println(count);
		}
	}
