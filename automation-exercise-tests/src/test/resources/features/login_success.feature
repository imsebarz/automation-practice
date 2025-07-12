@regression
Feature: Login Success
  As a registered user of the automation exercise website
  I want to be able to log in with valid credentials
  So that I can access my account

  Scenario: Login with valid credentials
    Given User navigates to the home page
    When User logs in with valid credentials
      | email                      | password      |
      | existing_user@example.com  | S3curePwd_2025 |
    Then "Logged in as" label displays the username "ExistingUser"
    And User is successfully logged in
