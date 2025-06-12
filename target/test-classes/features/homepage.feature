#Feature: Homepage functionality verification

  #Scenario: Verify homepage functionality
   # Given I launch the browser and navigate to the login page
   # When I click the homepage navigation link
   # And I click the homepage cursor
   # Then all functionality should work properly
Feature: Homepage functionality verification

  Scenario: Verify homepage navigation links
    Given I launch the browser and navigate to the homepage
    When I click on the "Home" link
    And I click on the "Contact" link
    Then All navigation links should work properly
    Then the page title should be "STORE"
    
  Scenario: Verify category selection
    Given I launch the browser and navigate to the homepage
    When I select the "Phones" category
    And I select the "Laptops" category
    And I select the "Monitors" category
    Then Categories should be displayed properly

  Scenario: Verify homepage carousel functionality
    Given I launch the browser and navigate to the homepage
    When I click the carousel next button
    And I click the carousel previous button
    Then Carousel should work properly
   