Feature: Internal Funds Transfer
  Users should be able to move funds between accounts

  @needsUser
  Scenario: Transfer funds between accounts
    Given the user has at least two active accounts
    And the user is on the transfer page
    When the user transfers 150 dollars from the first account to the second account
    Then the transfer confirmation should be displayed
