Feature: Admin can manage the hotels entries
As a admin
I want to see the admin Dashboard
So that I an able to manage the hotel entries

@createEntriess @smoke
  Scenario Outline: create entry
    Given admin logged into the admin panel
    When admin creates <noOfHotels> hotel
    Then admin should see <noOfHotels> entries created successfully
    Examples:
      | noOfHotels |
      | 1          |
      | 2          |

@deleteEntry @smoke
  Scenario:delete entry
   Given admin logged into the admin panel
   And admin creates <noOfHotels> hotel
   And admin should see <noOfHotels> entries created successfully
   When I delete an entry
   Then an entry should be deleted successfully


