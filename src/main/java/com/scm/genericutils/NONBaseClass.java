package com.scm.genericutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class NONBaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeClass
	public void bC(){
		driver=new ChromeDriver();
		sdriver=driver;
	}

}
