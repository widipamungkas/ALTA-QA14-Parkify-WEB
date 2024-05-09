@Login
  Feature: Login as Operator and User
    I can log in with valid credential

  @TCLO-1
  Scenario Outline: login with valid credential
    Given User open the web parkify
    When User input "<email>" as email and "<password>" as password and click login
    Then User already on dashboard page
    Examples:
      | email                      | password    |
      | UserParkify1@gmail.com     | passwordus1 |
      | OperatorParkify1@gmail.com | passwordop1 |

  @TCLO-2
  Scenario Outline: login with invalid credential
    Given User open the web parkify
    When User input "<email>" as email and "<password>" as password and click login
    Then User see "<errorMessage>" as error message
    Examples:
      | email                      | password    | errorMessage         |
      | OperatorParkify1@gmail     | passwordop1 | Not a valid email    |
      |                            | passwordop1 | Email is required    |
      | OperatorParkify1@gmail.com |             | Password is required |

  @TCLO-3
  Scenario Outline: login as user with operator credential
    Given User open the web parkify
    When User input "<email>" as email and "<password>" as password and click login
    Then User see "mohon cek kembali email atau password yang diinputkan" as error pop up
    Examples:
      | email                      | password    |
      | UserParkify1@gmail.com     | passwordop1 |
      | OperatorParkify1@gmail.com | passwordus1 |

  @TCLO-4
  Scenario Outline: login as operator with user credential
    Given User open the web parkify
    When User input "<email>" as email and "<password>" as password and click login
    Then User see "mohon cek kembali email atau password yang diinputkan" as error pop up
    Examples:
      | email                      | password    |
      | OperatorParkify1@gmail.com | passwordus1 |
      | UserParkify1@gmail.com     | passwordop1 |


