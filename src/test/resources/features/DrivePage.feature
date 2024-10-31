Feature: Access the Drive Page
  As a user, I should be able to access the Drive page


  Background:
    Given the user is on the login page

  Scenario: User can access the Drive page and see all modules
    Given the user logged in as "hr"
    When the user click the Drive button
    Then the user should see the following modules on the Drive page

      | My Drive                   |
      | All Documents              |
      | Company Drive              |
      | Sales and Marketing        |
      | Top Management's documents |
      | Drive Cleanup              |
      | More                       |












