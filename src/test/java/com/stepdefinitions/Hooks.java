package com.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.spicejet.utils.BaseUtils;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Hooks extends BaseUtils{
	
	@BeforeAll
	public static void browserLaunch() {
		
		launchBrowser("Chrome", property.getURL(), "");
	}
	
	@AfterStep
	public static void takescreenshot(Scenario scenario) {
		
		String name = scenario.getName();
		
//		System.out.println("scenario Name :"+name);
		
		if (scenario.isFailed()) {
			
			System.out.println("Scenario Fail : "+name);
			
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
			scenario.attach(screenshot, "image/png", "imagepass");
		
			Status status = scenario.getStatus();
			System.out.println("scenario status :"+status);
		}
		
		
	}
	
	
	@AfterAll
	public static void browserClose() {
		
		try {
			
//			Thread.sleep(2000);
			closeAllBrowsers();
			
		} catch (Exception e) {
			
		}
		
	}

}
