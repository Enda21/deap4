Feature: Feature to test Adding a Survey functionality

  Scenario Outline: Add a new Survey
    Given user is on login page
    Then user is navigated to the home page
    When read test data from Json file ""
    Then user will click the start new survay link
    When user will navigate to new survay page
    And user have to enter survey details
      | MPRN                     | Address                      | BERCurrent                     | Address1                     | Address2                     | Address3                     | County                     | Eircode                     | DwellingDescription                     | Year                     | Extended                     | RatingTypeID/Name      | RatingPurposeID/Name      | BuildingRegsID/Description     | PlanningReference        | DateOfPlans        | Description        | Comments        |
      | SurveyData.Dwelling.MPRN | SurveyData.Dwelling.Address1 | SurveyData.Dwelling.BERCurrent | SurveyData.Dwelling.Address1 | SurveyData.Dwelling.Address2 | SurveyData.Dwelling.Address3 | SurveyData.Dwelling.County | SurveyData.Dwelling.Eircode | SurveyData.Dwelling.DwellingDescription | SurveyData.Dwelling.Year | SurveyData.Dwelling.Extended | Survey.Ratingtype.Name | Survey.RatingPurpose.Name | Survey.BuildingReg.Description | Survey.PlanningReference | Survey.DateOfPlans | Survey.Description | Survey.Comments |
    Then user have to enter survey details popup
      | Type of rating         | Purpose                   | Regulation                                    | PlanningReference        | DateOfPlans        | Description        | Accessor Comments |
      | Survey.RatingType.Name | Survey.RatingPurpose.Name | Survey.BuildingReg.Description.BuildingRegsID | Survey.PlanningReference | Survey.DateOfPlans | Survey.Description | Survey.Comments   |
