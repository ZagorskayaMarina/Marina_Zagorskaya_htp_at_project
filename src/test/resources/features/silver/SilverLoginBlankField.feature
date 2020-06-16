Feature: Cinema

  Scenario Outline: Login app blank field
    Given I open an app
    When I left blank <field> field
    Then I see <message> message
    Examples:
      | field               |message                               |
      | "ee1vp@yandex.by"   |"Необходимо заполнить поле \"Пароль\""|
      | "11111Aa!"          |"Необходимо заполнить поле \"E-mail\""|