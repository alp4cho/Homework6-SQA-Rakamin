Feature: Login Page Aplikasi saucedemo

  #Positive case
  Scenario: Success Login With Valid Username and Password
    Given saucedemo Login Page
    When Input Username
    And Input Password
    And Click Login Button
    Then User in on Dashboard page

  #Negative case
  Scenario: Failed Login With Valid Username and Invalid Password
    Given saucedemo Login Page
    When Input Username
    And Input Invalid Password
    And Click Login Button
    Then User get error message