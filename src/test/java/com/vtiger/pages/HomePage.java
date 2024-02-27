package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class HomePage extends CommonActions{
	public ExtentTest logger;
    public String msg;
	
	
	public HomePage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Logout")
	WebElement lnk_logout;
	
	public boolean verifyLogout()
	{
		 return elementExist(lnk_logout,  "Logout link exists");
	}
	
	public void clickLogout()
	{
		clickElement(lnk_logout, "Logout link clicked");
	}
	

}
