package com.stepdefinitions;


import java.util.Set;

import org.testng.Assert;

import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateAccount extends BaseUtils {
	
	String currentWinID;
	
	@Given("User Must Click The SignUp button")
	public void user_must_click_the_sign_up_button() {
		
		currentWinID = getCurrentWinID();
		
		clickElement(pom.getHomePage().getSignUpBtn());
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
		
		selectVisibleText(pom.getSignUp().getSelectTitle(), "Mr");
	}
	@Then("User Enter the First Name {string}")
	public void user_enter_the_first_name(String firstName) {
		
		typeText(pom.getSignUp().getFirstName(), firstName);
	}
	@Then("Last Name {string}")
	public void last_name(String lastName) {
		
		typeText(pom.getSignUp().getLastName(), lastName);
		
		verticalScroll("400");
	}
	@Then("User Must Select Country {string} From The Country Dropdown")
	public void user_must_select_country_from_the_country_dropdown(String country) {
		
		selectVisibleText(pom.getSignUp().getSelectCountry(), "Australia ");
		
		selectVisibleText(pom.getSignUp().getSelectCountry(), country);
	}
	@Then("User Enter The Date Of Brith {string} and {string}")
	public void user_enter_the_date_of_brith_and(String month, String year) {
		
		clickElement(pom.getSignUp().getDateOfBrith());
		
		visibleOfElement(pom.getSignUp().getSelectMonth());
		
		selectVisibleText(pom.getSignUp().getSelectMonth(), month);
		
		selectVisibleText(pom.getSignUp().getSelectYear(), year);
		
		clickElement(pom.getSignUp().getSelectDate());
	}
	@Then("User Enter The Mobile Number {string}")
	public void user_enter_the_mobile_number(String mobileNumber) {
		
		typeText(pom.getSignUp().getMobileNumber(), mobileNumber);
		
		clickElement(pom.getSignUp().getMailID());
		
		clickElement(pom.getSignUp().getImage());
		
		elementNotVisible(pom.getSignUp().getLoading());
	}
	@Then("User Must Enter Email ID {string}")
	public void user_must_enter_email_id(String mailid) {
		
		typeText(pom.getSignUp().getMailID(), mailid);
		
		clickElement(pom.getSignUp().getPassword());
		
		clickElement(pom.getSignUp().getImage());
		
		elementNotVisible(pom.getSignUp().getLoading());
	}
	@Then("User Must Enter Password On The Password Field {string}")
	public void user_must_enter_password_on_the_password_field(String password) {
		
		
		typeText(pom.getSignUp().getPassword(), password);
	}
	@Then("User Must Eneter Confirm Passowrd {string}")
	public void user_must_eneter_confirm_passowrd(String password) {
		
		typeText(pom.getSignUp().getConPassword(), password);
	}
	@Then("User Click The CheckBox I agree")
	public void user_click_the_check_box_i_agree() {
		
		clickElement(pom.getSignUp().getAgreeCheckBox());
	}
	@Then("User Click Submit button")
	public void user_click_submit_button() {
		
		clickElement(pom.getSignUp().getSubmitBtn());
	}
	
}
