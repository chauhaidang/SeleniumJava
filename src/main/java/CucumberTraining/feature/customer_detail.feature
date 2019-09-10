Feature: customer detail
  This feature is to test all customer detail functionality
  As a user
  I can navigate to customer detail page and I can interact with my account number
  as well as I can see my all information

  Scenario: Verify that user can see the account information
    Given user navigate to bank app
    And user navigate to home page
    When user go to customer login
    And user select username Harry Potter
    And user click login
    And user select account number
      | accountNumber |
      | 1004          |
      | 1005          |
      | 1006          |
    Then user should see account number info display
      | label            | accountNumberInfo |
      | Account Number : | 1004              |
      | Account Number : | 1005              |
      | Account Number : | 1006              |