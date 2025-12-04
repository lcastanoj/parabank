Feature: Account Balance Validation
  To ensure transactions update account values
  Users should be able to see updated balances

  @needsUser @AccountBalance @Regresion
  Scenario Outline: Validate updated balances after transfer
    Given the user is authenticated
    And the user has recent transfer operations "<typeAccount>" "<amount>"
    When the user checks the account balances
    Then the balances should reflect the last transfer

    Examples:
      | typeAccount | amount |
      | CHECKING    | 100    |