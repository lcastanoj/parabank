Feature: Transaction Search
  Users should be able to search for specific transactions

  @needsUser
  Scenario: Search transactions by amount
    Given the user is authenticated
    And the user is on the transactions search page
    When the user searches for transactions with amount "150"
    Then at least one matching transaction should be displayed
