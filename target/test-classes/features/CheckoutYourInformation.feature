Feature: Fill in data on the checkout your information page

  #Positive case
  @Positive
  Scenario: Success go to Overview Page after Fill data in checkout your information page
    Given Login With Valid Credentials user and password
    When Add Some Product to Cart With Click Add to cart Button in every product
    And Click Cart in the top right corner
    And Click Checkout Button to next process
    And Input First Name
    And Input Last Name
    And Input Postal Code
    And Click Continue Button to next process
    Then User in on Checkout Overview Page

  #Negative Case
  @Negative
  Scenario: failed to go to the overview page after did not fill in the data completely
    Given Login With Valid Credentials user and password
    When Add Some Product to Cart With Click Add to cart Button in every product
    And Click Cart in the top right corner
    And Click Checkout Button to next process
    And Input First Name
    And Input Last Name
    And Do Not Input Postal Code
    And Click Continue Button to next process
    Then User get error message postal code is required
