package com.scm.genericutils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	
	 public void maximize(WebDriver driver) {
		 driver.manage().window().maximize();
	 }
	 
	 public void minimize(WebDriver driver) {
		 driver.manage().window().minimize();
	 }
	 
		 public void implicitWait(WebDriver driver,int sec) {
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
			 
		 }
	 
		public void explicitwait(WebDriver driver,int sec, WebElement ele) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.visibilityOf(ele));
			
		}
	
		public void explicitwaitclickable(WebDriver driver, WebElement ele,int sec) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			
		}

		public void DropDownIndex(WebElement ele ,int index) {
			Select s=new Select(ele);
			s.selectByIndex(index);
		}
		public void DropDownvalue(WebElement ele ,String value) {
			Select s=new Select(ele);
			s.selectByValue(value);
		}
		
		public void DropDowntext(WebElement ele ,String text) {
			Select s=new Select(ele);
			s.selectByVisibleText(text);
		}
		
		public void  DragAnddrop(WebDriver driver,WebElement src,WebElement dest){
			
			Actions a=new Actions(driver);
			a.dragAndDrop(src, dest).perform();	
		}
		
		public void moveToElement(WebDriver driver,WebElement target) {
			Actions a=new Actions(driver);
			a.moveToElement(target).perform();	
		}
		public void doubleClick(WebDriver driver) {
			Actions a=new Actions(driver);
			a.doubleClick().perform();
			
		}
		public void doubleClick(WebDriver driver,WebElement target) {
			Actions a=new Actions(driver);
			a.doubleClick(target).perform();
			
		}
		public void rightClick(WebDriver driver) {
			Actions a=new Actions(driver);
			a.contextClick().perform();
			
		}
		public void rightClick(WebDriver driver,WebElement target) {
			Actions a=new Actions(driver);
			a.contextClick(target).perform();
			
		}
		
		public void keyPressEnter(WebDriver driver) {
			Actions a=new Actions(driver);
			a.sendKeys(Keys.ENTER).perform();
			}
		
		public void keyPressEnterRobot() throws Exception {
			Robot e=new Robot();
			e.keyPress(KeyEvent.VK_ENTER);
		}
		
		public void keyreleaseEnterRobot() throws Exception {
			Robot e=new Robot();
			e.keyRelease(KeyEvent.VK_ENTER);	
		}
		
		public void switchtoFrame(WebDriver driver,int index) {
			driver.switchTo().frame(index);
			
		}
		
		public void switchtoFrame(WebDriver driver,String nameorID) {
			driver.switchTo().frame(nameorID);
			
		}
		public void switchtoFrame(WebDriver driver,WebElement ele) {
			driver.switchTo().frame(ele);
			
		}
		
		public void switchtoWindow(WebDriver driver,String ele) {
			driver.switchTo().window(ele);
		}
		public void ScrollbarTo(WebDriver driver,int x,int y) {
			JavascriptExecutor j= (JavascriptExecutor)driver;
			j.executeScript("window.scrollBy("+x+","+y+")");
		}
		public void ScrollbarBy(WebDriver driver,int x,int y) {
			JavascriptExecutor j= (JavascriptExecutor)driver;
			j.executeScript("window.scrollBy("+x+","+y+")");
		}
		public void ScrollbarToBottom(WebDriver driver) {
			JavascriptExecutor j= (JavascriptExecutor)driver;
			j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		
		public void ScrollbarToTop(WebDriver driver) {
			JavascriptExecutor j= (JavascriptExecutor)driver;
			j.executeScript("window.scrollTo(0,0)");
		}
		
		public void ScrollUntilElementisVisible(WebDriver driver,WebElement ele) {
			int y=ele.getLocation().getY();
			JavascriptExecutor j= (JavascriptExecutor)driver;
			j.executeScript("window.scrollTo(0,"+y+")");
			//j.executeScript("arguments[0].scrollIntoView():",ele);
			
		}
		public void alert(WebDriver driver) {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
			
		}
		
		
		
		
		
