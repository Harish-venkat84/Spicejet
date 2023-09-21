Feature: SignUp Functionality

  Background: Validating Navigate to SignUp Page
    Given User Must Click The SignUp button
    And Switch To SignUp Tab
    Then Validate SignUp Page Title
    And User Select The Title From The Title Dropdown

  @SignUpValidCredentials
  Scenario Outline: Validating SignUp With Valid Credentials
    Given User Enter the First Name <firstName>
    And Last Name <lastName>
    And User Must Select Country <country> From The Country Dropdown
    And User Enter The Date Of Brith <month> and <year>
    And User Enter The Mobile Number <mobileNumber>
    And User Must Enter Email ID <mailID>
    And User Must Enter Password On The Password Field <password>
    And User Must Eneter Confirm Passowrd <password>
    And User Click The CheckBox I agree
    And User Click Submit button

    Examples: 
      | firstName | lastName | country  | month | year   | mobileNumber | mailID                  | password       |
      | "Harish"  | "V"      | "India " | "May" | "1999" | "8807889564" | "harishvenkat@test.com" | "Harish@vent8" |

  @SignUp_With_Existing_MobileNumber_EmailID
  Scenario Outline: Validating SignUp With Existing Account Mobile Number and Email ID
    Given Enter the First Name <firstName>
    And User Enter Last Name <lastName>
    And User Select Country <country> From The Country Dropdown
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
      | firstName | lastName | country  | month | year   | password       |
      | "Harish"  | "V"      | "India " | "May" | "1999" | "Harish@vent8" |
