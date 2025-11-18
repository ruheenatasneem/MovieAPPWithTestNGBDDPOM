Feature: Login Functionality
  As a user of webPage application
  I want to able to login to my account
  So that i can view the webpages.

  Scenario:Successful login
    Given I am on login page
    When  I enter valid username and password
    And   I clicked on login button
    Then  Successfully redirected to Home page

  Scenario: Invalid credential login
    Given I am on login page
    When  I enter invalid username and password
    And   I clicked on login button
    Then  Displaying error message