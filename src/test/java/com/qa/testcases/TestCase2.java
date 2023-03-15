package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.BaseClass;
import com.qa.page.TestPage;

public class TestCase2 extends BaseClass{
	
    public TestPage objectlogininsuccessful;
    
   
   
	@BeforeClass
	public void startapplication() throws InterruptedException{
		driver = initializedriver();
		
		objectlogininsuccessful=new TestPage(driver);
	}
	@Test
	public void Successfullogin() throws IOException{
		objectlogininsuccessful.submitData("locked_out_user","secret_sauce");
		 String expectedtext="Sorry, this user has been banned.";
		
		 
		 Assert.assertTrue(driver.getPageSource().contains(expectedtext));
		
	}
	
	}

