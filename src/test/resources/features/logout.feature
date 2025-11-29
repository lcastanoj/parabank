Feature: Logout
  Authenticated users should be able to log out securely

  @needsUser
  Scenario: Successful logout
    Given the user is authenticated
    When the user logs out
    Then the login page should be displayed
