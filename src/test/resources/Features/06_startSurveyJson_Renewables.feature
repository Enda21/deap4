Feature: Feature to test Adding a Survey functionality

  Scenario Outline: Add a new Survey Renewables Data
    When read test data from Json file ""
    Then Renewable details
      | SurveyFuelData_Renewable            | RenewableTypeID | EnergyProducedOrSaved | ProducedDeliveredEnergy | PartLtotalcontribution | EnerProdFuel |
      | SurveyData.SurveyFuelData_Renewable | RenewableTypeID | EnergyProducedOrSaved | ProducedDeliveredEnergy | PartLtotalcontribution | EnerProdFuel |
