package com.stepdefinitions;

import org.testng.Assert;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login_ValidCredentials extends BaseUtils{

	@Given("User must click Login button on the HomePage")
	public void user_must_click_login_button_on_the_home_page() {
		
		clickElement(pageObjectManager.getHomePage().getHomePageLoginBtn());
	}

	@Given("User Click the login with Email Radio button")
	public void user_click_the_login_with_email_radio_button() {
		
		visibleOfElement(pageObjectManager.getHomePage().getEmailRadioBtn());
		
		clickElement(pageObjectManager.getHomePage().getEmailRadioBtn());
	
	}

	@Given("User enter the email address on the email field")
	public void user_enter_the_email_address_on_the_email_field() {
	
		typeText(pageObjectManager.getHomePage().getEmailID(), property.getValue(PropertyKey.mailID.name()));
	}

	@Given("User enter the password on th password fields")
	public void user_enter_the_password_on_th_password_fields() {
	
		typeText(pageObjectManager.getHomePage().getPassword(), property.getValue(PropertyKey.password.name()));
	}

	@Given("user click the Login button")
	public void user_click_the_login_button() {
	
		clickElement(pageObjectManager.getHomePage().getLoginBtn());
	}
	
	@Then("verify the Login successfully {string}")
	public void verify_the_login_successfully(String profile_Name) {
		
		visibleOfElement(pageObjectManager.getHomePage().getProfileName());
		
		String profileName = getElementText(pageObjectManager.getHomePage().getProfileName());
		
		try { Assert.assertEquals(profile_Name, profileName); } catch(Exception e) {
			
			System.out.println("problem on assert equal on profile name in " +className());
			e.printStackTrace();
		}
	}
}
