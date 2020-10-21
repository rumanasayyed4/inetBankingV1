package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver localdriver;
	
	 public LoginPage(WebDriver remotedriver) {
		// TODO Auto-generated constructor stub
		 localdriver=remotedriver;
		 PageFactory.initElements(remotedriver, this);
	}
	 
	 @FindBy(name="uid")
	 @CacheLookup
	 WebElement username;
	 
	 @FindBy(name="password") 
	 @CacheLookup
	 WebElement password;
	 
	 @FindBy(name="btnLogin")
	 @CacheLookup
	 WebElement LoginBtn;
	 
	 @FindBy(linkText = "Log out")
	 @CacheLookup
	 WebElement logout;
	 
	 public void setUsername(String uname)
	 {
		 username.sendKeys(uname);
	 }
	
	 public void setPassword(String passwd)
	 {
		 password.sendKeys(passwd);
	 }
	 
	 public void clickLogin()
	 { 
		 LoginBtn.click();
	 }
	 
	 public void logout()
	 {
		 logout.click();
	 }
}
