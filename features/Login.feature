Feature: Validating Longin Functionality

  @loginValidCredentials
  Scenario: Longin with Valid Credentials
    Given User must click Login button on the HomePage
    And User Click the login with Email Radio button
    And User enter the email address on the email field
    And User enter the password on th password fields
    And user click the Login button
    Then verify the Login successfully "Hi Harish"

  @loginInvaildCredentials
  Scenario: Login with Invalid Credentials
    Given user click login button in the Homepage
    And user click the email radio button
    And user enter the invalid email id "harishtest@test.com"
    And user enter the invalid password "42980@passw"
    And user click the login button
    Then verify the error message "Invalid Username/Password" and "Please try again or signup as a new user"
