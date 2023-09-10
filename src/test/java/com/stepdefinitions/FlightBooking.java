package com.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightBooking extends BaseUtils{
	
	@Given("Sort the flight price low to high")
	public void sort_the_flight_price_low_to_high() {

		waitForElementClickable(pom.getFlightPage().getContinueBtn());
		
		clickElement(pom.getFlightPage().getSortPrice());
		
		verticalScroll("200");
	}
	
	@Given("Select the Lowest price flight")
	public void select_the_lowest_price_flight() {

//		waitForElementClickable(pom.getFlightPage().getSingleLowestPrice());
//		clickElement(pom.getFlightPage().getSingleLowestPrice());
//		
//		waitForElementClickable(pom.getFlightPage().getContinueBtn());
	}
	
	@Given("User Click the Continue button")
	public void user_click_the_continue_button() {
		
		clickElement(pom.getFlightPage().getContinueBtn());
	}

	@Then("Verify the page landed on the passenger infomation {string}")
	public void verify_the_page_landed_on_the_passenger_infomation(String text) {
		
		try { 
			
			Assert.assertEquals(getElementText(pom.getPassengerPage().getVerifyPassengerPage()), text);
			Assert.assertEquals(currentURL(), property.getValue(PropertyKey.passengerPageUrl.name()));

		}catch(Exception e) {
			System.out.println("problem on passenger page Asserting the URL and text");
			e.printStackTrace();
		}
	}

	@Then("Enter the passenger First name and Last name and also Mobile number")
	public void enter_the_passenger_first_name_and_last_name_and_also_mobile_number() {
		
		clerTextUsingJavaScript(pom.getPassengerPage().getFirstName());
		typeText(pom.getPassengerPage().getFirstName(), property.getValue(PropertyKey.dummyFirstName.name()));
		
		clerTextUsingJavaScript(pom.getPassengerPage().getLastName());
		typeText(pom.getPassengerPage().getLastName(), property.getValue(PropertyKey.dummyLastName.name()));
		
		clerTextUsingJavaScript(pom.getPassengerPage().getMobileNumber());
		typeText(pom.getPassengerPage().getMobileNumber(), property.getValue(PropertyKey.dummyNumber.name()));
		
		clerTextUsingJavaScript(pom.getPassengerPage().getEmail());
		typeText(pom.getPassengerPage().getEmail(), property.getValue(PropertyKey.mailID.name()));
		
		List<WebElement> inputFields = pom.getPassengerPage().inputFields("1");
		
		typeText(inputFields.get(0), property.getValue(PropertyKey.dummyFirstName.name()));
		typeText(inputFields.get(1), property.getValue(PropertyKey.dummyLastName.name()));
		typeText(inputFields.get(2), property.getValue(PropertyKey.dummyNumber.name()));
		
	}
	
	@Then("Click continue button")
	public void click_continue_button() {
		
		clickElement(pom.getPassengerPage().getContinueBtn());
		
//		elementNotVisible(pom.getPassengerPage().getApp_load());
		
		waitForElementClickable(pom.getAddOnPage().getContinueBtn());
	}
	
	@Then("Verify the AddOn Url")
	public void verify_the_add_on_url() {
		
		try {
			Assert.assertEquals(currentURL(), property.getValue(PropertyKey.AddonURL.name()));
			
		}catch(Exception e) {
			
			System.out.println("problem on AddOn page getting Current URL");
			e.printStackTrace();
		}
	}
	
	@Then("USer click continue button")
	public void u_ser_click_continue_button() {
		
		verticalScroll("300");
		
		clickElement(pom.getAddOnPage().getContinueBtn());
		
		clickElement(pom.getAddOnPage().getClickSkip());
		
		clickElement(pom.getAddOnPage().getContinueBtn());
		
		elementNotVisible(pom.getAddOnPage().getApp_load());
	}
	
	@Then("Validate the Payment URL")
	public void validate_the_payment_url() {
		
		try { Assert.assertEquals(currentURL(), property.getValue(PropertyKey.paymentURL.name())); }catch(Exception ex) {
			
			System.out.println("problem on getting payment URL");
			ex.printStackTrace();
		}
		
		
	}
	
	@When("User enter the card number on the input field")
	public void user_enter_the_card_number_on_the_input_field() {
		
		visibleOfElement(pom.getPaymentPage().getCardNumberFrame());
		
		switchToFrame(pom.getPaymentPage().getCardNumberFrame());
		typeText(pom.getPaymentPage().getCardNumber(), property.getValue(PropertyKey.cardNumber.name()));
		switchToDefaultContent();
	}
	
	@When("User type the card holder name in input field")
	public void user_type_the_card_holder_name_in_input_field() {
		
		switchToFrame(pom.getPaymentPage().getCardNameFrame());
		typeText(pom.getPaymentPage().getCardName(), property.getValue(PropertyKey.dummyFirstName.name()));
		switchToDefaultContent();
	}
	
	@When("User enter expiry month in the input field")
	public void user_enter_expiry_month_in_the_input_field() {
		
		switchToFrame(pom.getPaymentPage().getCardMonthFrame());
		typeText(pom.getPaymentPage().getCardExMonth(), property.getValue(PropertyKey.cardMonth.name()));
		switchToDefaultContent();
	}

	@When("enter the expiry year in the year input field")
	public void enter_the_expiry_year_in_the_year_input_field() {
		
		switchToFrame(pom.getPaymentPage().getCardYearFrame());
		typeText(pom.getPaymentPage().getCardExYear(), property.getValue(PropertyKey.cardYear.name()));
		switchToDefaultContent();
	}
	
	@When("User type the card CVV in the input field")
	public void user_type_the_card_cvv_in_the_input_field() {
		
		switchToFrame(pom.getPaymentPage().getCardCVVFrame());
		typeText(pom.getPaymentPage().getCardCVV(), property.getValue(PropertyKey.cardCVV.name()));
		switchToDefaultContent();
	}
	
	@When("click proceed to pay button")
	public void click_proceed_to_pay_button() {
		
		clickElement(pom.getPaymentPage().getProceedToPayBtn());
	}
	@Then("validate payment message")
	public void validate_payment_message() {
		
		try {
			
//			waitTextPresent(pom.getPaymentPage().getErrorMessage(), property.getValue(PropertyKey.errorMessageOnPayment.name()));

			String text = getElementText(pom.getPaymentPage().getErrorMessage());
			
			Assert.assertEquals(text, property.getValue(PropertyKey.errorMessageOnPayment.name()));
			
			clickElement(pom.getPaymentPage().getErrorDismissBtn());
			
			String message = getElementText(pom.getPaymentPage().getPaymentMessage());
			
			if (message.equals("Payment Failure")) {
				
				System.out.println("payment Fail");
				
			}else {
				
				System.out.println("Payment successful");
			}
			
		}catch(Exception ex) {
			
			System.out.println();
		}
	}
}
