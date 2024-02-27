package com.vtiger.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

               features ="src/test/resources/Features",
               glue = "com.vtiger.stepsdefinitions",
               dryRun= true,
               //plugin = {"pretty", "html:taget/cucumber-html-report.html", "json:target/cucumber.json"},
               monochrome = true,
               tags = "@TC13"
               


)
public class TestRunner {

}
