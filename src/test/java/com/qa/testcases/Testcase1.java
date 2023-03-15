package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.page.TestPage;

public class Testcase1 extends BaseClass{
         public TestPage objectloginsuccessful;
         
	@BeforeClass
	public void startapplication() throws InterruptedException{
		driver = initializedriver();
		
		objectloginsuccessful=new TestPage(driver);
	}
	@Test
	public void Successfullogin() throws IOException{
		objectloginsuccessful.submitData("standard_user","secret_sauce");
	       
		String logoexistsactual = driver.getTitle();
		String logoexistsexpected = "Swag Labs";
		String logoheader = "Products";
		
		Assert.assertTrue(driver.getPageSource().contains(logoheader));
		
		Assert.assertEquals(logoexistsactual, logoexistsexpected);
		
	}
	
	
}
