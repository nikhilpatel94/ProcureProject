package com.practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class writeandgetdatafrompropertyfile {
	public static void main(String[] args) throws IOException, InterruptedException {
		Properties p=new Properties();
		p.setProperty("browser", "chrome");
		p.setProperty("url", "http://rmgtestingserver:8888/index.php?action=Login&module=Users");
		p.setProperty("username", "admin");
		p.setProperty("password", "admin");
		FileOutputStream fos=new   FileOutputStream("./src/main/resources/commondata.properties");
		p.store(fos, "write data");
		  FileInputStream fis=new FileInputStream("./src/main/resources/commondata.properties");
		  p.load(fis);
		String BROWSER = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		Thread.sleep(10000);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
	}

}
