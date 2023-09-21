package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features", 

					glue = "com.stepdefinitions", 
					
					monochrome = true, 
					
					dryRun = false, 
					
					plugin = {
							
							"json:target/reports/WebAutomationJsonReports.json", 
							
					        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					},

					tags = ("@SignUp_With_Existing_MobileNumber_EmailID")
				)


public class TestRunner extends AbstractTestNGCucumberTests {

}
