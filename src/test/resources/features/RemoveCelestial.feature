Feature: Remove Planet/Moon

  Background:
    Given   the user is on the home page

  Scenario: Valid planet removal should update table
    When    the user selects the Planet option
    And     the user provides planet name "Mars" for deletion
    And     the user presses the Delete button
    #Then    the table should update
    And     the user should remain on the home page

  Scenario: Valid moon removal should update table
    When    the user selects the Moon option
    And     the user provides moon name "Titan" for deletion
    And     the user presses the Delete button
    #Then    the table should update
    And     the user should remain on the home page

  Scenario Outline: Invalid planet removal should not update table
    When    the user provides planet name "<planet name>" for deletion
    And     the user presses the Delete button
    Then    an alert should appear saying "<pmessage>"
    And     the user should remain on the home page

    Examples:
      |planet name|pmessage|
      |Earth      |Invalid planet name|
      |           |Invalid planet name|
      |Krypton$$!?|Invalid planet name|
      |thisoverthirtycharacterssssssss|Invalid planet name|

  Scenario Outline: Invalid moon removal should not update table
    When    the user provides moon name "<moon name>" for deletion
    And     the user presses the Delete button
    Then    an alert should appear saying "<mmessage>"
    And     the user should remain on the home page

    Examples:
      |moon name|mmessage|
      |Titan    |Invalid moon name|
      |         |Invalid moon name|
      |Metro? P0!-s         |Invalid moon name|
      |Thisoverthirtycharactersssssss3         |Invalid moon name|
      |Tamaran  |Invalid planet id|