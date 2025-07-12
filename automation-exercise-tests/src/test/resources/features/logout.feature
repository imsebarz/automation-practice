@regression
Feature: Logout
  As a logged-in user of the automation exercise website
  I want to be able to log out
  So that I can secure my account when done

  Scenario: Logout from valid session
    Given User navigates to the home page
    And User logs in with valid credentials
      | email                      | password      |
      | existing_user@example.com  | S3curePwd_2025 |
    When User logs out
    Then User is redirected to the login page
    And User is no longer logged in
