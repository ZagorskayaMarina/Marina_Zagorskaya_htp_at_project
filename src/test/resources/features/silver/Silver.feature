Feature: Cinema

  Scenario: Search movie
    Given I open an app
    When I search for 'автокинотеатр' word
    And Each item name or description contains 'автокинотеатр' word