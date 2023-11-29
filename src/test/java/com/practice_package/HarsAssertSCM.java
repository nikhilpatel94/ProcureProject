package com.practice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HarsAssertSCM {

	@Test
	public void hard() throws Throwable {
		String exp="Login";
		WebDriver driver=new  ChromeDriver();
		//Thread.sleep(10000);
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		String act = driver.getTitle();
		Assert.assertEquals(act, exp);
		System.out.println(act);
		driver.quit();
	}
}
