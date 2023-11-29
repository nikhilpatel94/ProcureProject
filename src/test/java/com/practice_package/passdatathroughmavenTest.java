package com.practice_package;

import org.testng.annotations.Test;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;
	public class passdatathroughmavenTest {

		@Test
		public void data() throws InterruptedException {
			String browser = System.getProperty("browser");
			String url = System.getProperty("url");
			String username = System.getProperty("username");
			String password = System.getProperty("password");
			
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			// Thread.sleep(30000);
			driver.get(url);
			driver.findElement(By.id("login:username")).sendKeys(username);
			driver.findElement(By.id("login:password")).sendKeys(password);
			WebElement dropDown = driver.findElement(By.id("login:type"));
			Select s=new Select(dropDown);
			s.selectByVisibleText("Admin");
			driver.findElement(By.className("submit_button")).click();
			//mvn -Dbrowser=chrome -Durl=http://rmgtestingserver/domain/Supply_Chain_Management/ -Dusername=admin -Dpassword=admin123 -Dtest=passdatathroughmavenTest test
			
		}

	}
