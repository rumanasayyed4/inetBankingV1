package com.inetbanking.testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {  

	@Test
	public void loginTest() throws Exception
	{
		
		logger.info("URL Is opened");
		
		LoginPage loginp = new LoginPage(driver); 
		 
		Thread.sleep(3000);
		loginp.setUsername(username);
		logger.info("Entered username");
		loginp.setPassword(passwd);
		logger.info("password entered");
		loginp.clickLogin();
		logger.info("Login clicked");
		Thread.sleep(5000);
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test passed");
		}
		
		else 
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Test failed");
		}
		
	}
	
}
