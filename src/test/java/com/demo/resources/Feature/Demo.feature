Feature: CreateProfile

  @CreateProfile
  Scenario: User Create a profile on the Protractor practice website
    Given User Launch Chrome Browser
    When User opens URL "http://www.way2automation.com/angularjs-protractor/webtables/"
    And The page title should be "Protractor practice website - WebTables"
    Then User clicks on the Add user button
    And User enters a First Name
    And User enters a Last Name
    And User enters a User Name
    And User enters a Password
    And Click the Company type
    Then Selects a Role
    And User enters an Email Address
    And User enters a Cell Phone Number
    And Click the save button
    And Validate the data is saved
    Then Close Browser