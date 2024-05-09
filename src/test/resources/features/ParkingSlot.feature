@Slot
  Feature: Add, edit, and delete parking slot
    As operator user can add, edit, and delete parking slot

    Background: User already login as operator
      Given User open the web parkify
      When User input "OperatorParkify1@gmail.com" as email and "passwordop1" as password and click login
      Then User already on dashboard page

  @TCAPS-1
  Scenario Outline: Add parking slot with valid data
    When User click profile button
    Then User redirected to profile page
    And User click Manage My Parking
    Then User redirected to Add Parking Slot page
    Then User select vehicle type car then input <floor> as floor, <slot> as slot and <price> as price and click submit
    Then User redirected to profile page
    And User will see "success add parking slot" as pop up message
    Examples:
      | floor | slot | price |
      | 3     | 2    | 7000  |
      | 3     | 3    | 7000  |

  @TCAPS-2
  Scenario Outline: Add parking slot with invalid data
    When User click profile button
    Then User redirected to profile page
    And User click Manage My Parking
    Then User redirected to Add Parking Slot page
    Then User select vehicle type car then input <floor> as floor, <slot> as slot and <price> as price and click submit
    Then User see "<errorMessage>" as error message
    Examples:
      | floor | slot | price | errorMessage                                 |
      | 99    | 1    | 7000  | Currently available floors are limited       |
      | 2     | 99   | 7000  | Currently available parking slot are limited |
      | 0     | 1    | 7000  | Floor cannot be empty                        |
      | 3     | 0    | 7000  | Slot cannot be empty                         |
      | 3     | 2    | 0     | You need to fill the price                   |


