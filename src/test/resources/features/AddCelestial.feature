Feature: Add Planet/Moon

  Background:
    Given   the user is on the home page

  @needsLogin
  Scenario: Valid planet creation should update table
    When    the user selects the Planet option
    And     the user provides planet name "Krypton" for creation
    And     the user presses the Submit Planet button
    And     the user should remain on the home page

  @needsLogin
  Scenario: Valid moon creation should update table
    When    the user selects the Moon option
    And     the user provides moon name "Tamaran" for creation
    And     the user provides id "1" for creation
    And     the user presses the Submit Moon button
    And     the user should remain on the home page

  @needsLogin
  Scenario Outline: Invalid planet credentials should not update table
    When    the user selects the Planet option
    And     the user provides planet name "<planet name>" for creation
    And     the user provides an image "<image>"
    And     the user presses the Submit Planet button
    Then    an alert should appear saying "<pmessage>"
    And     the user should remain on the home page

  Examples:
    |planet name|image|pmessage|
    |Earth      |C:\\Users\\cjmck\\OneDrive\\Pictures\\Populated_Planet.png  |Invalid planet name|
    |           |C:\\Users\\cjmck\\OneDrive\\Pictures\\Populated_Planet.png  |Invalid planet name|
    |Krypton$$!?|C:\\Users\\cjmck\\OneDrive\\Pictures\\Populated_Planet.png  |Invalid planet name|
    |thisoverthirtycharacterssssssss|C:\\Users\\cjmck\\OneDrive\\Pictures\\Populated_Planet.png |Invalid planet name|
    |Krypton    |C:\\Users\\cjmck\\Downloads\\krypton.pdf|Invalid file type|

  @needsLogin
  Scenario Outline: Invalid moon credentials should not update table
    When    the user provides moon name "<moon name>" for creation
    And     the user provides id "<id>" for creation
    And     the user presses the Submit Moon button
    Then    an alert should appear saying "<mmessage>"
    And     the user should remain on the home page

  Examples:
    |moon name|id|mmessage|
    |Titan    |1 |Invalid moon name|
    |         |1 |Invalid moon name|
    |Metro? P0!-s         |1 |Invalid moon name|
    |Thisoverthirtycharactersssssss3         |1 |Invalid moon name|
    |Tamaran  |16|Invalid planet ID|
