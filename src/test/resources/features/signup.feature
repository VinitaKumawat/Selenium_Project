Feature: Sign Up Functionality

  Scenario: Verify the Sign Up process
    Given I am on the demoBlaze homepage
    When I click on the Sign Up option
    And I enter a unique username and password
    And I click on the Sign Up button
    Then an alert message should popup confirming sign-up or user existence
