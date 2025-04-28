Feature: Remove Planet/Moon

  Background:
    Given   the user is on the home page

  @needsLogin
  Scenario: Valid planet removal should update table
    When    the user selects the Planet option
    And     the user provides planet name "Mars" for deletion
    And     the user presses the Delete button
    And     the user should remain on the home page

  @needsLogin
  Scenario: Valid moon removal should update table
    When    the user selects the Moon option
    And     the user provides moon name "Titan" for deletion
    And     the user presses the Delete button
    And     the user should remain on the home page

  @needsLogin
  Scenario Outline: Invalid planet removal should not update table
    When    the user selects the Planet option
    And     the user provides planet name "<planet name>" for deletion
    And     the user presses the Delete button
    Then    an alert should appear saying "<planet message>"
    And     the user should remain on the home page

    Examples:
      |planet name|planet message|
      |Mars       |Invalid planet name|
      |           |Invalid planet name|
      |Krypton$$!?|Invalid planet name|
      |thisoverthirtycharacterssssssss|Invalid planet name|

  @needsLogin
  Scenario Outline: Invalid moon removal should not update table
    When    the user selects the Moon option
    And     the user provides moon name "<moon name>" for deletion
    And     the user presses the Delete button
    Then    an alert should appear saying "<moon message>"
    And     the user should remain on the home page

    Examples:
      |moon name|moon message|
      |Titan    |Invalid moon name|
      |         |Invalid moon name|
      |Metro? P0!-s         |Invalid moon name|
      |Thisoverthirtycharactersssssss3         |Invalid moon name|
      |Tamaran  |Invalid moon name|