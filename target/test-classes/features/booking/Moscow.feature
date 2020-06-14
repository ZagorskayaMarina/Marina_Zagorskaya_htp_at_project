Feature: Testing trip to Mosсow with Actions

Scenario: I find2 hotel in Mosсow in min price category
          Given I go2 to site 'https://booking.com/'
          Then I get2 data to search from JSON file '2' element in array
          And I select2 hotel in  price category '1'
          And I select2 '1' hotel
          And I compare2 price Moscow