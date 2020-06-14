Feature: Check header elements

Scenario: Log in and check that all header elements exist
          Given I go5 to site 'https://booking.com/'
          Then I login3
          And I check displaying all header elements