@homepage
Feature: Spiceject Home Page Validation

  @CheckIn
  Scenario: Validating CheckIn Functionality
    Given User click the CheckIn field
    When User enter the PNR number or Ticket number in the input field
    And User enter the email id or Last name in the input field
    And User click the SearchBooking button
    Then Verify the error message "Unable to fetch your booking. Please check the inputs you have provided and try again."

	@FlightStatus
  Scenario: Validating Flight Status Functionality
  	Given User click the Flight Status Field
    And Select the departure date from the drop down
    And User select the takeOff city
    And Select the landing city
    And User click the search Flight button
    Then Verify the Flight status URL "https://www.spicejet.com/flight-status"

	@ManageBooking
  Scenario: Validating Manage Booking Functionality
    Given User click the Manage Booking Field
    And User Enter the PNR Number or Ticket Number
    And User Enter the Email ID or Last Name
    And User Click the Manage Booking Search Booking button
    Then Verify the Manage Booking Error Message "Unable to fetch your booking. Please check the inputs you have provided and try again."
