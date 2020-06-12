Feature: Testing trip to Paris

Scenario: I find hotel in Paris in max price category with min price
          Given I go to 'https://booking.com/'
          Then I get data to search from JSON file '1' element in array
          And I select hotel in '5' price category
          And I find price of '1' hotel
          And I compare hotel's category price with price of hotel
