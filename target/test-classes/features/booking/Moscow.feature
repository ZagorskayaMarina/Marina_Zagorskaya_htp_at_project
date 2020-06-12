Feature: Testing trip to Mosсow with Actions

Scenario: I find hotel in Mosсow in min price category
          Given I go to 'https://booking.com/'
          Then I get data to search from JSON file '2' element in array
          And I select '1' price category
          And I select '1' hotel in list
          And I compare hotel's category price with price of hotel