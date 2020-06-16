Feature: Cinema

  Scenario: Login app
    Given I open an app
    When I login with 'ee1vp@yandex.by' and '11111Aa!'
    Then I can see Red Carpet Club '//div[contains(@style, 'animation')]' in upper right corner