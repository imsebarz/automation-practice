@regression
Feature: Register Existing User
  As a visitor trying to register with an existing email
  I want to see an appropriate error message
  So that I understand the email is already in use

  Scenario: Attempt to register with existing email
    Given User navigates to the home page
    When User attempts to register with existing email
      | name         | email                     |
      | ExistingUser | existing_user@example.com |
    Then A signup error message is displayed
    And User remains on the signup page
