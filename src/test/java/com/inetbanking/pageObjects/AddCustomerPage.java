package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="name")
	@CacheLookup
	WebElement custName;
	
	public void addName(String custoName)
	{
		custName.sendKeys(custoName);
	}
	
	@FindBy(xpath = "//input[@value='f']")
	@CacheLookup
	WebElement gender;
	
	public void clkGender()
	{
		gender.click();
	}
	
	@FindBy(xpath = "//input[@id='dob']")
	@CacheLookup
	WebElement datebirth;
	
	public void selectdate(String dd, String mm, String yyyy)
	{
		datebirth.sendKeys(dd+mm+yyyy);
	
		
	}
	
	@FindBy(name ="addr")
	@CacheLookup
	WebElement addr;
	
	public void custaddress(String add)
	{
		addr.sendKeys(add);
	}
	//select city
	
	@FindBy(name ="city")
	@CacheLookup
	WebElement city;
	
	public void inputCity(String Custcity)
	{
		city.sendKeys(Custcity);
	}
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement state;
	
	public void custState(String custState)
	{
		state.sendKeys(custState);
	}
	
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement pin;
	
	public void custpin(String pinn)
	{
		pin.sendKeys(pinn);
	}
	
	@FindBy(name ="telephoneno")
	@CacheLookup
	WebElement tele;
	
	public void setTele(String teleph)
	{
		tele.sendKeys(teleph);
	}
	
	@FindBy(how=How.NAME, using ="emailid")
	@CacheLookup
	WebElement custemail;
	
	public void setEmail(String email)
	{
	custemail.sendKeys(email);
	}
	
	@FindBy(how=How.NAME, using = "password")
	@CacheLookup
	WebElement custpasswd;
	
	public void setPass(String custp)
	{
	custpasswd.sendKeys(custp);	
	}
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement newcustSubmit;
	
	public void clkSubit()
	{
		newcustSubmit.click();
	}
}
