Feature: Logout

    Scenario: Verify logout after login validation
        Given user launch browser and navigate to the login page
        When user click on the Log in section
        When User enter valid username "vinita_kumawat" into username field
        And User enter valid password "vinita1234" into password field
        And User click on login button
        Then User successfully login
        Then I click on logout option