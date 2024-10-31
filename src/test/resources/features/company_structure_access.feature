@wip
Feature: Access to Company Structure Functions in the Employee Menu
  As a user,
  I should be able to use functions on Company Structure under Employee menu

  Background:
    Given the user is on the login page



  Scenario Outline: Company Structure is visible to all user types
    Given the user logged in as "<userType>"
    When user navigate to the Company Structure section under the Employee menu
    Then the "Company Structure" is should be visible
    Examples:
      | userType  |
      | hr        |
      | help desk |
      | marketing |


  Scenario:  user adds a new department
    Given the user logged in as "hr"
    When user navigate to the Company Structure section under the Employee menu
    And user click the ADD DEPARTMENT button
    Then the "Add department" window is displayed



  Scenario Outline: "ADD DEPARTMENT" button is hidden for non-HR users
    Given the user logged in as "<userType>"
    When user navigate to the Company Structure section under the Employee menu
    Then the ADD DEPARTMENT button should not be displayed
    Examples:
      | userType  |
      | help desk |
      | marketing |


