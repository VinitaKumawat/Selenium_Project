Feature: Add product to cart

  Scenario: Add Product Samsung Galaxy S6 to the cart
    Given I am on the demoblaze homepage
    When I click on the product
    And I click on the add to cart
    Then I should see an alert popup with the message "Product added"