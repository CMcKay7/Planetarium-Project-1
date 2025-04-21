Feature: User Registration

  Background:
    Given   the user is on the login page
    When    the user accesses the register link

  Scenario: Valid credentials should allow for Planetarium registration
    When    the user provides username "Diana" while registering
    And     the user provides password "D1ana" while registering
    Then    an alert should appear saying "Account created successfully"
    And     the user should be redirected to the login page

  Scenario Outline: Invalid credentials should not allow for Planetarium registration
    When    the user provides username "<username>" while registering
    And     the user provides password "<password>" while registering
    Then    an alert should appear saying "<message>"
    And     the user should remain on the register page

  Examples:
    |username|password|message|
    |Batman  |D1ana   |Invalid username    |
    |Todd    |D1ana   |Invalid username    |
    |Diana!%?|D1ana   |Invalid username    |
    |0liver  |D1ana   |Invalid username    |
    |thisoverthirtycharacterssssssss     |D1ana   |Invalid username    |
    |Diana   |T0dd    |Invalid password    |
    |Diana   |diana   |Invalid password    |
    |Diana   |Diana   |Invalid password    |
    |Diana   |d1ana   |Invalid password    |
    |Diana   |D1ANA   |Invalid password    |
    |Diana   |D1ana!? |Invalid password    |
    |Diana   |0liver  |Invalid password    |
    |Diana   |Thisoverthirtycharactersssssss3  |Invalid password    |