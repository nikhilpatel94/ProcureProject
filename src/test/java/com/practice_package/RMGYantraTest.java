package com.practice_package;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraTest {

	public static void main(String[] args) throws InterruptedException, Throwable {

	WebDriver driver=new ChromeDriver();
	driver.get("http://rmgtestingserver:8084/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	String expprojectname = "Procure11";
	boolean flag = false;
	driver.findElement(By.name("username")).sendKeys("rmgyantra");
	driver.findElement(By.name("password")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	driver.findElement(By.name("projectName")).sendKeys(expprojectname);
	driver.findElement(By.name("createdBy")).sendKeys("Deepak H R");
	WebElement status = driver.findElement(By.name("status"));
	Select s=new Select(status);
	s.selectByVisibleText("Created");
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	Driver driver1=new Driver();
	DriverManager.registerDriver(driver1);
	Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	 Statement state = con.createStatement();
	 String query="select project_name from project where project_name='"+expprojectname+"';";
	ResultSet result = state.executeQuery(query);
	
	while(result.next()) {
	String actualprojectname = result.getString(1);
	
	if(expprojectname.equals(actualprojectname)) {
		System.out.println("Project got created");
		flag=true;
	}
if(!flag) {
	System.out.println("project is not created");
}
con.close();	
	}
	}
	}
