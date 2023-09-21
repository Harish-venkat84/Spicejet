package com.stepdefinitions;

import org.testng.Assert;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login_WithValidMail_ID_And_ValidPassword extends BaseUtils{

	@Given("click login button in the Homepage")
	public void click_login_button_in_the_homepage() {
	
		clickElement(pom.getHomePage().getHomePageLoginBtn());
	}
	
	@Given("user must click the Email Radio button")
	public void user_must_click_the_email_radio_button() {
	
		visibleOfElement(pom.getHomePage().getEmailRadioBtn());
		
		clickElement(pom.getHomePage().getEmailRadioBtn());
	}
	
	@Given("user enter the valid email id")
	public void user_enter_the_valid_email_id() {
	
		typeText(pom.getHomePage().getEmailID(), property.getValue(PropertyKey.mailID.name()));
	}
	
	@Given("user must enter the invalid password {string}")
	public void user_must_enter_the_invalid_password(String invalidPassword) {
	
		typeText(pom.getHomePage().getPassword(), invalidPassword);
	}
	
	@Given("user must click the login button")
	public void user_must_click_the_login_button() {
	
		clickElement(pom.getHomePage().getLoginBtn());
	}
	
	@Then("Verifying the error message {string} and {string}")
	public void verifying_the_error_message_and(String errorMessage1, String errorMessage2) {
	
		visibleOfElement(pom.getHomePage().getErrorMessage1());
		
		String error1 = getElementText(pom.getHomePage().getErrorMessage1());
		String error2 = getElementText(pom.getHomePage().getErrorMessage2());
		
		try {
		
			Assert.assertEquals(errorMessage1, error1);
			Assert.assertEquals(errorMessage2, error2);
		
		}catch(Exception e) {
			
			System.out.println("problem on assert equal on login error message" +className());
			e.printStackTrace();
		}
		clickElement(pom.getHomePage().getErrorMessageDismissBtn());
	}

}
