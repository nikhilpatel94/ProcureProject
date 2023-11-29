package com.ProcureTestScript.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.scm.genericutils.ExcelUtils;
import com.scm.genericutils.FileUtils;
import com.scm.genericutils.WebDriverUtils;

public class changepasswordmanufacturerTest {
	
	public static void main(String[] args) throws Throwable {
		
		FileUtils f=new FileUtils();
		ExcelUtils e=new ExcelUtils();
		WebDriverUtils w=new WebDriverUtils();
		
		String URL = f.readDataFromPropertyFile("url");
		String USERNAME = f.readDataFromPropertyFile("manufacturerusername");
		String PASSWORD = f.readDataFromPropertyFile("manufacturerpassword");
		String LOGINTYPE = f.readDataFromPropertyFile("logintype");
		String NEWPASSWORD = f.readDataFromPropertyFile("newmanufacturerpassword");
		
		
		
		WebDriver driver=new ChromeDriver();
		//Thread.sleep(20000);
		driver.get(URL);
		
		w.implicitWait(driver, 20);
		driver.findElement(By.id("login:username")).sendKeys(USERNAME);
		driver.findElement(By.id("login:password")).sendKeys(PASSWORD);
		WebElement sel = driver.findElement(By.xpath("//select[@name='login_type']"));
		w.DropDowntext(sel, LOGINTYPE);
		
		WebElement address = driver.findElement(By.xpath("//input[@class='submit_button']"));
		address.click();
		driver.findElement(By.xpath("//a[text()='Edit Profile']")).click();
		driver.findElement(By.xpath("//input[@value='Change Password']")).click();
		driver.findElement(By.id("oldPassword")).sendKeys(PASSWORD);
		driver.findElement(By.id("newPassword")).sendKeys(NEWPASSWORD);
		driver.findElement(By.id("confirmPassword")).sendKeys(NEWPASSWORD);
		driver.findElement(By.xpath("//input[@value='Change Password']")).click();
		w.alert(driver);
		
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		driver.findElement(By.id("login:username")).sendKeys(USERNAME);
		driver.findElement(By.id("login:password")).sendKeys(NEWPASSWORD);
		WebElement sel1 = driver.findElement(By.xpath("//select[@name='login_type']"));
		w.DropDowntext(sel1, LOGINTYPE);
		
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
