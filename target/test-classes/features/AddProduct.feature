Feature: Add Product

  Scenario: Success Add Product to cart
    Given Login App With Valid Credentials
    When The user has successfully logged in and is on the dashboard page
    And Add Some Product to Cart With Click Add to cart
    And Click Cart Button in the top right corner to next process
    Then the user successfully added the product and is on the cart page