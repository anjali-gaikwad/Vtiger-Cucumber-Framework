package com.vtiger.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CommonActions {
	public WebDriver driver;
	public WebDriverWait wait;
	public ExtentTest logger;

	  public CommonActions(WebDriver driver,ExtentTest logger)
	{
		this.driver= driver;
		this.logger= logger;
		wait= new WebDriverWait(driver,Duration.ofSeconds(2));
	}
	  
	  public void inputText(WebElement elm, String value, String msg)
	  {
		  try
		  {
		   wait.until(ExpectedConditions.visibilityOf(elm));
		   elm.clear();
		   elm.sendKeys(value);
		   logger.pass(msg);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  logger.fail("Failed due to : "+ e.getMessage()+"<a href= '"+getScreenShot()+"'> <span class='label end-time'>Screenshot</span></a>");
		  }
	  }
	  
	  public void clickElement(WebElement elm, String msg)
	  {
		  try
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(elm));
		      elm.click();
		      logger.pass(msg);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  logger.fail("Failed due to : "+ e.getMessage()+"<a href= '"+getScreenShot()+"'> <span class='label end-time'>Screenshot</span></a>");
		  }
	  }
	  
	  public boolean elementExist(WebElement elm,String msg)
	  {
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOf(elm));
			  logger.pass(msg);
		      return elm.isDisplayed();
		      
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  logger.fail("Failed due to : "+ e.getMessage()+"<a href= '"+getScreenShot()+"'> <span class='label end-time'>Screenshot</span></a>");
			  return false;
		  }
		
	  }
	  public String getScreenShot()
		{
			Date d= new Date();
			DateFormat ft= new SimpleDateFormat("ddmmyyyyhhmmss");
			String str= ft.format(d);
			TakesScreenshot srcShot = ((TakesScreenshot)driver);
			File scrFile= srcShot.getScreenshotAs(OutputType.FILE);
			String path= System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/images/Scrrenshot_"+str+".png";
			File dtsFile=  new File(path);
			try {
				FileUtils.copyFile(scrFile, dtsFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return path;
		}
	  
	  public void selectByIndex(WebElement elm, String value, String msg)
	  {
		  try
		  {
		   wait.until(ExpectedConditions.visibilityOf(elm));
		   Select sel =new Select(elm);
		   sel.selectByIndex(Integer.parseInt(value));
		   logger.pass(msg);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  logger.fail("Failed due to : "+ e.getMessage()+"<a href= '"+getScreenShot()+"'> <span class='label end-time'>Screenshot</span></a>");
		  }
	  }
	  
	  public void selectByValue(WebElement elm, String value, String msg)
	  {
		  try
		  {
		   wait.until(ExpectedConditions.visibilityOf(elm));
		   Select sel =new Select(elm);
		   sel.selectByValue(value);
		   logger.pass(msg);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  logger.fail("Failed due to : "+ e.getMessage()+"<a href= '"+getScreenShot()+"'> <span class='label end-time'>Screenshot</span></a>");
		  }
	  }
	  
	  public void selectByText(WebElement elm, String value, String msg)
	  {
		  try
		  {
		   wait.until(ExpectedConditions.visibilityOf(elm));
		   Select sel =new Select(elm);
		   sel.selectByVisibleText(value);
		   logger.pass(msg);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  logger.fail("Failed due to : "+ e.getMessage()+"<a href= '"+getScreenShot()+"'> <span class='label end-time'>Screenshot</span></a>");
		  }
	  }

}
