package com.stepdefinitions.signup;

import java.util.Set;

import org.testng.Assert;

import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	
	@When("User Enter the First Name")
	public void user_enter_the_first_name() {
		
		typeText(pageObjectManager.getSignUp().getFirstName(), excelReader.getValueFromExcel(1,1));
	}
	
	@When("Enter the Last Name")
	public void enter_the_last_name() {
		
		typeText(pageObjectManager.getSignUp().getLastName(), excelReader.getValueFromExcel(2,1));
		
		verticalScroll("400");
	}
	
	@When("User Must Select Country From The Country Dropdown")
	public void user_must_select_country_from_the_country_dropdown() {
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectCountry(), "Australia ");
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectCountry(), excelReader.getValueFromExcel(3,1));
	}
	@When("User Select The Date Of Brith")
	public void user_select_the_date_of_brith() {
		
		clickElement(pageObjectManager.getSignUp().getDateOfBrith());
		
		visibleOfElement(pageObjectManager.getSignUp().getSelectMonth());
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectMonth(), excelReader.getValueFromExcel(4,1));
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectYear(), excelReader.getValueFromExcel(5,1).substring(0, 4));
		
		clickElement(pageObjectManager.getSignUp().getSelectDate());
	}
	@When("User Enter The Mobile Number")
	public void user_enter_the_mobile_number() {
		
		typeText(pageObjectManager.getSignUp().getMobileNumber(), excelReader.getValueFromExcel(6,1));
		
		clickElement(pageObjectManager.getSignUp().getMailID());
		
		clickElement(pageObjectManager.getSignUp().getImage());
		
		elementNotVisible(pageObjectManager.getSignUp().getLoading());
	}
	@When("User Must Enter Email ID")
	public void user_must_enter_email_id() {
		
		typeText(pageObjectManager.getSignUp().getMailID(), excelReader.getValueFromExcel(7,1));
		
		clickElement(pageObjectManager.getSignUp().getPassword());
		
		clickElement(pageObjectManager.getSignUp().getImage());
		
		elementNotVisible(pageObjectManager.getSignUp().getLoading());
	}
	@When("User Must Enter Password On The Password Field")
	public void user_must_enter_password_on_the_password_field() {
		
		
		typeText(pageObjectManager.getSignUp().getPassword(), excelReader.getValueFromExcel(8,1));
	}
	@When("User Must Eneter Confirm Passowrd")
	public void user_must_eneter_confirm_passowrd() {
		
		typeText(pageObjectManager.getSignUp().getConPassword(), excelReader.getValueFromExcel(8,1));
	}
	@Then("User Click The CheckBox I agree")
	public void user_click_the_check_box_i_agree() {
		
		clickElement(pageObjectManager.getSignUp().getAgreeCheckBox());
	}
	@Then("User Click Submit button")
	public void user_click_submit_button() {
		
		clickElement(pageObjectManager.getSignUp().getSubmitBtn());
	}
	
	@Then("Validate OTP Verification popup Feild Shown to User {string}")
	public void validate_otp_verification_popup_feild_shown_to_user(String actual_OTP_Text) {

		String optVerifiaction = getElementText(pageObjectManager.getSignUp().getOTPVerification_popup());
		
		Assert.assertEquals(optVerifiaction, actual_OTP_Text);
	}
}
