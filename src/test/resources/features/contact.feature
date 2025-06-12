Feature: Contact Form Functionality

  Scenario: User submits a message through the contact form
    Given I am on the Demoblaze homepage
    When I click on the Contact option
    And I enter "test@example.com" in the contact email field
    And I enter "vinita_kumawat" in the contact name field
    And I enter "This is a test message" in the message field
    And I click on the Send message button
    Then I should see an alert with the message "Thanks for the message!!"
