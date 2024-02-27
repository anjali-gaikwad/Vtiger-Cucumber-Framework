package com.vtiger.stepsdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStepDefinitions extends BaseDefinitions{
public LoginPage lp;
public HomePage hp;

@Before
public void getScenarioName(Scenario scenario)
{
	initiation();
	TCName = scenario.getName();
	logger = extent.createTest(TCName);
}

@After
public void tearDown()
{
   extent.flush();
   driver.quit();	
}
@Given("user should be on login page")
public void user_should_be_on_login_page() {
	
       launchApp();
       lp= new LoginPage(driver,logger);
       hp = new HomePage(driver,logger);
}
@When("user enters valid credentials")
public void user_enters_valid_credentials() {
	lp.setUserName(dt.get(TCName).get("Userid"));
    lp.setUserPassword(dt.get(TCName).get("Password"));
}
@When("click on login button")
public void click_on_login_button() {
	 lp.clickLogin();
}
@Then("user should be on home page")
public void user_should_be_on_home_page() {
    Assert.assertEquals(true, hp.verifyLogout());
}
@Then("user can see logout option")
public void user_can_see_logout_option() {
	Assert.assertEquals(true, hp.verifyLogout());
	
}

@When("user enters valid credentials userid as {string} and password as {string}")
public void user_enters_valid_credentials_userid_as_and_password_as(String a, String b) {
	lp.setUserName(a);
    lp.setUserPassword(b);
    
}


@When("user enters valid credentials userid {string} and password {string}")
public void user_enters_valid_credentials_userid_and_password(String string, String string1, io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    
    List<Map<String,String>> mp= dataTable.asMaps();
    for(Map<String, String> m: mp)
    {
    	lp.setUserName(m.get("userID"));
        lp.setUserPassword(m.get("password"));
    }
}

@When("user enters valid credentials and theme")
public void user_enters_valid_credentials_and_theme() {
	lp.setUserName(dt.get(TCName).get("Userid"));
    lp.setUserPassword(dt.get(TCName).get("Password"));
    lp.setTheme(dt.get(TCName).get("Theme"));
}

@When("user enters valid credentials and theme and language")
public void user_enters_valid_credentials_and_theme_and_language() {
	lp.setUserName(dt.get(TCName).get("Userid"));
    lp.setUserPassword(dt.get(TCName).get("Password"));
    lp.setTheme(dt.get(TCName).get("Theme"));
    lp.setTheme(dt.get(TCName).get("Language"));
}


}
