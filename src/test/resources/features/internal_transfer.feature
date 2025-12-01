Feature: Internal Funds Transfer
  Users should be able to move funds between accounts

  @needsUser @InternalTransfer @Regresion
  Scenario Outline: Transfer funds between accounts
    Given the user is authenticated
    Given the user has at least two active accounts "<typeAccount>"
    When the user transfers "<amount>" dollars from the first account to the second account
    Then the transfer confirmation should be displayed
    Examples:
      | typeAccount | amount |
      | CHECKING    | 150    |