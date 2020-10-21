package com.inetbanking.testCases;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ReadConfig;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002Test extends BaseClass {

	ReadConfig readconfig = new ReadConfig();
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		logger.info("Username entered");
		lp.setPassword(pwd);
		logger.info("password entered");
		lp.clickLogin();
		logger.info("login clicked");
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
		
			
			captureScreen(driver, "loginDDT");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
			
		}
		
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.logout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	
	public boolean isAlertPresent()   //user defined method to check if alert is present
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws Exception
	{
		String path = readconfig.getExcelpath();
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum; i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
	}
}
