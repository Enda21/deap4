Feature: Feature to test Adding a Survey functionality

  Scenario Outline: Add Building Data
    Given user enters Building details
    When user selects new  Lib Iteam Doort
      | Doors                  | LibraryItem | LibraryItemTypeID | MarketingName | Manufacturer | Model | LibraryItemDoor | DoorArea | UValue | DraughtStripped |
      | SurveyData.SurveyItems | LibraryItem | LibraryItemTypeID | MarketingName | Manufacturer | Model | LibraryItemDoor | DoorArea | UValue | DraughtStripped |
    And user enters floor details
      | No of storeys                             | Storys                                  | Living area                               |
      | SurveyData.SurveyBuilding.SurveyBGenerals | SurveyData.SurveyBuilding.SurveyStoreys | SurveyData.SurveyBuilding.SurveyBGenerals |
    And user adds floor details
      | No of storeys                             | FloorLocationID                         | FloorTypeDescription                    | AgeBandDescription                      | Description                             | Area                                    | UValue                                  | ExposedPerimeter                        | UnderFloorHeating                       |
      | SurveyData.SurveyBuilding.SurveyBGenerals | SurveyData.SurveyBuilding.SurveyBFloors | SurveyData.SurveyBuilding.SurveyBFloors | SurveyData.SurveyBuilding.SurveyBFloors | SurveyData.SurveyBuilding.SurveyBFloors | SurveyData.SurveyBuilding.SurveyBFloors | SurveyData.SurveyBuilding.SurveyBFloors | SurveyData.SurveyBuilding.SurveyBFloors | SurveyData.SurveyBuilding.SurveyBFloors |
    And clicks add roof details
      | Roof                                   | RoofType            | Description | AgeBand            | Area | UValue | Insulation |
      | SurveyData.SurveyBuilding.SurveyBRoofs | RoofTypeDescription | Description | AgeBandDescription | Area | UValue | Insulation |
    Then clicks add WallS details
      | Wall                                   | WallType   | AgeBandID | Description | Area | SemiExposed | UValue |
      | SurveyData.SurveyBuilding.SurveyBWalls | WallTypeID | AgeBandID | Description | Area | SemiExposed | UValue |
    Then user selects new  Lib Iteam Rooms
      | Rooms                  | LibraryItem |
      | SurveyData.SurveyItems | LibraryItem |
    Then user selects new  Lib Iteam Windows
      | Windows                | LibraryItem | LibraryItemTypeID | MarketingName | Keywords         | Manufacturer | Model | Glazing           | Openings | Draught                 | Type          | FrameType     | Gap   | FrameFactor      | Uvalue | SolarEnergy              | Blinds  | OverhangType | OverhangDepthRatio | RoofWindow |
      | SurveyData.SurveyItems | LibraryItem | LibraryItemTypeID | MarketingName | AssessorKeywords | Manufacturer | Model | LibraryItemWindow | Openings | DraughtStrippedOpenings | GlazingTypeID | FrameFactorID | GapID | FrameFactorValue | UValue | SolarEnergyTransmittance | BlindID | OverhangID   | OverhangDepthID    | RoofWindow |
    Then clicks Global Factors add Global Factors details
      | SurveyBGenerals                           | ThermalMassCategoryID | ThermalBridgingFactorID | ThermalBridgingFactor |
      | SurveyData.SurveyBuilding.SurveyBGenerals | ThermalMassCategoryID | ThermalBridgingFactorID | ThermalBridgingFactor |
