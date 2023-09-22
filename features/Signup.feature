Feature: SignUp Functionality

  Background: Validating Navigate to SignUp Page
    # These steps are present under the Signup_With_ValidCredentials class
    Given User Must Click The SignUp button
    And Switch To SignUp Tab
    Then Validate SignUp Page Title
    And User Select The Title From The Title Dropdown

  @SignUpValidCredentials
  Scenario: Validating SignUp With Valid Credentials
    When User Enter the First Name
    And Enter the Last Name
    And User Must Select Country From The Country Dropdown
    And User Select The Date Of Brith
    And User Enter The Mobile Number
    And User Must Enter Email ID
    And User Must Enter Password On The Password Field
    And User Must Eneter Confirm Passowrd
    And User Click The CheckBox I agree
    And User Click Submit button
    Then Validate OTP Verification popup Feild Shown to User "OTP Verification"

  @SignUp_With_Existing_MobileNumber_EmailID
  Scenario Outline: Validating SignUp With Existing Account Mobile Number and Email ID
    Given Enter the First Name <firstName>
    And User Enter Last Name <lastName>
    And Enter The Date Of Brith <month> and <year>
    And User Enter Existing Account Mobile Number
    Then Validate Existing Mobile Number Error Message "Member account exists with given mobile number"
    And User Must Enter Existing Account Email ID
    Then Validate Existing Email ID Error Message "Member account exists with given email ID"
    And User Enter Password On The Password Field <password>
    And User Eneter Confirm Passowrd <password>
    And User Should Click The CheckBox I agree
    And User Must Click Submit button

    Examples: 
      | firstName | lastName | month | year   | password       |
      | "Harish"  | "V"      | "May" | "1999" | "Harish@vent8" |

  @signup_Without_Entering_Credentials
  Scenario: Validating without Entering any Credentials Clicking Sibmit button
    # These two steps added in the Signup_With_Existing_MobileNumber_EmailID class
    Given User just Click the Submit button
    Then Validate the fill all mandatory fields message shown to user "Please fill all mandatory fields marked with an '*' to proceed"
