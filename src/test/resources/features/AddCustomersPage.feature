Feature: Customers page feature admin-demo.nopcommerce.com

  Scenario Outline: Successful Add New Customer
    Given User opens URL "https://admin-demo.nopcommerce.com/login"
    When User enters Email as "<email>" and Password as "<password>"
    And Clicks on Login button
    Then User can view the Dashboard
    When User clicks on Customers Menu
    And Clicks on Customers Menu Item
    And Clicks on Add New button
    Then User can view Add New Customer Page
    When User enters customer info
    And Clicks on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    When User clicks on Logout link
    Then Page title should be "Your store. Login"

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
