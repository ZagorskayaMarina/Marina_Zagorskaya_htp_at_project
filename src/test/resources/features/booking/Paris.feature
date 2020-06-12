Feature: Testing trip to Paris

Scenario: I find hotel in Paris in max price category with min price
          Given I go to site 'https://booking.com/'
          Then I get data to search from JSON file '1' element in array
          And I select hotel in  price category '5'
          And I sort hotels by price from min to max
          And I select '1' hotel
          And I compare hotel's category price with price of hotel
