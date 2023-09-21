package com.stepdefinitions;

import org.testng.Assert;

import com.spicejet.property.PropertyKey;
import com.spicejet.utils.BaseUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RoundTrip extends BaseUtils{

	@Given("user select the Round Trip Radio button")
	public void user_select_the_round_trip_radio_button() {
		
		clickElement(pageObjectManager.getHomePage().getRoundTrip());
	}
	@When("User select the city take off city")
	public void user_select_the_city_take_off_city() {
	
		String takeOffCity = property.getValue(PropertyKey.takeOffCity.name());
		
		typeText(pageObjectManager.getHomePage().getTakeOffInputField(), takeOffCity.substring(0, 3));
		
		clickElement(pageObjectManager.getHomePage().selectTakeOffCity(takeOffCity));
	}
	@When("user select landing city")
	public void user_select_landing_city() {
	
		String destination = property.getValue(PropertyKey.destination.name());
		
		typeText(pageObjectManager.getHomePage().getLandingInputField(), destination.substring(0, 2));
		
		clickElement(pageObjectManager.getHomePage().selectTakeOffCity(destination));
	}
	@When("Select the departure date")
	public void select_the_departure_date() {
	
		setDate();
		
		clickElement(pageObjectManager.getHomePage().selectThisMonthCalendarDate(month, year, day));
	}
	@When("Select the return date")
	public void select_the_return_date() {
		
		String date = String.valueOf(Integer.parseInt(day)+2);
		
		clickElement(pageObjectManager.getHomePage().selectThisMonthCalendarDate(month, year, date));
	
	}
	@When("Select number of passengers from the drop down")
	public void select_number_of_passengers_from_the_drop_down() {
		
		clickElement(pageObjectManager.getHomePage().getPassengersDropDowm());
		
		clickElement(pageObjectManager.getHomePage().getAdultPlus());
		clickElement(pageObjectManager.getHomePage().getAdultPlus());

		clickElement(pageObjectManager.getHomePage().getAdultMinus());
		
		clickElement(pageObjectManager.getHomePage().getChildPlus());
		clickElement(pageObjectManager.getHomePage().getChildPlus());
		
		clickElement(pageObjectManager.getHomePage().getChildMinus());
	
	}
	@When("User click the Search Flight button")
	public void user_click_the_search_flight_button() {
	
		clickElement(pageObjectManager.getHomePage().getSearchFlightBtn());
	}
	
	@Then("Validate flight listed page title {string}")
	public void validate_flight_listed_page_title(String title) {
		
		try { Assert.assertEquals(getPageTitel(), title); }catch(Exception e) {
			
			System.out.println("Problem on getting titile on flight listed page, OneWayTrip class");
			
			e.printStackTrace();
		}
		
	}
}
