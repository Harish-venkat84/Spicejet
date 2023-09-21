package com.stepdefinitions;

import org.testng.Assert;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OneWayTrip extends BaseUtils{
	
	// Scenario: Validating without Entering any details Clicking Search Flight
	
	@Given("User click the Search Filght button")
	public void user_click_the_search_filght_button() {
		
		clickElement(pageObjectManager.getHomePage().getSearchFlightBtn());
	}
	
	@Then("Validate Popup Message {string}")
	public void validate_popup_message(String actualMessage) {
		
		try {

			String popupMessage = getElementText(pageObjectManager.getHomePage().getDestinationEmptyPopupMessage());
			
			Assert.assertEquals(popupMessage, actualMessage);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	// Scenario: Validating One way with Valid Credentials

	@Given("User select the city where is he or she going to take off the flight")
	public void user_select_the_city_where_is_he_or_she_going_to_take_off_the_flight() {
		
		String takeOffCity = property.getValue(PropertyKey.takeOffCity.name());
		
		typeText(pageObjectManager.getHomePage().getTakeOffInputField(), takeOffCity.substring(0, 3));
		
		clickElement(pageObjectManager.getHomePage().selectTakeOffCity(takeOffCity));
	}
	
	@When("User Select destination city from destination drop down")
	public void user_select_destination_city_from_destination_drop_down() {
		
		String destination = property.getValue(PropertyKey.destination.name());
		
		typeText(pageObjectManager.getHomePage().getLandingInputField(), destination.substring(0, 2));
		
		clickElement(pageObjectManager.getHomePage().selectTakeOffCity(destination));
		
	}
	
	@When("User select departure date from the calendar picker")
	public void user_select_departure_date_from_the_calendar_picker() {
		
		setDate();
		
		clickElement(pageObjectManager.getHomePage().selectThisMonthCalendarDate(month, year, day));
	}
	
	@When("Select number of passengers from the passengers drop down")
	public void select_number_of_passengers_from_the_passengers_drop_down() {
		
		clickElement(pageObjectManager.getHomePage().getPassengersDropDowm());
		
		clickElement(pageObjectManager.getHomePage().getAdultPlus());
		clickElement(pageObjectManager.getHomePage().getAdultPlus());

		clickElement(pageObjectManager.getHomePage().getAdultMinus());
		clickElement(pageObjectManager.getHomePage().getAdultMinus());
		
		clickElement(pageObjectManager.getHomePage().getChildPlus());
		clickElement(pageObjectManager.getHomePage().getChildPlus());
		
		clickElement(pageObjectManager.getHomePage().getChildMinus());
		clickElement(pageObjectManager.getHomePage().getChildMinus());
		
	}
	
	@When("User Select the currency from the currency drop down")
	public void user_select_the_currency_from_the_currency_drop_down() {
		
		clickElement(pageObjectManager.getHomePage().getCurrencyDropDown());
		clickElement(pageObjectManager.getHomePage().getSelectUSD());
		
		clickElement(pageObjectManager.getHomePage().getCurrencyDropDown());
		clickElement(pageObjectManager.getHomePage().getSelectINR());
	}
	
	@When("User click the search flight button")
	public void user_click_the_search_flight_button() {
		
		clickElement(pageObjectManager.getHomePage().getSearchFlightBtn());
	}
	
	@Then("Validate the booking cities and Validate the number of passenger")
	public void validate_the_booking_cities_and_validate_the_number_of_passenger() {

		try {
			String oneWay = getElementText(pageObjectManager.getFlightPage().getValidateOnewWay());
			String passenger = getElementText(pageObjectManager.getFlightPage().getValidatePassenger());
			
			String takeOffCity = property.getValue(PropertyKey.takeOffCity.name());
			String destination = property.getValue(PropertyKey.destination.name());
			
			Assert.assertEquals(oneWay, "One Way : "+takeOffCity+" to "+destination);
			Assert.assertEquals(passenger, "Passengers :  1 Adult ");
			
		}catch(Exception e) {
			
			System.out.println("problem on validating on oneWay cities and passenger on OneWayTrip Class");
			e.printStackTrace();
		}
	}
}
