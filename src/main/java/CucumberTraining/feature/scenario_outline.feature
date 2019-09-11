Feature: Learn scenario outline

  Scenario Outline: verify user can login successfully with multiple customer
    Given user navigate to bank app
    And user navigate to home page
    When user go to customer login
    Then user should see username title display correctly
    And user should see username dropdown display with default info
    When user select username <username>
    And user click login
    Then user should see correct welcome status on customer detail page
    Examples:
      | username     |
      | Harry Potter |
      | Ron Weasly   |
