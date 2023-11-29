package com.practice_package;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cribuzz {
	

		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.cricbuzz.com/");
			String title = driver.findElement(By.xpath("//li[@class='cb-view-all-ga cb-match-card cb-bg-white'][1]/a")).getAttribute("title");
			String headder = driver.findElement(By.xpath("//li[@class='cb-view-all-ga cb-match-card cb-bg-white'][1]/a//div[@class='cb-col-90 cb-color-light-sec cb-ovr-flo']")).getText();
			String team1 = driver.findElement(By.xpath("(//li[@class='cb-view-all-ga cb-match-card cb-bg-white'][1]/a//span)[1]")).getText();
			String team2 = driver.findElement(By.xpath("(//li[@class='cb-view-all-ga cb-match-card cb-bg-white'][1]/a//span)[2]")).getText();
			String scoreT1 = driver.findElement(By.xpath("(//li[@class='cb-view-all-ga cb-match-card cb-bg-white'][1]/a//div[@class='cb-col-50 cb-ovr-flo'])[1]")).getText();
			String scoreT2 = driver.findElement(By.xpath("(//li[@class='cb-view-all-ga cb-match-card cb-bg-white'][1]/a//div[@class='cb-col-50 cb-ovr-flo'])[2]")).getText();
			System.out.println(title);
			System.out.println(headder);
			System.out.println(team1+"===="+scoreT1);
			System.out.println(team2+"===="+scoreT2);
			
		}

	}


