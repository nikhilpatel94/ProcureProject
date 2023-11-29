package com.practice_package;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	public class spicejet1 {
		
	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		String depmonth = "January";
		String depyear = "2024";
		String depdate = "7";
		
		driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']/div[@class='css-1dbjc4n r-zso239']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		driver.findElement(By.xpath("//div[text()='From']")).sendKeys("bang");
		driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
		driver.findElement(By.xpath("//div[text()='To']")).sendKeys("de");
		driver.findElement(By.xpath("//div[text()='Delhi']")).click();
		for(;;) {
			
		
		try {
			driver.findElement(By.xpath("//div[@data-testid='undefined-month-"+depmonth+"-"+depyear+"']/descendant::div[text()='"+depdate+"']")).click();
			break;
			
		} catch (Exception e) {
			driver.findElement(By.xpath("//*[name()='g' and @transform='translate(1 1)']")).click();
		}
		}
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@data-testid='undefined-month-December-2023']/descendant::div[text()='7']")).click();
				break;
				
			} catch (Exception e) {
				driver.findElement(By.xpath("//*[name()='g' and @transform='translate(1 1)']")).click();
			}
		}
		

		
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[text()='Currency']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1habvwh r-1loqt21 r-1777fci r-1mi0q7o r-1yt7n81 r-m611by r-1otgn73']/div[text()='INR']")).click();
		driver.findElement(By.xpath("//div[text()='Family & Friends']/ancestor::div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']//*[name()='circle']")).click();
		driver.findElement(By.xpath("//div[text()='Search Flight']/..")).click();
		
		
	}

	}


