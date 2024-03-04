Feature: Feature to test Adding a Survey functionality

  Scenario Outline: Add Ventilation Data
    Given user Enters Ventilation section
    When read test data from Json file ""
    Then Configure INFILTRATION DUE TO OPENINGS in Ventilation details Page
      | AddVentilationCommonItem | LibraryItem | MarketingName | Number | SurveyBGenerals                           | DraughtLobby |
      | SurveyData.SurveyItems   | LibraryItem | MarketingName | Number | SurveyData.SurveyBuilding.SurveyBGenerals | DraughtLobby |
    Then Configure STRUCTURAL AIR TIGHTNESS details Page
      | SurveyVentilations | AirPermeabilityResult |
