Feature:User verifies options on My Profile page
   Agile story: As a user I should be able to access My Profile page

  @profilePage
  Scenario: My Profile option verification
    Given the user logged in as "help desk"
    Then user clicks on the username
    And user clicks on the My Profile dropdown
    And user should see the following options
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |

    @wip
    Scenario: User verifies email under the General tab
      Given the user logged in as "help desk"
      Then user clicks on the username
      And user clicks on the My Profile dropdown
      Then user should see the email under the General tab
