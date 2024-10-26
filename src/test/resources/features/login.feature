@login
Feature: Users should be able to login

  Background: User is already in the log in page
    Given the user is on the login page


Scenario: Verify login with different user types
  Given the user logged in as "hr"
    #Given the user logged in with username as "hr" and password as "UserUser123"
  Then User can see options below
    | MESSAGE |
    | TASK    |
    | EVENT   |
    | POLL    |
    | MORE    |

  @wip
  Scenario: Verify login with different user types
    Given the user logged in as "hr"
    #Given the user logged in with username as "hr" and password as "UserUser123"
    Then User can see options below
      | MESSAGE |
      | TASK    |
      | EVENT   |
      | POLL    |
      | MORE    |
    Then User sees options below option under MORE
      | File         |
      | Appreciation |
      | Announcement |
      | Workflow     |
