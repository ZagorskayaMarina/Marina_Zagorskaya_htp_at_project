Feature: Testing adding to favorite

Scenario: Add 2 Hotels to the favorites, check color of the heart button
          Given I go4 to site 'https://booking.com/'
          Then I login
          Then I get4 data to search from JSON file '0' element in array
          Then I save first hotel and get color of heart
          Then I go to last page
          Then I save last hotel
          Then I go to user page
          And I check quantity of hotels and color of heart
