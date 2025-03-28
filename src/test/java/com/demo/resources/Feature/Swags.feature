@SearchForItem
Feature: User Searches For Item

  Scenario Outline: Purchase From Swag Labs
    Given User launches chrome browser
    When User opens url "https://www.saucedemo.com/"
    Then User enters Username
    And User enters password
    Then User Clicks on Login
    And User validates navigation is correct "Swag Labs"
    And User locates an item 
    And User adds item to Creat
    And Close browser



 Examples:
      | browser | url                                                           |
      | chrome  | http://www.way2automation.com/angularjs-protractor/webtables/ |