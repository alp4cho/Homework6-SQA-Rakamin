Feature: Logout User App saucedemo

   #Positive case
  Scenario: Success Logout and back to Login page
    Given Login With Valid Credentials User
    When The User in on The Dashboard Page
    And Click Sidebar menu in top left corner
    And Click Logout Button
    Then User back on login page