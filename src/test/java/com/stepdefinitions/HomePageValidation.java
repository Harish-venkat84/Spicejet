package com.stepdefinitions;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageValidation extends BaseUtils{
	
	@Given("User click the CheckIn field")
	public void user_click_the_check_in_field() {
		
		clickElement(pom.getHomePage().getCheckInBtn());
	}
	
	@When("User enter the PNR number or Ticket number in the input field")
	public void user_enter_the_pnr_number_or_ticket_number_in_the_input_field() {
		
		typeText(pom.getHomePage().getChickInPRNNumber(), "W3X3H8");
	}
	
	@When("User enter the email id or Last name in the input field")
	public void user_enter_the_email_id_or_last_name_in_the_input_field() {
		
		typeText(pom.getHomePage().getEmailAndLastName(), property.getValue(PropertyKey.dummyFirstName.name()));
	}
	
	@When("User click the SearchBooking button")
	public void user_click_the_search_booking_button() {
		
		clickElement(pom.getHomePage().getCheckInSearchBtn());
	}
	
	@Then("Verify the error message {string}")
	public void verify_the_error_message(String errorMessage) {
		
		visibleOfElement(pom.getHomePage().getCheckInErrorMessage());
		
		System.out.println(getElementText(pom.getHomePage().getCheckInErrorMessage()));
		
		clickElement(pom.getHomePage().getCheckInDismissBtn());
		
	}
	
	

	@Given("User click the Flight Status Field")
	public void user_click_the_flight_status_field() {
		
		clickElement(pom.getHomePage().getFlightStatusBtn());
	}
	@Given("Select the departure date from the drop down")
	public void select_the_departure_date_from_the_drop_down() {
		
		clickElement(pom.getHomePage().getStatusDepartureDate());
		
		clickElement(pom.getHomePage().getSelectTody());
	}
	@Given("User select the takeOff city")
	public void user_select_the_take_off_city() {
		
		String takeOffCity = property.getValue(PropertyKey.takeOffCity.name());
		
		typeText(pom.getHomePage().getTakeOffInputField(), takeOffCity.substring(0, 3));
		
		clickElement(pom.getHomePage().selectTakeOffCity(takeOffCity));
	}
	@Given("Select the landing city")
	public void select_the_landing_city() {
		
		String destination = property.getValue(PropertyKey.destination.name());
		
		typeText(pom.getHomePage().getLandingInputField(), destination.substring(0, 2));
		
		clickElement(pom.getHomePage().selectTakeOffCity(destination));
	}
	@Given("User click the search Flight button")
	public void user_click_the_search_flight_button() {
		
		clickElement(pom.getHomePage().getFlightStatusSearchFlightBtn());
	}
	@Then("Verify the Flight status URL {string}")
	public void verify_the_flight_status_url(String url) {
		
		try {
			Thread.sleep(2000);
			
			if (currentURL().contains(url)) {
				
				System.out.println("Flight status URL matches");
			
			}else {
				
				System.out.println("Flight status URL Not matches");
			}
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		backPage();
	}

	
	
	
	@Given("User click the Manage Booking Field")
	public void user_click_the_manage_booking_field() {
		
		visibleOfElement(pom.getHomePage().getManageBookingBtn());
		
		clickElement(pom.getHomePage().getManageBookingBtn());
	}
	
	@Given("User Enter the PNR Number or Ticket Number")
	public void user_enter_the_pnr_number_or_ticket_number() {
		
		typeText(pom.getHomePage().getChickInPRNNumber(), "W3X3H8");
	}
	
	@Given("User Enter the Email ID or Last Name")
	public void user_enter_the_email_id_or_last_name() {
		
		typeText(pom.getHomePage().getManageBookingLastName(), property.getValue(PropertyKey.dummyFirstName.name()));
	}
	
	@Given("User Click the Manage Booking Search Booking button")
	public void user_click_the_manage_booking_search_booking_button() {
		
		clickElement(pom.getHomePage().getCheckInSearchBtn());
		
	}
	
	@Then("Verify the Manage Booking Error Message {string}")
	public void verify_the_manage_booking_error_message(String errorMessage) {
		
		visibleOfElement(pom.getHomePage().getCheckInErrorMessage());
		
		System.out.println(getElementText(pom.getHomePage().getCheckInErrorMessage()));
		
		clickElement(pom.getHomePage().getCheckInDismissBtn());
		
	}
}
