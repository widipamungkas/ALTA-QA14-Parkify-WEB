@Location
  Feature: add and edit parking location
    As operator user can add and edit parking location

  Background: User already login as operator
    Given User open the web parkify
    When User input "OperatorParkify1@gmail.com" as email and "passwordop1" as password and click login
    Then User already on dashboard page

  @TCAPL-1
  Scenario: Add parking location with valid data
    When User click plus icon
    Then User redirected to Add Parking Location page
    And User input "Mall Basura" as location name and "Jakarta" as city
    And User upload image and click confirm button
    Then User redirected to profile page
    And User will see "Adding Parking Success" as pop up message

  @TCAPL-2
  Scenario Outline: Add parking location with invalid data
    When User click plus icon
    Then User redirected to Add Parking Location page
    And User input "<location>" as location name and "<city>" as city
    And User upload image and click confirm button
    And User upload invalid image and click Confirm button
    Then User see "<errorMessage>" as error message
    Examples:
      | location    | city    | errorMessage              |
      |             | Jakarta | Location name is required |
      | Mall Basura |         | Location is required      |
      | %%%%%       | $$$$    | Location name is invalid  |

  @TCAPL-3
  Scenario: Add parking location without picture
    When User click plus icon
    Then User redirected to Add Parking Location page
    And User input "<location>" as location name and "<city>" as city
    And User click Confirm button
    Then User see "Cover image is required" as error message

  @TCEPL-1
  Scenario: Edit parking location with valid data
    When User click profile button
    Then User redirected to profile page
    And User click Manage My Parking
    Then User redirected to Add Parking Slot page
    And User click the image
    Then User redirected to Edit Parking Location page
    And User input "Basura mall" as location name and "Jakarta Timur" as city
    And User upload edit image and click confirm button
    Then User redirected to profile page
    And User will see "Update Profile Success" as pop up message

  @TCEPL-2
  Scenario: Edit parking location with invalid data
    When User click profile button
    Then User redirected to profile page
    And User click Manage My Parking
    Then User redirected to Add Parking Slot page
    And User click the image
    Then User redirected to Edit Parking Location page
    And User input "%%%%%" as location name and "$$$$" as city
    And User upload edit image and click confirm button
    Then User see "Location name is invalid" as error message


