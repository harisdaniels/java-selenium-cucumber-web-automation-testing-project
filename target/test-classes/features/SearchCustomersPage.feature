Feature: Customers page feature admin-demo.nopcommerce.com

  Background: Steps for Searching Customers
    Given User opens URL "https://admin-demo.nopcommerce.com/login"
    When User enters Email as "admin@yourstore.com" and Password as "admin"
    And Clicks on Login button
    Then User can view the Dashboard
    When User clicks on Customers Menu
    And Clicks on Customers Menu Item

  Scenario: Search Customer by Email
    When User enters Customer Email
    And User clicks on Search button
    Then User should found Email in the Search table
    When User clicks on Logout link
    Then Page title should be "Your store. Login"

  Scenario Outline: Search Customer by Name
    When User enters Customer First Name
    And User enters Customer Last Name
    And User clicks on Search button
    Then User should found their Name in the Search table
    When User clicks on Logout link
    Then Page title should be "Your store. Login"
