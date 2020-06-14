Feature: Finding users

  Scenario Outline: Finding users by username if response has 1 object
    Given I start finding by <request> predicate
    When I get a response from a web service
    And I parse result and exp result by <result> result
    Then I verify the web service response
    Examples:
      | request |result|
      | 0       |0     |
      | 1       |1     |
      | 3       |4     |

  Scenario Outline: Finding users by username if response has more then 1 object
     Given I start finding by <request> predicate
     When I get a response from a web service
     And I parse result
     Then I verify the web service response by <length>
     Examples:
     | request |length|
     | 2       |4     |
     | 4       |6     |