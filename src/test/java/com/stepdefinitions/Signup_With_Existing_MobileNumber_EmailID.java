package com.stepdefinitions;

import org.testng.Assert;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Signup_With_Existing_MobileNumber_EmailID extends BaseUtils{
	
	// Scenario: Validating without Entering any Credentials Clicking Sibmit button
	
	@Given("User just Click the Submit button")
	public void user_just_click_the_submit_button() {
		
		verticalScroll("400");
		
		visibleOfElement(pageObjectManager.getSignUp().getSubmitBtn());
	
		clickElementUsingJavaScript(pageObjectManager.getSignUp().getSubmitBtn());
	}
	
	@Then("Validate the fill all mandatory fields message shown to user {string}")
	public void validate_the_fill_all_mandatory_fields_message_shown_to_user(String actualMessage) {
	
		try {
			
			verticalScroll("-400");
			
			String message = getElementText(pageObjectManager.getSignUp().getFillAllMandatoryErrorMessage());
			
			System.out.println(message);
			
			Assert.assertEquals(message, actualMessage);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	
	// Scenario Outline: Validating SignUp With Existing Account Mobile Number and Email ID

	@Given("Enter the First Name {string}")
	public void enter_the_first_name(String firstName) {
		
		typeText(pageObjectManager.getSignUp().getFirstName(), firstName);
	}
	
	@Given("User Enter Last Name {string}")
	public void user_enter_last_name(String lastName) {
		
		typeText(pageObjectManager.getSignUp().getLastName(), lastName);
		
		verticalScroll("400");
	}
	
	@Given("Enter The Date Of Brith {string} and {string}")
	public void enter_the_date_of_brith_and(String month, String year) {

		clickElement(pageObjectManager.getSignUp().getDateOfBrith());
		
		visibleOfElement(pageObjectManager.getSignUp().getSelectMonth());
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectMonth(), month);
		
		selectVisibleText(pageObjectManager.getSignUp().getSelectYear(), year);
		
		clickElement(pageObjectManager.getSignUp().getSelectDate());
	}
	
	@Given("User Enter Existing Account Mobile Number")
	public void user_enter_existing_account_mobile_number() {
		
		typeText(pageObjectManager.getSignUp().getMobileNumber(), property.getValue(PropertyKey.validMobileNumber.name()));
		
//		clickElement(pageObjectManager.getSignUp().getMailID());
		
		clickElement(pageObjectManager.getSignUp().getImage());
		
		elementNotVisible(pageObjectManager.getSignUp().getLoading());
	}
	
	@Then("Validate Existing Mobile Number Error Message {string}")
	public void validate_existing_mobile_number_error_message(String errorMessage) {
		
		try {
			
			String existingNumberErrorMessage = getElementText(pageObjectManager.getSignUp().getExistingMobileNumberErrorMessage());
			
			Assert.assertEquals(existingNumberErrorMessage, errorMessage);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Then("User Must Enter Existing Account Email ID")
	public void user_must_enter_existing_account_email_id() {
		
		typeText(pageObjectManager.getSignUp().getMailID(), property.getValue(PropertyKey.mailID.name()));
		
		clickElement(pageObjectManager.getSignUp().getPassword());
		
		clickElement(pageObjectManager.getSignUp().getImage());
		
		elementNotVisible(pageObjectManager.getSignUp().getLoading());
	}
	
	@Then("Validate Existing Email ID Error Message {string}")
	public void validate_existing_email_id_error_message(String errorMessage) {
		
		try {
			
			String existingMailErrorMessage = getElementText(pageObjectManager.getSignUp().getExistingEmailIDErrorMessage());
			
			Assert.assertEquals(existingMailErrorMessage, errorMessage);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Then("User Enter Password On The Password Field {string}")
	public void user_enter_password_on_the_password_field(String password) {
		
		typeText(pageObjectManager.getSignUp().getPassword(), password);
	}
	
	@Then("User Eneter Confirm Passowrd {string}")
	public void user_eneter_confirm_passowrd(String password) {
		
		typeText(pageObjectManager.getSignUp().getConPassword(), password);
	}
	
	@Then("User Should Click The CheckBox I agree")
	public void user_should_click_the_check_box_i_agree() {
		
		clickElement(pageObjectManager.getSignUp().getAgreeCheckBox());
	}
	
	@Then("User Must Click Submit button")
	public void user_must_click_submit_button() {
		
		clickElement(pageObjectManager.getSignUp().getSubmitBtn());
	}
}
