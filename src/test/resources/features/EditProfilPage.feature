@EditProfile

  Feature: Edit Profile User
    As a user I want to edit my profile account

    Background: Already login
      Given User open the app parkify
      When User input "altaproject@gmail.com" as username and "altaproject" as password and click login
      Then User already on dashboard page
    Scenario: Edit Profile

      And User click profile icon
      And User click edit icon
      And User input "widi el" as username
      And User click save changes button
      And User will see "<successMessage>" as username changed
      And User will redirected to profile page
      And User click refresh to see the changes
      Then User will see the new name account "Name"

