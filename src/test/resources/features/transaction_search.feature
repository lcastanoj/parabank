Feature: Transaction Search
  Users should be able to search for specific transactions

  @needsUser @TransactionSearch
  Scenario Outline: Search transactions by amount
    Given the user is authenticated
    When the user opens a new "<type>" account
    And the users do a transfer "<amount>"
    When the user searches for transactions with amount "<amount>"
    Then at least one matching transaction should be displayed

    Examples:
      | type     | amount |
      | CHECKING | 100    |
