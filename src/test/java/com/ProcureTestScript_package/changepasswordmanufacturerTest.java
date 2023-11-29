package com.ProcureTestScript_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class changepasswordmanufacturerTest {
	
	public static void main(String[] args) throws IOException, Exception {
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("manufacturerusername");
		String PASSWORD = p.getProperty("manufacturerpassword");
		String LOGINTYPE = p.getProperty("logintype");
		String NEWPASSWORD = p.getProperty("newmanufacturerpassword");
		
		WebDriver driver=new ChromeDriver();
		//Thread.sleep(20000);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("login:username")).sendKeys(USERNAME);
		driver.findElement(By.id("login:password")).sendKeys(PASSWORD);
		WebElement sel = driver.findElement(By.xpath("//select[@name='login_type']"));
		Select s=new Select(sel);
		s.selectByVisibleText(LOGINTYPE);
		WebElement address = driver.findElement(By.xpath("//input[@class='submit_button']"));
		address.click();
		driver.findElement(By.xpath("//a[text()='Edit Profile']")).click();
		driver.findElement(By.xpath("//input[@value='Change Password']")).click();
		driver.findElement(By.id("oldPassword")).sendKeys(PASSWORD);
		driver.findElement(By.id("newPassword")).sendKeys(NEWPASSWORD);
		driver.findElement(By.id("confirmPassword")).sendKeys(NEWPASSWORD);
		driver.findElement(By.xpath("//input[@value='Change Password']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		driver.findElement(By.id("login:username")).sendKeys(USERNAME);
		driver.findElement(By.id("login:password")).sendKeys(NEWPASSWORD);
		WebElement sel1 = driver.findElement(By.xpath("//select[@name='login_type']"));
		Select s1=new Select(sel1);
		s1.selectByVisibleText(LOGINTYPE);
		driver.findElement(By.xpath("//input[@class='submit_button']")).click();
		String actualtitle = driver.getTitle();
		String expectedtitle="Manufacturer: Home";
		if(actualtitle.contains(expectedtitle))
		{
			System.out.println("Homepage is displayed... and its verified with title");
		}
		else
		{
			System.out.println("Homepage is Not displayed...");
		}
		driver.quit();
		}
 		}
