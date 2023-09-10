Feature: SignUp Functionality

  @SignUp
  Scenario Outline: Validating SignUp Functionality
    Given User Must Click The SignUp button
    And Switch To SignUp Tab
    Then Validate SignUp Page Title
    And User Select The Title From The Title Dropdown
    And User Enter the First Name <firstName>
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
