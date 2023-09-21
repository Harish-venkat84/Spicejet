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

	@loginWith_ValidMailID_InvalidPassword
  Scenario: Login with Valid Mail ID and Invalid Password
    Given click login button in the Homepage
    And user must click the Email Radio button
    And user enter the valid email id
    And user must enter the invalid password "42980@passw"
    And user must click the login button
    Then Verifying the error message "Invalid Username/Password" and "Please try again or signup as a new user"

  @loginWith_InvalidMailID_ValidPassword
  Scenario: Login with Invalid Mail ID and valid Password
    Given User click login button in the Homepage
    And user Should click the Email Radio button
    And user enter the Invalid email id "test.com"
    And user must enter the valid password
    And user Should click the login button
    Then Verifying the error message "Please enter a valid email address"
    