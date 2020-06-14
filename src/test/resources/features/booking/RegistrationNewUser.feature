Feature: Registration new user in booking

Scenario: Create trash email and register new User on booking
          Given I go6 to site 'https://trashmail.com/'
          Then I create new trash mail
          Then I confirm new account
          And I go7 to site 'https://booking.com/'
          Then I create booking account
          And I check that user is not active