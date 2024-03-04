Feature: Feature to test Adding a Survey functionality

  Scenario Outline: Add Space Heating Data
    Given user enters Space Heating section
    When read test data from Json file ""
    Then Space Heating system Properties
      | SurveySHSelectedTypes                               | SpaceHeatingTypeID | SurveySHHeatSourceProperties                               | HeatingSystemCategoryID | SubCategory1ID | SubCategory2ID | HeatingSystem | HeatEmitterType | HeatingSystemControlsID | LoadWeatherCompensation |
      | SurveyData.SurveySpaceHeating.SurveySHSelectedTypes | SpaceHeatingTypeID | SurveyData.SurveySpaceHeating.SurveySHHeatSourceProperties | HeatingSystemCategoryID | SubCategory1ID | SubCategory2ID | HeatingSystem | HeatEmitterType | HeatingSystemControlsID | LoadWeatherCompensation |
    Then Pumps and Fans Page
      | SurveySHGainLosses                               | PumpsCentralHeating | CentralHeatingThermostat | CentralHeatingThermostatContainer | CentralHeatingInsideDwelling | CentralHeatingTotalElectirc | PumpsOilBoiler | OilBoilerThermostat | OilBoilerInsideDwelling | PumpsGasBoilerFlueFan | WarmAirHeatingOrFanCoilRadiator |
      | SurveyData.SurveySpaceHeating.SurveySHGainLosses | PumpsCentralHeating | CentralHeatingThermostat | CentralHeatingThermostatContainer | CentralHeatingInsideDwelling | CentralHeatingTotalElectirc | PumpsOilBoiler | OilBoilerThermostat | OilBoilerInsideDwelling | PumpsGasBoilerFlueFan | WarmAirHeatingOrFanCoilRadiator |
    Then Heat Sources Page
      | SurveyWHStorageTypes                               | SurveySHHeatSources                               | LibraryItem | LibraryItemTypeID | LibraryItemSourceID | MarketingName | Manufacturer | Model | LibraryItemHeatSource | HeatingSourceTypeId | DEAPSeasonalEfficiency | LibraryItemHeatPump | HeatPumpTypeId | SpaceHeatingStandardId | WaterHeatingStandardId | DEAPWHSeasonalEfficiency | TemperatureControlId | TOL | WTOL | SpaceHeatingTestData | TemperatureCategoryId | ApplicationHeatingCapacityA | ApplicationHeatingCapacityB | ApplicationHeatingCapacityC | ApplicationHeatingCapacityD | ApplicationHeatingCapacityE | ApplicationHeatingCoefficientOfPerformanceA | ApplicationHeatingCoefficientOfPerformanceB | ApplicationHeatingCoefficientOfPerformanceC | ApplicationHeatingCoefficientOfPerformanceD | ApplicationHeatingCoefficientOfPerformanceE | WaterHeatingSourceOfDataId | WaterHeatingEfficiency | ReferenceHotWaterTemperature | CapacityOfHeatPump | DeclaredLoadProfileId | StandByHeatLoss | VolumeOfDHW | DesignFlowTemperature | LinkToWater | DailyOperationHours | PercentageOfHeat | FuelTypeID | DomesticHotWaterStorageId |
      | SurveyData.SurveyWaterHeating.SurveyWHStorageTypes | SurveyData.SurveySpaceHeating.SurveySHHeatSources | LibraryItem | LibraryItemTypeID | LibraryItemSourceID | MarketingName | Manufacturer | Model | LibraryItemHeatSource | HeatingSourceTypeId | DEAPSeasonalEfficiency | LibraryItemHeatPump | HeatPumpTypeId | SpaceHeatingStandardId | WaterHeatingStandardId | DEAPWHSeasonalEfficiency | TemperatureControlId | TOL | WTOL | SpaceHeatingTestData | TemperatureCategoryId | ApplicationHeatingCapacityA | ApplicationHeatingCapacityB | ApplicationHeatingCapacityC | ApplicationHeatingCapacityD | ApplicationHeatingCapacityE | ApplicationHeatingCoefficientOfPerformanceA | ApplicationHeatingCoefficientOfPerformanceB | ApplicationHeatingCoefficientOfPerformanceC | ApplicationHeatingCoefficientOfPerformanceD | ApplicationHeatingCoefficientOfPerformanceE | WaterHeatingSourceOfDataId | WaterHeatingEfficiency | ReferenceHotWaterTemperature | CapacityOfHeatPump | DeclaredLoadProfileId | StandByHeatLoss | VolumeOfDHW | DesignFlowTemperature | LinkToWater | DailyOperationHours | PercentageOfHeat | FuelTypeID | DomesticHotWaterStorageId |
    And Group Schema in Heat Sources Page
      | SurveySHHeatSourceGroups                               | SurveySHHeatSourceGroupItems | PercentageOfHeat | PercentageEfficiency | DistributionLossFactor | PercentageOfSecondaryHeat | SurveySHCHPGroups                               | FractionOfHeat | PercentageEffciencyOfSecondarySystem | ChargingOnConsumption | SecondarySpaceHeatingFuelID | HeatingSystemID | FuelTypeID | CHPElectricalEfficiencyOfCHPunit | HeatEfficiencyOfCHP |
      | SurveyData.SurveySpaceHeating.SurveySHHeatSourceGroups | SurveySHHeatSourceGroupItems | PercentageOfHeat | PercentageEfficiency | DistributionLossFactor | PercentageOfSecondaryHeat | SurveyData.SurveySpaceHeating.SurveySHCHPGroups | FractionOfHeat | PercentageEffciencyOfSecondarySystem | ChargingOnConsumption | SecondarySpaceHeatingFuelID | HeatingSystemID | FuelTypeID | CHPElectricalEfficiencyOfCHPunit | HeatEfficiencyOfCHP |
    Then Summer Internal Temperature Page
      | SurveySHSummers                               | AirChangeRate | SummerMeanExternal |
      | SurveyData.SurveySpaceHeating.SurveySHSummers | AirChangeRate | SummerMeanExternal |