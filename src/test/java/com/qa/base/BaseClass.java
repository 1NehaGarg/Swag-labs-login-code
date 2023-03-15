package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public  WebDriver driver;

		public WebDriver initializedriver() throws InterruptedException{
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\gargv\\OneDrive\\Documents\\Neha\\New1\\chromedriver_win32\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		  driver.get("https://www.saucedemo.com/");
		  driver.manage().deleteAllCookies();
		  driver.manage().window().maximize();
		  Thread.sleep(3000);
		return driver;
		  
	  }
	
	public void closetab(){
		driver.quit();
	}

}
