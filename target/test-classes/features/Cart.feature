Feature: Shopping Cart Checkout
  Scenario: User adds a product to the cart and completes checkout successfully
    Given I navigate to "https://www.demoblaze.com/"
    When I select a product "Samsung galaxy s6"
    And I add the product to the cart
    And I navigate to the cart page
    And I proceed to checkout
    And I enter order details "vinita_kumawat" "Raj" "Jaipur" "1234567812345678" "12" "2025"
    And I confirm the purchase
    Then I should see a confirmation message
