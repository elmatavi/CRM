@wip
Feature: Verify that user can see the following modules on the Company page shown as design.

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario Outline:
    Given User is logged in as "<userType>"
    When User click to Company LinkPage
    Then User should see all the modules listed on the top menu of the page
      | Official Information |
      | Our Life             |
      | About Company        |
      | Photo Gallery        |
      | Video                |
      | Career               |
      | Business News (RSS)  |
      | More                 |


    Examples:
      | userType  |
      | hr        |
      | help desk |
      | marketing |