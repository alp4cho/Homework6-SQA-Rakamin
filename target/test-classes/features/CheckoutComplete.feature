Feature: Checkout Process

  Scenario: Success Checkout Product
    Given Login With Valid Credentials
    When Add Some Product to Cart With Click Add to cart Button
    And Click Cart Button in the top right corner
    And Click Checkout Button
    And Input Checkout Information
    And Click Continue Button
    And in Checkout overview Page Click Finish Button
    Then User get info Thank for your order

