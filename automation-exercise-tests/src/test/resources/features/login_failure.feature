@regression
Feature: Login Failure
  As a visitor to the automation exercise website
  I want to see appropriate error messages when I use invalid credentials
  So that I understand why my login attempt failed

  Scenario: Login with invalid credentials
    Given User navigates to the home page
    When User attempts to log in with invalid credentials
      | email               | password        |
      | invalid@example.com | wrongpassword   |
    Then A login error message is displayed
    And User remains on the login page
