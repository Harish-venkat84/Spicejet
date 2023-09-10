package com.stepdefinitions;

import org.testng.Assert;

import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login_Negative extends BaseUtils{

	@Given("user click login button in the Homepage")
	public void user_click_login_button_in_the_homepage() {
		
		clickElement(pom.getHomePage().getHomePageLoginBtn());
	}
	@Given("user click the email radio button")
	public void user_click_the_email_radio_button() {
		
		clickElement(pom.getHomePage().getEmailRadioBtn());
	}
	@Given("user enter the invalid email id {string}")
	public void user_enter_the_invalid_email_id(String email) {
		
		typeText(pom.getHomePage().getEmailID(), email);
	}
	@Given("user enter the invalid password {string}")
	public void user_enter_the_invalid_password(String password) {
	
		typeText(pom.getHomePage().getPassword(), password);
	}
	@Given("user click the login button")
	public void user_click_the_login_button() {
	
		clickElement(pom.getHomePage().getLoginBtn());
	}
	@Then("verify the error message {string} and {string}")
	public void verify_the_error_message_and(String message1, String message2) {
	
		visibleOfElement(pom.getHomePage().getErrorMessage1());
		
		String error1 = getElementText(pom.getHomePage().getErrorMessage1());
		String error2 = getElementText(pom.getHomePage().getErrorMessage2());
		
		try {
		
			Assert.assertEquals(message1, error1);
			Assert.assertEquals(message2, error2);
		
		}catch(Exception e) {
			
			System.out.println("problem on assert equal on login error message" +className());
			e.printStackTrace();
		}
		clickElement(pom.getHomePage().getErrorMessageDismissBtn());
	}
}
