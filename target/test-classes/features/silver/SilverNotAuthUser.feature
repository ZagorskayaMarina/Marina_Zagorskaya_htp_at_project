Feature: Cinema

  Scenario: Login app no such user
    Given I open an app
    When I login with 'yy1vp@yandex.by' and '11111Aa!'
    Then I see 'Пользователь не найден' message
