@Regression @AUTH-01
Feature: Login
  This feature is to test all login functionality of user story
  As a user
  I want to login successfully

  @AUTHCUS-001
  Scenario: verify user can login successfully as a customer
    Given user navigate to bank app "http://www.way2automation.com/angularjs-protractor/banking/#/login"
    And user navigate to home page
    When user go to customer login
    Then user should see username title display as "Your Name :"
    And user should see username dropdown display as "---Your Name---"
    When user select username Harry Potter
    Then user should see username dropdown display as "Harry Potter"
    When user click login
    Then user should see correct welcome status as "Welcome Harry Potter !!" on customer detail page

  @AUTHMA-001
  Scenario: verify user can login successfully as a bank manager
    Given user navigate to bank app "http://www.way2automation.com/angularjs-protractor/banking/#/login"
    And user navigate to home page
    When user go to manager login
    Then user should see 3 tabs to manage customers