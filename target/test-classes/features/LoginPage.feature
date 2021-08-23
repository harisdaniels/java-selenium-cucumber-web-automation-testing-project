Feature: Login page feature admin-demo.nopcommerce.com

  Scenario: Successful Login with Valid Credentials
    Given User opens URL "https://admin-demo.nopcommerce.com/login"
    When User enters Email as "admin@yourstore.com" and Password as "admin"
    And Clicks on Login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page title should be "Your store. Login"

  Scenario Outline: Successful Login with Valid Credentials Data Driven Testing
    Given User opens URL "https://admin-demo.nopcommerce.com/login"
    When User enters Email as "<email>" and Password as "<password>"
    And Clicks on Login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page title should be "Your store. Login"

    Examples: 
      | email                | password |
      | admin@yourstore.com  | admin    |
