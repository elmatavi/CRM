@wip
Feature: Users should be able to access Employees Page

  Background:
    Given the user is on the login page


  Scenario Outline: Verify the module visibility on the Employees page
    Given the user logged in as "<userType>"
    When the user navigates to the Employees page
    Then the following modules should be visible
      | Company Structure   |
      | Find Employee       |
      | Telephone Directory |
      | Staff Changes       |
      | Efficiency Report   |
      | Honored Employees   |
      | Birthdays           |
      | New page            |
    Examples:
      | userType  |
      | help desk |
      | hr        |
      | marketing |



