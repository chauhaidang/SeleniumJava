Feature: Login
  This feature is to test all login functionality of user story
  As a user
  I want to login successfully

  Scenario: verify user can login successfully as a customer
    Given user navigate to bank app
    And user navigate to home page
    When user go to customer login
    Then user should see username title display correctly
    And user should see username dropdown display with default info
    When user select username
    And user click login
    Then user should see correct welcome status on customer detail page
