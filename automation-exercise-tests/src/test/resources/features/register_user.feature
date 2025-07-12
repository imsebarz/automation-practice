@regression
Feature: Register User
  As a visitor to the automation exercise website
  I want to be able to register a new user account
  So that I can access the platform's features

  Scenario: Register new user with valid information
    Given User navigates to the home page
    When User signs up with fresh random credentials
    Then "ACCOUNT CREATED!" banner is visible
    And User continues to the home page
    And "Logged in as" label displays the username
    When User deletes the account
    Then "ACCOUNT DELETED!" banner is visible
