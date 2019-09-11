Feature:Learn background hook in cucumber

  Background: Suppose that user was in the home page
    Given user navigate to bank app
    And user navigate to home page

  Scenario: verify user can login successfully as a customer
    Given user go to customer login
    Then user should see username title display correctly
    And user should see username dropdown display with default info
    When user select username Harry Potter
    And user click login
    Then user should see correct welcome status on customer detail page

  Scenario: verify user can login successfully as a bank manager
    Given user go to manager login
    Then user should see 3 tabs to manage customers
    