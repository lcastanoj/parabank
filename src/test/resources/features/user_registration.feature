Feature: User Registration
  As a new user
  I want to create an account in Parabank
  So that I can authenticate and perform banking operations

@Registrer
  Scenario: Successful user registration
    Given the user is on the registration page
    When the user registers with valid data
    Then the user should see the message "Your account was created successfully. You are now logged in."
