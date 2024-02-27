package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class LoginPage extends CommonActions {
	

	
	public LoginPage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
        PageFactory.initElements(driver, this);				
	}
	
	@FindBy(name="user_name")
	WebElement tb_username;
	
	@FindBy(name="user_password")
	WebElement tb_password;
	
	@FindBy(name="Login")
	WebElement btn_login;
	
	@FindBy(name= "login_theme")
	WebElement dd_theme;
	
	@FindBy(name= "login_language")
	WebElement dd_language;
	
	@FindBy(xpath ="//img[src='include/images/vtiger-crm.gif']")
	WebElement img_logo;
	
	@FindBy(xpath ="//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement txt_errmsg;
	
	@FindBy(xpath ="//*[contains(text(),'vtiger CRM - Commercial Open Source CRM')]")
	WebElement title;
	
	
	public void setUserName(String userid)
	{
		
		inputText(tb_username, userid,userid+" has been entered into username field.");
	}
	
	public void setUserPassword(String password)
	{
		
		inputText(tb_password, password,password+" has been entered into password field.");
	}
	
	public void setTheme(String theme)
	{
		selectByIndex(dd_theme, theme, theme +"has been selected from theme dropdown");
	}
	
	public void setLanguage(String language)
	{
		selectByValue(dd_language, language,language +" has been selected from dropdown");
	}
	
	
	public void clickLogin()
	{
		clickElement(btn_login,"login button clicked.");
		
	}

	public void errmsg()
	{
		elementExist(txt_errmsg, "Error message exists on login page");
	}
	
	public void verifyLogo()
	{
		elementExist(img_logo, "Logog displayed");
		
	}
	
	public void verifyTitle()
	{
		elementExist(title,"title exists");
	}
	
	public void login(String userid, String password)
	{
		setUserName(userid);
		setUserPassword(password);
		clickLogin();
	}
	
	public void login(String userid, String password,String theme)
	{
		setUserName(userid);
		setUserPassword(password);
		setTheme(theme);
		clickLogin();
	}
	
	public void login(String userid, String password,String theme, String language)
	{
		setUserName(userid);
		setUserPassword(password);
		setTheme(theme);
		setLanguage(language);
		clickLogin();
	}
	
}


