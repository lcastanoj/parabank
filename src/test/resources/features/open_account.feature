Feature: Open New Account
  In order to increase my financial products
  I want to open a new checking or savings account

  @needsUser @OpenAccount @Regresion
  Scenario Outline: Open a new checking account
    Given the user is authenticated
    When the user opens a new "<type>" account
    Then the new account should be displayed in the accounts overview
    Examples:
      | type     |
      | CHECKING |
      | SAVINGS  |
