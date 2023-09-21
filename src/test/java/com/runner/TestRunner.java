package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features", glue = "com.stepdefinitions", 
					
					monochrome = true, dryRun = false, 
					
					plugin = {
							
							"json:target/reports/WebAutomationJsonReports.json", 
							
					        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					},

					tags = ("@searchFlight_Without_Entering_Details")
				)


public class TestRunner extends AbstractTestNGCucumberTests {

	/*
	 * To run any test case, open the feature files, copy the tag name, and paste it over the tag value.
	 * 
	 * Reports will be generated under the target folder. The JSON report for Jenkins attachments and 
	 * the other two reports One is a normal spark report, 
	 * and the other is an extended HTML report, which will have more details.
	 * 
	 * If the step fails, a screenshot will be taken, and the screenshot will be attached to the reports.
	 * 
	 * The report will be generated under the target folder.
	 * 
	 */
	
}
