Feature: Validating One way and Round Trip Functionality

  @OneWayTrip
  Scenario: Validating One way
    Given User select the city where is he or she going to take off the flight
    When User Select destination city from destination drop down
    And User select departure date from the calendar picker
    And Select number of passengers from the passengers drop down
    And User Select the currency from the currency drop down
    And User click the search flight button
    Then Validate the booking cities and Validate the number of passenger

  @RoundTrip
  Scenario: Valiadating Round Trip
    Given user select the Round Trip Radio button
    When User select the city take off city
    And user select landing city
    And Select the departure date
    And Select the return date
    And Select number of passengers from the drop down
    And User click the Search Flight button
    Then Validate flight listed page title "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets"
