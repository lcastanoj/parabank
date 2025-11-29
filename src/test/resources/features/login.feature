Feature: User Login
  To access the banking options
  A registered user must be able to authenticate successfully

@Login @needsUser
  Scenario: Successful login
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the user should see the welcome message
