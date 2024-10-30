
Feature: Users should be able to access Employees Page

  Background:
    Given the user is on the login page

@wip
  Scenario: Verify the default view and module visibility on the Employees page
    When the user navigates to the Employees page
    Then the following modules should be visible
             | Company Structure      |
             | Find Employee          |
             | Telephone Directory     |
             | Staff Changes           |
             | Efficiency Report       |
             | Honored Employees       |
             | Birthdays               |
             | New page                |
           And the "Company Structure" module should be displayed by default
