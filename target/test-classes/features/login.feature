Feature: Login functionality on Demoblaze

  Scenario: Successful login with valid credentials
    Given I open the Demoblaze website
    When I click on the login button
    And I enter username "vinita_kumawat" and password "vinita1234"
    And I click the login submit button
    Then I should see a successful login message

  Scenario: Unsuccessful login with invalid credentials
    Given I open the Demoblaze website
    When I click on the login button
    And I enter username "invaliduser" and password "wrongpass"
    And I click the login submit button
    Then I should see an error message
