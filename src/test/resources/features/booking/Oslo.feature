Feature: Testing trip to Oslo with change colors actions

Scenario: I find a hotel in Oslo with 3 and 4 stars, scroll to 10th hotel and change colors of elements
          Given I go3 to site 'https://booking.com/'
          Then I get3 data to search from JSON file '3' element in array
          And I select hotels with stars 3 and 4
          Then I scroll to 10 hotel
          Then I focus mouse to hotel address
          Then I change the background color to green
          Then I change the text color to red
          And I verify the text color
