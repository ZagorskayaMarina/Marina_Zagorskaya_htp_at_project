Feature: Testing trip to Mosсow with Actions

Scenario: I find hotel in Mosсow in min price category
          Given I go to booking.com
          Then I get data to search from JSON file
          And I select hotel in min price category
          And I find first hotel in list
          And I compare hotel's category price with price of hotel