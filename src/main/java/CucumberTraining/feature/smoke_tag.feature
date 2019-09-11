@smoke
Feature: this feature will be run for smoke test

  Scenario: verify user can login successfully as a customer
    Given user navigate to bank app
    And user navigate to home page
    When user go to customer login
    Then user should see username title display correctly
    And user should see username dropdown display with default info
    When user select username Harry Potter
    And user click login
    Then user should see correct welcome status on customer detail page

  Scenario: verify user can login successfully as a bank manager
    Given user navigate to bank app
    And user navigate to home page
    When user go to manager login
    Then user should see 3 tabs to manage customers
    