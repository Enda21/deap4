Feature: Feature to test Adding a Survey functionality

  Scenario Outline: Add Water Heating Data
    Given Water Heating Page
    When read test data from Json file ""
    Then Heat Source details in Water Heating Page
      | SurveyWHHeatSources                               | LibraryItem | LibraryItemTypeID | LibraryItemSourceID | MarketingName | Manufacturer | Model | LibraryItemHeatSource | HeatingSourceTypeId | LibraryItemHeatPump | HeatPumpTypeId | SpaceHeatingStandardId | WaterHeatingStandardId | DEAPSeasonalEfficiency | DEAPWHSeasonalEfficiency | TemperatureControlId | TOL | WTOL | SpaceHeatingTestData | TemperatureCategoryId | ApplicationHeatingCapacityA | ApplicationHeatingCapacityB | ApplicationHeatingCapacityC | ApplicationHeatingCapacityD | ApplicationHeatingCapacityE | ApplicationHeatingCoefficientOfPerformanceA | ApplicationHeatingCoefficientOfPerformanceB | ApplicationHeatingCoefficientOfPerformanceC | ApplicationHeatingCoefficientOfPerformanceD | ApplicationHeatingCoefficientOfPerformanceE | WaterHeatingSourceOfDataId | WaterHeatingEfficiency | ReferenceHotWaterTemperature | CapacityOfHeatPump | DeclaredLoadProfileId | StandByHeatLoss | VolumeOfDHW | DesignFlowTemperature | DailyOperationHours | PercentageOfHeat | FuelTypeID | DomesticHotWaterStorageId |
      | SurveyData.SurveyWaterHeating.SurveyWHHeatSources | LibraryItem | LibraryItemTypeID | LibraryItemSourceID | MarketingName | Manufacturer | Model | LibraryItemHeatSource | HeatingSourceTypeId | LibraryItemHeatPump | HeatPumpTypeId | SpaceHeatingStandardId | WaterHeatingStandardId | DEAPSeasonalEfficiency | DEAPWHSeasonalEfficiency | TemperatureControlId | TOL | WTOL | SpaceHeatingTestData | TemperatureCategoryId | ApplicationHeatingCapacityA | ApplicationHeatingCapacityB | ApplicationHeatingCapacityC | ApplicationHeatingCapacityD | ApplicationHeatingCapacityE | ApplicationHeatingCoefficientOfPerformanceA | ApplicationHeatingCoefficientOfPerformanceB | ApplicationHeatingCoefficientOfPerformanceC | ApplicationHeatingCoefficientOfPerformanceD | ApplicationHeatingCoefficientOfPerformanceE | WaterHeatingSourceOfDataId | WaterHeatingEfficiency | ReferenceHotWaterTemperature | CapacityOfHeatPump | DeclaredLoadProfileId | StandByHeatLoss | VolumeOfDHW | DesignFlowTemperature | DailyOperationHours | PercentageOfHeat | FuelTypeID | DomesticHotWaterStorageId |
    Then Options and Storage in Water Heating Page
      | SurveyWHLosses                               | Storage | StorageIndoorGroupScheme | Distribution | StorageVolume |
      | SurveyData.SurveyWaterHeating.SurveyWHLosses | Storage | StorageIndoorGroupScheme | Distribution | StorageVolume |
    Then Options and Storage Losses in Water Heating Page
      | SurveyWHStorageTypes                               | InsulationTypeID | CylinderThickness | WaterStorageID | CylinderThermostatContainer | CylinderHeatedByBoiler | SurveyWHLosses                               | MakeModel | DeclaredLoss | SystemTypeID | CylinderThermostat |
      | SurveyData.SurveyWaterHeating.SurveyWHStorageTypes | InsulationTypeID | CylinderThickness | WaterStorageID | CylinderThermostatContainer | CylinderHeatedByBoiler | SurveyData.SurveyWaterHeating.SurveyWHLosses | MakeModel | DeclaredLoss | SystemTypeID | CylinderThermostat |
    Then Combi Boiler in Water Heating Page
      | SurveyWHLosses                               | Distribution | CombiID | KeepHotID | AdditionalLoss | KeepHotConsumption |
      | SurveyData.SurveyWaterHeating.SurveyWHLosses | Distribution | CombiID | KeepHotID | AdditionalLoss | KeepHotConsumption |
    And Showers and Baths in Water Heating Page
      | SurveyItems            | LibraryItem | LibraryItemTypeID | MarketingName | ProducedDeliveredEnergy | PartLtotalcontribution | Number |
      | SurveyData.SurveyItems | LibraryItem | LibraryItemTypeID | MarketingName | ProducedDeliveredEnergy | PartLtotalcontribution | Number |
    Then details Showers and Baths in Water Heating Page
