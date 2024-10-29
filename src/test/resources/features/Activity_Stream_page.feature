@activityFeatures
Feature: Verify that the user views the following options on the Activity Stream page.




  Scenario Outline: Verify login with different user types
    Given the user logged in as "<userType>"

  #Given the user logged in with username as "hr" and password as "UserUser123"
    Then User can see options below
      | MESSAGE |
      | TASK    |
      | EVENT   |
      | POLL    |
      | MORE    |
    Examples:
      | userType  |
      | help desk |
      | hr        |
      | marketing |



  @wip
  Scenario Outline: Verify login with different user types
    Given the user logged in as "<userType>"

    #Given the user logged in with username as "hr" and password as "UserUser123"
    Then User should click MORE
    Then User sees options below option under MORE
      | File         |
      | Appreciation |
      | Announcement |
      | Workflow     |
    Examples:
      | userType  |
      | help desk |
      | hr        |
      | marketing |