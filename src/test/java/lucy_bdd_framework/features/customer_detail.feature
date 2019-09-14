@Functional @CUS-01
Feature: Customer Detail
  This feature is to test all customer detail functionality

  @CUSACC-001
  Scenario: Verify that user can view account info after select an account number
    Given user navigate to bank app "http://www.way2automation.com/angularjs-protractor/banking/#/login"
    And user navigate to home page
    When user go to customer login
    And user select username Harry Potter
    And user click login
    And user select account number as
      | account number |
      | 1004           |
      | 1005           |
      | 1006           |
    Then user should see account number info display as "1004"
    