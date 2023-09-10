Feature: Spicejet Flight Booking Functionality

  @FlightBooking
  Scenario: Validating Flight Booking Functionality
    Given Sort the flight price low to high
    And Select the Lowest price flight
    And User Click the Continue button
    Then Verify the page landed on the passenger infomation "Passenger Information"
    And Enter the passenger First name and Last name and also Mobile number
    And Click continue button
    Then Verify the AddOn Url
    And USer click continue button
    Then Validate the Payment URL
    When User enter the card number on the input field
    And User type the card holder name in input field
    And User enter expiry month in the input field
    And enter the expiry year in the year input field
    And User type the card CVV in the input field
    And click proceed to pay button
    Then validate payment message
