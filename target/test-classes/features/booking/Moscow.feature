Feature: Testing trip to Mosсow with Actions

Scenario: I find hotel in Mosсow in min price category
          Given I go to site 'https://booking.com/'
          Then I get data to search from JSON file '2' element in array
          And I select hotel in  price category '1'
          And I select '1' hotel
          And I compare price Moscow