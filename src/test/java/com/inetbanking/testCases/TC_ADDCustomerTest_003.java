package com.inetbanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;

import org.testng.Assert;


public class TC_ADDCustomerTest_003 extends BaseClass{

	
	@Test
	public void addNewcustomer() throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username entered");
		lp.setPassword(passwd);
		
		logger.info("Password entered");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		//openNewcust
		
		HomePage hp = new HomePage(driver);
		hp.clickNewCustLink();
		logger.info("link clicked");
	
		//add customer details
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.addName("Kiara sharma");
		addcust.clkGender();
		addcust.selectdate("24","10","1985");
		Thread.sleep(3000);
		
		addcust.custaddress("Hadapsar");
		addcust.inputCity("Pune");
		addcust.custState("MAHARASHTRA");
		addcust.custpin("411001");
		addcust.setTele("9028725341");
		String email = randomString()+"@gmail.com";
		addcust.setEmail(email);
		addcust.setPass("abcdefqwx");
		logger.info("details entered");
		
		Thread.sleep(2000);
		
		addcust.clkSubit();
		logger.info("submit clicked");
		
		Thread.sleep(3000);
		
		boolean check = driver.getPageSource().contains("Customer Registered Successfully");
		if(check==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case failed");
		}
		
	}
	
	public String randomString()
	{
		String emailgenerate = RandomStringUtils.randomAlphabetic(7);
		return emailgenerate;
	}
}
