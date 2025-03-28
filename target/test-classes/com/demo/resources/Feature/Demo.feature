@CreateProfile
Feature: User Profile Creation

  Scenario Outline: Create user profile with different data combinations
    Given User launches "<browser>" browser
    When User opens URL "<url>"
    And User clicks on the Add user button
    And User enters profile details:
  | Field       | Value        |
  | First Name  | <first_name> |
  | Last Name   | <last_name>  |
  | User Name   | <username>   |
  | Password    | <password>   |
  | Email       | <email>      |
  | Cell Phone  | <phone>      |
    And User selects "<company>" as company
    And User selects "<role>" as role
    And Click the save button
    And Validate the entered data appears correctly in the table
    Then The page title should be "<expected_title>"
    And Close browser

    Examples:
      | browser | url                                                           | first_name | last_name | username  | password | company      | role       | email              | phone      | expected_title                          |
      | chrome  | http://www.way2automation.com/angularjs-protractor/webtables/ | John       | Doe       | johndoe   | Test123! | Company AAA  | Customer   | john.doe@test.com  | 1234567890 | Protractor practice website - WebTables |
      | chrome  | http://www.way2automation.com/angularjs-protractor/webtables/ | Jane       | Smith     | janesmith | Secure1! | Company BBB  | Admin      | jane.smith@test.com | 9876543210 | Protractor practice website - WebTables |