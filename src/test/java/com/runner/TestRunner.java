package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "features", 
		
		glue = ("com.stepdefinitions"), 
		
		monochrome = true, 
		
		dryRun = false,				
		
		plugin = {
			"json:target/cucumber-report/cucumber.json", "html:target/cucumber-report/cucumber.html",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
		},
		
//		tags = "@SignUp"
//		tags = "@loginValidCredentials"
//		tags = "@loginInvaildCredentials"
//		tags = "@OneWayTrip"
//		tags = "@RoundTrip"
		tags = "@OneWayTrip or @FlightBooking"
//		tags = "@homepage"
		)

public class TestRunner extends AbstractTestNGCucumberTests {

	
}
