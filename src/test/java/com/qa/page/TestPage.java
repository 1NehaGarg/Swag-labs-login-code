package com.qa.page;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;

public class TestPage {

	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='submit-button btn_action']")
	WebElement loginbutton;
	
	
	
	@FindBy(xpath="//input[@value='standard_user']")
	WebElement outputusername;
	
	@FindBy(xpath="//input[@value='secret_sauce']")
     WebElement outputpassword;
	
	
	public TestPage(WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	public void submitData(String Name,String pass) throws IOException{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		username.sendKeys(Name);
		password.sendKeys(pass);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginbutton.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
	
		TakesScreenshot objscreenshot = (TakesScreenshot) driver;
		
		File sourcefile = objscreenshot.getScreenshotAs(OutputType.FILE);
		
		
		
		File targetfile = new File ("C:\\Users\\gargv\\OneDrive\\Pictures\\mysourcefile.png");
		
		
		Files.copy(sourcefile, targetfile);
	}
		public String getusername(){
			
			return outputusername.getText();
			
		}
		
		public String getpassword(){
			return outputpassword.getText();
		}
	}

