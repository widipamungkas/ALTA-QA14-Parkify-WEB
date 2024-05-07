@BookingParkingPlace

  Feature:
  As a User I want to book car parking place successfully
  Background: Already login
    Given User open the app parkify
    When User input "altaproject@gmail.com" as username and "altaproject" as password and click login
    Then User already on dashboard page

  Scenario: Booking parking place

  And User go to menu find parking place
  And User click tunjungan plaza mall
  Then User will redirected to booking parking page
  And User click button car
  And User choose second floor "2nd Floor"
  And User choose slot one "Slot 1"
#  And User will see the parking information at the picking card
#  And User click button booking now
#  And User will see success message
#  Then User will see booking information
