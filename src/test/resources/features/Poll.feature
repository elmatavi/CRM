Feature: Poll function

  User Story : As a user, I should be able to create a poll by clicking on Poll tab under Active Stream.

  Background:
    Given the user is on the login page


  Scenario Outline: The delivery should be to 'All employees' by default.
    Given the user logged in as "<userType>"
    When user is on the poll page under  Activity stream page
    Then user sees to "All employees" by default

    Examples:
      | userType  |
      | hr        |
      | help desk |
      | marketing |


  Scenario Outline:User should be able to create a poll by adding questions and multiple answers.
    Given the user logged in as "<userType>"
    When user is on the poll page under  Activity stream page
    Then the user create  "<new poll>"
    When the user adds a question to the poll"<Question>"
    Then the user adds multiple answers "<first>" and "<second>"


    Examples:
      | userType  | Question                     | first  | second |
      | hr        | What is your favorite color? | Black  | White  |
      | help desk | What is your favorite food?  | Rice   | Meat   |
      | marketing | What is your favorite drink? | Coffee | Tea    |

  Scenario Outline:User should be able to select “Allow multiple choice” checkbox..
    Given the user logged in as "<userType>"
    When user is on the poll page under  Activity stream page
    Then the user create  "<new poll>"
    When the user adds a question to the poll"<Question>"
    Then the user adds multiple answers "<first>" and "<second>"
    And the user selects Allow multiple choice checkbox

    Examples:
      | userType  | Question  | first  | second |
      | hr        | Question1 | Black  | White  |
      | help desk | Question2 | Rice   | Meat   |
      | marketing | Question3 | Coffee | Tea    |


  Scenario Outline: Error message is displayed when message body is empty
    Given the user logged in as "<userType>"
    When user is on the poll page under  Activity stream page
    Then the user click send
    Then the error message "The message title is not specified" should be displayed
    Examples:
      | userType  |
      | hr        |
      | help desk |
      | marketing |

  Scenario Outline: Error message is displayed when recipient  is not selected
    Given the user logged in as "<userType>"
    When user is on the poll page under  Activity stream page
    Then the user create  "<new poll>"
    And the user remove all employess default
    Then the user click send
    Then the recipient error message "Please specify at least one person." should be displayed
    Examples:
      | userType  |
      | hr        |
      | help desk |
      | marketing |

  @wip
  Scenario Outline:Error message is displayed when the question filed is empty
    Given the user logged in as "<userType>"
    When user is on the poll page under  Activity stream page
    Then the user create  "<new poll>"
    Then the user adds  answers "<first>"
    Then the user click send
    Then the user sees error message is "The question text is not specified." should be displayed
    Examples:
      | userType  | first  |
      | hr        | Tea    |
      | help desk | Coffee |
      | marketing | Juice  |

    Scenario Outline: Error message is "The question has .... no answer"
      Given the user logged in as "<userType>"
      When user is on the poll page under  Activity stream page
      Then the user create  "<new poll>"
      Then the user adds  "<question>"
      Then the user click send
      Then the user sees error message is "The question ""<question>"" has no answers."
      Examples:
        | userType  | question  |
        | hr        | Question1 |
        | help desk | Question2 |
        | marketing | Question3 |















