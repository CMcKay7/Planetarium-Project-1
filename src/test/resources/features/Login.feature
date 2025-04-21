Feature: User Login

  Background:
    Given   the user is on the login page
    And     the user has a registered account

  Scenario: Valid login credentials should redirect User to the homepage
    When    the user provides username "Batman" while logging in
    And     the user provides password "Iamthenight1939" while logging in
    When    the user clicks the login button
    Then    the user should be logged in
    And     the user should be redirected to the home page

  Scenario Outline: Invalid login should not redirect User to the homepage
    When    the user provides username "<username>" while logging in
    And     the user provides password "<password>" while logging in
    When    the user clicks the login button
    Then    an alert should appear saying "<message>"
    And     the user should remain on the login page

    Examples:
      |username|password|message|
      |Batmann  |Iamthenight1939 |Invalid Credentials      |
      |Batman   |Iamthenight1930 |Invalid Credentials      |