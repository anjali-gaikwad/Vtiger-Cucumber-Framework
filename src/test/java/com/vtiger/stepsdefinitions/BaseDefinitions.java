package com.vtiger.stepsdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefinitions {
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static Map<String, Map<String,String>> dt;
	public static ExtentTest logger;
	public String TCName;
	
	
	public void initiation()
	{
		if(prop==null)
		prop=readProperties();
        if(extent==null)
		createExtetReport();
        if(dt==null)
		dt = JsonReader();
	}
	
	
	public void launchApp()
	{
		 WebDriverManager.firefoxdriver().setup();
	       driver = new FirefoxDriver();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("Implicitwait"))));
	       driver.get(prop.getProperty("AppURL"));
	       driver.manage().window().maximize();
	}
	
	
	
	public void closeApp()
	{
		driver.quit();
	}
	
	
	 
	public Map<String, Map<String,String>> JsonReader()
	{
		Map<String, Map<String, String>> userData= null;
		ObjectMapper mapper= new ObjectMapper();
		File fileObj = new File(System.getProperty("user.dir")+ "/src/test/resources/Data/TestData.json");
		try {
			userData =  mapper.readValue(
					fileObj, new TypeReference<Map<String,Map<String,String>>>(){
					} );
			//System.out.println("TCName: "+ userData.get("verifyInvalidLogin_TC04").get("Userid"));
			//System.out.println("TCName: "+ userData.get("verifyInvalidLogin_TC04").get("Password"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return userData;
	}
	
	public void createExtetReport()
	{
		Date d= new Date();
		DateFormat ft= new SimpleDateFormat("ddmmyyyyhhmmss");
		String filename= ft.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/src/test/java/com/vtiger/reports/ExtentReport"+filename+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//below data can be placed in config file and dynamically generated in below fields.
		extent.setSystemInfo("Hostname", "AtomationTestHub");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("Username", "Anjali G");
		
		htmlReporter.config().setDocumentTitle("Vtiger login page");
		htmlReporter.config().setReportName("Vtiger login page Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public Properties readProperties() 
	{
		prop=null;
		
		try {
			prop= new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/settings/conf.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		return prop;
		
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
	
	

}
