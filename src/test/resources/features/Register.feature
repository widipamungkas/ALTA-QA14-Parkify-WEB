@Register
Feature: Register successfully as  User or Operator
  I can register as user or operator with valid credential

@TCRE-1
Scenario Outline: Register with valid credential
  Given User open the web parkify
  When User click sign up button
  Then User redirected to register page
  Then User choose "<accountType>"
  And User input "<fullName>" as full name "<email>" as email and "<password>" as password and click sign up
  And User will see success message "selamat data sudah terdaftar"
  Examples:
    | accountType | fullName | email | password |
  |             |          |       |          |
  |             |          |       |          |

