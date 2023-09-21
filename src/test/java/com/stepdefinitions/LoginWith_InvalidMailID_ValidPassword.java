package com.stepdefinitions;

import org.testng.Assert;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginWith_InvalidMailID_ValidPassword extends BaseUtils{

	@Given("User click login button in the Homepage")
	public void user_click_login_button_in_the_homepage() {
		
		clickElement(pom.getHomePage().getHomePageLoginBtn());
	}
	
	@Given("user Should click the Email Radio button")
	public void user_should_click_the_email_radio_button() {
		
		clickElement(pom.getHomePage().getEmailRadioBtn());
	}
	
	@Given("user enter the Invalid email id {string}")
	public void user_enter_the_invalid_email_id(String invalidEmail) {
		
		typeText(pom.getHomePage().getEmailID(), invalidEmail);
	}
	
	
	@When("user must enter the valid password")
	public void user_must_enter_the_valid_password() {
		
		typeText(pom.getHomePage().getPassword(), property.getValue(PropertyKey.password.name()));
	}
	
	@When("user Should click the login button")
	public void user_should_click_the_login_button() {
		
		clickElement(pom.getHomePage().getLoginBtn());
	}
	
	@Then("Verifying the error message {string}")
	public void verifying_the_error_message(String errorMessage) {
		
		try {
			
			String invalidEmailError = getElementText(pom.getHomePage().getInvalidEmailAddress());
			
			Assert.assertEquals(invalidEmailError, errorMessage);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
