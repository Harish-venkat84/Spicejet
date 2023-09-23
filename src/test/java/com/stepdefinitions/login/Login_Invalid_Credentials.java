package com.stepdefinitions.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login_Invalid_Credentials extends BaseUtils{

	Logger logger = LogManager.getLogger(Login_Invalid_Credentials.class.getName());
	
	@Given("user enter the invalid email id {string}")
	public void user_enter_the_invalid_email_id(String email) {
		
		typeText(pageObjectManager.getHomePage().getEmailID(), email);
	}
	@Given("user enter the invalid password {string}")
	public void user_enter_the_invalid_password(String password) {
	
		typeText(pageObjectManager.getHomePage().getPassword(), password);
	}
	@Given("user click the login button")
	public void user_click_the_login_button() {
	
		clickElement(pageObjectManager.getHomePage().getLoginBtn());
	}
	@Then("verify the error message {string} and {string}")
	public void verify_the_error_message_and(String message1, String message2) {
	
		visibleOfElement(pageObjectManager.getHomePage().getErrorMessage1());
		
		String error1 = getElementText(pageObjectManager.getHomePage().getErrorMessage1());
		String error2 = getElementText(pageObjectManager.getHomePage().getErrorMessage2());
		
		try {
		
			Assert.assertEquals(message1, error1);
			Assert.assertEquals(message2, error2);
		
		}catch(Exception exception) {
			
			logger.error("problem on assert equal on login error message" + exceptionClassNameAndMessage(exception));
		}
		
		clickElement(pageObjectManager.getHomePage().getErrorMessageDismissBtn());
	}
}
