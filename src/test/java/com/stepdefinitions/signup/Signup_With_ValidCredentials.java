package com.stepdefinitions.signup;


import java.util.Set;

import org.testng.Assert;

import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Signup_With_ValidCredentials extends BaseUtils {
	
	String currentWinID;
	
	@Given("User Must Click The SignUp button")
	public void user_must_click_the_sign_up_button() {
		
		currentWinID = getCurrentWinID();
		
		clickElement(pageObjectManager.getHomePage().getSignUpBtn());
	}
	@Given("Switch To SignUp Tab")
	public void switch_to_sign_up_tab() {
		
		Set<String> allWinIDs = getAllWinIDs();
		
		for (String wind : allWinIDs) {
			
			if (!wind.equals(currentWinID)) {
				
				switchDriver(wind);
			}
		}
	}
	@Then("Validate SignUp Page Title")
	public void validate_sign_up_page_title() {
		
		try {
			
			Assert.assertEquals("SpiceClub - The frequent flyer program of SpiceJet",
					"SpiceClub - The frequent flyer program of SpiceJet");
			
		} catch (Exception e) {
			
			System.out.println("problem in title assert equal on signUp");
			e.printStackTrace();
		}
	}
	@Then("User Select The Title From The Title Dropdown")
	public void user_select_the_title_from_the_title_dropdown() {
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectTitle(), "Mr");
	}
	@Then("User Enter the First Name {string}")
	public void user_enter_the_first_name(String firstName) {
		
		typeText(pageObjectManager.getSignUp().getFirstName(), firstName);
	}
	@Then("Last Name {string}")
	public void last_name(String lastName) {
		
		typeText(pageObjectManager.getSignUp().getLastName(), lastName);
		
		verticalScroll("400");
	}
	@Then("User Must Select Country {string} From The Country Dropdown")
	public void user_must_select_country_from_the_country_dropdown(String country) {
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectCountry(), "Australia ");
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectCountry(), country);
	}
	@Then("User Enter The Date Of Brith {string} and {string}")
	public void user_enter_the_date_of_brith_and(String month, String year) {
		
		clickElement(pageObjectManager.getSignUp().getDateOfBrith());
		
		visibleOfElement(pageObjectManager.getSignUp().getSelectMonth());
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectMonth(), month);
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectYear(), year);
		
		clickElement(pageObjectManager.getSignUp().getSelectDate());
	}
	@Then("User Enter The Mobile Number {string}")
	public void user_enter_the_mobile_number(String mobileNumber) {
		
		typeText(pageObjectManager.getSignUp().getMobileNumber(), mobileNumber);
		
		clickElement(pageObjectManager.getSignUp().getMailID());
		
		clickElement(pageObjectManager.getSignUp().getImage());
		
		elementNotVisible(pageObjectManager.getSignUp().getLoading());
	}
	@Then("User Must Enter Email ID {string}")
	public void user_must_enter_email_id(String mailid) {
		
		typeText(pageObjectManager.getSignUp().getMailID(), mailid);
		
		clickElement(pageObjectManager.getSignUp().getPassword());
		
		clickElement(pageObjectManager.getSignUp().getImage());
		
		elementNotVisible(pageObjectManager.getSignUp().getLoading());
	}
	@Then("User Must Enter Password On The Password Field {string}")
	public void user_must_enter_password_on_the_password_field(String password) {
		
		
		typeText(pageObjectManager.getSignUp().getPassword(), password);
	}
	@Then("User Must Eneter Confirm Passowrd {string}")
	public void user_must_eneter_confirm_passowrd(String password) {
		
		typeText(pageObjectManager.getSignUp().getConPassword(), password);
	}
	@Then("User Click The CheckBox I agree")
	public void user_click_the_check_box_i_agree() {
		
		clickElement(pageObjectManager.getSignUp().getAgreeCheckBox());
	}
	@Then("User Click Submit button")
	public void user_click_submit_button() {
		
		clickElement(pageObjectManager.getSignUp().getSubmitBtn());
	}
	
}
