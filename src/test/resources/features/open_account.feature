Feature: Open New Account
  In order to increase my financial products
  I want to open a new checking or savings account

  @needsUser
  Scenario: Open a new checking account
    Given the user is authenticated
    When the user opens a new "CHECKING" account
    Then the new account should be displayed in the accounts overview
