package com.stepdefinitions.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login_WithValidMail_ID_And_ValidPassword extends BaseUtils{

	Logger logger = LogManager.getLogger(Login_WithValidMail_ID_And_ValidPassword.class.getName());
	
	@Given("user enter the valid email id")
	public void user_enter_the_valid_email_id() {
	
		typeText(pageObjectManager.getHomePage().getEmailID(), property.getValue(PropertyKey.mailID.name()));
	}
	
	@Given("user must enter the invalid password {string}")
	public void user_must_enter_the_invalid_password(String invalidPassword) {
	
		typeText(pageObjectManager.getHomePage().getPassword(), invalidPassword);
	}
	
	@Given("user must click the login button")
	public void user_must_click_the_login_button() {
	
		clickElement(pageObjectManager.getHomePage().getLoginBtn());
	}
	
	@Then("Verifying the error message {string} and {string}")
	public void verifying_the_error_message_and(String errorMessage1, String errorMessage2) {
	
		visibleOfElement(pageObjectManager.getHomePage().getErrorMessage1());
		
		String error1 = getElementText(pageObjectManager.getHomePage().getErrorMessage1());
		String error2 = getElementText(pageObjectManager.getHomePage().getErrorMessage2());
		
		try {
		
			Assert.assertEquals(errorMessage1, error1);
			Assert.assertEquals(errorMessage2, error2);
		
		}catch(Exception exception) {
			
			logger.error("problem on assert equal on login error message" + exceptionClassNameAndMessage(exception));
		}
		clickElement(pageObjectManager.getHomePage().getErrorMessageDismissBtn());
	}

}
