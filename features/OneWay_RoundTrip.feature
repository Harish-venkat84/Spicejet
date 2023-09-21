Feature: Validating One way and Round Trip Functionality

	@searchFlight_Without_Entering_Details
	Scenario: Validating without Entering any details Clicking Search Flight
	# these two steps added in the OneWayTrip java Class 
	Given User click the Search Filght button
	Then Validate Popup Message "Destination city cannot be empty"

  @oneWayTripValidCredentials
  Scenario: Validating One way with Valid Credentials
    Given User select the city where is he or she going to take off the flight
    When User Select destination city from destination drop down
    And User select departure date from the calendar picker
    And Select number of passengers from the passengers drop down
    And User Select the currency from the currency drop down
    And User click the search flight button
    Then Validate the booking cities and Validate the number of passenger

  @roundTripValidCredentials
  Scenario: Valiadating Round Trip with Valid Credentials
    Given user select the Round Trip Radio button
    When User select the city take off city
    And user select landing city
    And Select the departure date
    And Select the return date
    And Select number of passengers from the drop down
    And User click the Search Flight button
    Then Validate flight listed page title "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets"
