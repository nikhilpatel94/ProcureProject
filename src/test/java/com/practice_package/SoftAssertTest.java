package com.practice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	@Test
	public void soft() {
		SoftAssert s=new SoftAssert();
			String exp="Login";
			WebDriver driver=new  ChromeDriver();
			//Thread.sleep(10000);
			driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
			String act = driver.getTitle();
			s.assertEquals(act, exp);
			s.assertAll();
			System.out.println(act);
			driver.quit();
		}
	}


