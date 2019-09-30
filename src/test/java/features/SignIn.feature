Feature: Authentication
  As a consumer
  I want to sign in
  So that I can buy on store

  Scenario: User successfully sign in the Philips Store
    Given I am on the Login page
    When I fill valid email and password
    And I submit
    Then I should be redirected to My Account page

  Scenario: User try sign in without password
    Given I am on the Login page
    When I fill valid email
    And I submit
    Then I should not be authorized
    And I should see "Password is required." error

  Scenario: User try sign in without email
    Given I am on the Login page
    When I fill valid password
    And I submit
    Then I should not be authorized
    And I should see "An email address required." error

  Scenario Outline: User try sign in with invalid email
    Given I am on the Login page
    When I fill email with "<email>"
    And I submit
    Then I should not be authorized
    And I should see "Invalid email address." error
    Examples:
      | email       |
      | teste       |
      | teste@teste |
      | @teste.com  |
      | teste@      |

  Scenario: User fill wrong password
    Given I am on the Login page
    When I fill valid email
    And I fill wrong password
    And I submit
    Then I should not be authorized
    And I should see "Authentication failed." error
