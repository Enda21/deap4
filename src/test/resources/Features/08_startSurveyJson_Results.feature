Feature: Feature to test Adding a Survey functionality

  Scenario Outline: Results Data
    Given MPCDER details
    When read test data from Json file ""
    Then Result details Page
      | Results | TotalDwellingArea | LivingRoomArea | LivingRoom | TotalElementArea | TotalHeatLoss | AdjustedInfiltrationRate | Mainspaceheatingsystem |
      | Results | TotalDwellingArea | LivingRoomArea | LivingRoom | TotalElementArea | TotalHeatLoss | AdjustedInfiltrationRate | Mainspaceheatingsystem |
    Then user selects My Portal
