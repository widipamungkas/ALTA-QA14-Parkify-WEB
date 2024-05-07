@LoginUsr
  Feature: login parkify as user
    As a user I want to login parkify successfully

    Scenario: Login Parkify with valid credential
      Given User open the app parkify
      When User input "altaproject@gmail.com" as username and "altaproject" as password and click login
      Then User already on dashboard page


    @TC2
    Scenario Outline: Login with invalid credential
      Given User open the app parkify
      When User input "<userName>" as username and "<password>" as password and click login
      Then User see "<errorMessage>" as error text for "<element>"
      Examples:
        | userName              | password    | errorMessage         | element  |
        |                       | altaproject | Email is required    | Email    |
        | altaproject@gmail.com |             | Password is required | Password |






