@loginM
Feature: User Login
   As a user, I should be able to log in to the application.

   Background:  User is already in the log in page
    Given the user is on the login page

# Acceptance Criteria 2:
#Verify that "Incorrect login or password" error message is displayed
#for invalid (valid username-invalid password and invalid username-valid password) credentials.
Scenario Outline: Display error message for invalid credentials
  When user enter invalid "<username>" and "<password>"
  And user click on Login Button
  Then user see "Incorrect login or password" error message

  Examples:
  |username|password|
  |hr1@cydeo.com|User1145|
  |hr1cydeo.com|UserUser|
  |helpdesk12@cydeo.com|UserCydeo1145|
  |helpdesk0001@cydeo.com|UserUser|
  |marketing15@cydeo.com|UserCydeo1145|
  |helpdesk0001@cydeo.com|UserUser|



# Acceptance Criteria 4:
#-Verify that the "Remember me on this computer" link exists and is clickable on the login page.

Scenario: "Remember me on this computer" link exists and is clickable
  And user see Remember me on this computer text
  When user select  Remember me on this computer checkbox
  Then checkbox should be clickable

# Acceptance Criteria 5:
#Verify that the password is in bullet signs by default.

Scenario: Password input is masked by default
  When user enter "UserUser"
  Then password field should display bullet signs by default



Scenario: CSS Injection attempt in the login field
  When user enter "<style>body{display:none;}</style>" as the username
  And user enter "UserUser" as the password
  And user click the login button
  Then user see "Incorrect login or password" error message


Scenario: Verify that the password field allow copy/paste functionality
  When user enter "hr1@cydeo.com" as the username
  And  user enter "password123" as the password
  And  user copies the password text
  And  user clear password field
  And  user pastes the copied text into the password field
  Then password field should contain "password123"



Scenario: login with leading and trailing spaces in username and password
  When user enter " hr35@cydeo.com " username and " UserUser " password
  And user click on Login Button
  Then user see "Incorrect login or password" error message


Scenario Outline: Successful login with different cases in username (case-insensitive username)
  When user enter "<case-insensitive username>" username and "<case-sensitive password>" password
  And user click on Login Button
  Then user see title "Portal"

  Examples:  Valid Credentials
  |case-insensitive username| case-sensitive password|
  |Hr35@cydeo.com|UserUser|
  |HR35@cydeo.com|UserUser|
  |Helpdesk1@cydeo.com|UserUser|
  |HeLPdesk1@cydeo.com|UserUser|
  |HELPDESK1@cydeo.com|UserUser|
  |Marketing15@cydeo.com|UserUser|
  |MARKETING15@cydeo.com|UserUser|




Scenario: Unsuccessful login due to case sensitivity in password (case-sensitive password)
  When user enter "HR35@cydeo.com" username and "userUser" password
  And user click on Login Button
  Then user see "Incorrect login or password" error message