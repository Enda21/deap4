Feature: Feature to test Adding a Survey functionality
    Scenario Outline: Add Lighting Data
        Given user Enters Lighting section
        When read test data from Json file ""
        Then Lighting details Page
            | IsLightingDesignKnown                           | SurveyItems            | LibraryItem | LibraryItemTypeID | MarketingName | Number | LibraryItemSourceID | Manufacturer | Model | LibraryItemBulb | Efficiency | Power |
            | SurveyData.SurveyLighting.IsLightingDesignKnown | SurveyData.SurveyItems | LibraryItem | LibraryItemTypeID | MarketingName | Number | LibraryItemSourceID | Manufacturer | Model | LibraryItemBulb | Efficiency | Power |

