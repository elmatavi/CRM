
Feature: Sending Appreciation under Active Stream
  As a user,
  I should be able to send appreciation by  clicking on Appreciation tab in the Activity Stream

  Background:
    Given the user is on the login page

  ### Positive Scenarios ###

  Scenario Outline: User successfully sends appreciation after filling in all mandatory fields
    Given the user logged in as "<userType>"
    When the user is on the appreciation form page under Active Stream
    And the user fills in Message content with a valid text "<message>"
    And the user adds at least one recipient "<recipientEmail>"
    And the user clicks Send button
    Then the appreciation message should be posted in the Activity Stream

    Examples:
      | userType  | message                  | recipientEmail      |
      | hr        | Thank you for everything | helpdesk5@cydeo.com |
      | help desk | Thank you for everything | helpdesk5@cydeo.com |
      | marketing | Thank you for everything | helpdesk5@cydeo.com |


  Scenario Outline: Delivery option is set to 'All employees' by default
    Given the user logged in as "<userType>"
    When the user is on the appreciation form page under Active Stream
    Then the default delivery To should be "All employees"

    Examples:
      | userType  |
      | hr        |
      | help desk |
      | marketing |


  Scenario Outline: User cancels sending appreciation and form is reset
    Given the user logged in as "<userType>"
    And the user is on the appreciation form page under Active Stream
    When the user fills in Message content with a valid text "Thank you for your hard work!"
    And the user adds at least one recipient "helpdesk5@cydeo.com"
    And the user clicks the Cancel button
    And the user navigates back to the appreciation form
    Then the form fields should be cleared

    Examples:
      | userType    |
      | hr          |
      | help desk   |
      | marketing   |



     ### Negative Scenarios ###

  Scenario Outline: Error message is displayed when Message content is not filled in
    Given the user logged in as "<userType>"
    When the user is on the appreciation form page under Active Stream
    And the user adds at least one recipient "helpdesk5@cydeo.com"
    And the user clicks Send button
    Then an error message "The message title is not specified." should be displayed
    Examples:
      | userType  |
      | hr        |
      | help desk |
      | marketing |



  Scenario Outline: Error message is displayed when no recipient is specified
    Given the user logged in as "<userType>"
    And the user is on the appreciation form page under Active Stream
    And the user fills in Message content with a valid text "Great job!"
    And the user removes the recipient
    When the user clicks Send button
    Then a warning "Please specify at least one person." should be shown

    Examples:
      | userType  |
      | hr        |
      | help desk |
      | marketing |