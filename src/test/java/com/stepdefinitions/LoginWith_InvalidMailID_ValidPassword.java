package com.stepdefinitions;

import org.testng.Assert;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginWith_InvalidMailID_ValidPassword extends BaseUtils{

	@Given("user enter the Invalid email id {string}")
	public void user_enter_the_invalid_email_id(String invalidEmail) {
		
		typeText(pageObjectManager.getHomePage().getEmailID(), invalidEmail);
	}
	
	
	@When("user must enter the valid password")
	public void user_must_enter_the_valid_password() {
		
		typeText(pageObjectManager.getHomePage().getPassword(), property.getValue(PropertyKey.password.name()));
	}
	
	@When("user Should click the login button")
	public void user_should_click_the_login_button() {
		
		clickElement(pageObjectManager.getHomePage().getLoginBtn());
	}
	
	@Then("Verifying the error message {string}")
	public void verifying_the_error_message(String errorMessage) {
		
		try {
			
			String invalidEmailError = getElementText(pageObjectManager.getHomePage().getInvalidEmailAddress());
			
			Assert.assertEquals(invalidEmailError, errorMessage);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
