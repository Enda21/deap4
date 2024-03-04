Feature: Feature to test Adding a Survey functionality
    Scenario Outline: Add a new Survey Building Data
        Given user is on login page
        Then user is navigated to the home page

        When read test data from Json file ""

        Then user will click the start new survay link

        When user will navigate to new survay page

        And user have to enter survey details
            | MPRN                     | Address                      | BERCurrent                     | Address1                     | Address2                     | Address3                     | County                     | Eircode                     | DwellingDescription                     | Year                     | Extended                     | RatingTypeID/Name      | RatingPurposeID/Name      | BuildingRegsID/Description     | PlanningReference        | DateOfPlans        | Description        | Comments        |
            | SurveyData.Dwelling.MPRN | SurveyData.Dwelling.Address1 | SurveyData.Dwelling.BERCurrent | SurveyData.Dwelling.Address1 | SurveyData.Dwelling.Address2 | SurveyData.Dwelling.Address3 | SurveyData.Dwelling.County | SurveyData.Dwelling.Eircode | SurveyData.Dwelling.DwellingDescription | SurveyData.Dwelling.Year | SurveyData.Dwelling.Extended | Survey.Ratingtype.Name | Survey.RatingPurpose.Name | Survey.BuildingReg.Description | Survey.PlanningReference | Survey.DateOfPlans | Survey.Description | Survey.Comments |

        And user have to enter survey details popup
            | Type of rating         | Purpose                   | Regulation                                    | PlanningReference        | DateOfPlans        | Description        | Accessor Comments |
            | Survey.RatingType.Name | Survey.RatingPurpose.Name | Survey.BuildingReg.Description.BuildingRegsID | Survey.PlanningReference | Survey.DateOfPlans | Survey.Description | Survey.Comments   |

        And user enters Building details

        And user selects new  Lib Iteam Doort
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

        And clicks add WallS details
            | Wall                                   | WallType   | AgeBandID | Description | Area | SemiExposed | UValue |
            | SurveyData.SurveyBuilding.SurveyBWalls | WallTypeID | AgeBandID | Description | Area | SemiExposed | UValue |


        And user selects new  Lib Iteam Rooms
            | Rooms                  | LibraryItem |
            | SurveyData.SurveyItems | LibraryItem |

        And user selects new  Lib Iteam Windows
            | Windows                | LibraryItem | LibraryItemTypeID | MarketingName | Keywords         | Manufacturer | Model | Glazing           | Openings | Draught                 | Type          | FrameType     | Gap   | FrameFactor      | Uvalue | SolarEnergy              | Blinds  | OverhangType | OverhangDepthRatio | RoofWindow |
            | SurveyData.SurveyItems | LibraryItem | LibraryItemTypeID | MarketingName | AssessorKeywords | Manufacturer | Model | LibraryItemWindow | Openings | DraughtStrippedOpenings | GlazingTypeID | FrameFactorID | GapID | FrameFactorValue | UValue | SolarEnergyTransmittance | BlindID | OverhangID   | OverhangDepthID    | RoofWindow |


        And clicks Global Factors add Global Factors details
            | SurveyBGenerals                           | ThermalMassCategoryID | ThermalBridgingFactorID | ThermalBridgingFactor |
            | SurveyData.SurveyBuilding.SurveyBGenerals | ThermalMassCategoryID | ThermalBridgingFactorID | ThermalBridgingFactor |

        And Configure INFILTRATION DUE TO OPENINGS in Ventilation details Page
            | AddVentilationCommonItem | LibraryItem | MarketingName | Number | SurveyBGenerals                           | DraughtLobby |
            | SurveyData.SurveyItems   | LibraryItem | MarketingName | Number | SurveyData.SurveyBuilding.SurveyBGenerals | DraughtLobby |


        And Configure STRUCTURAL AIR TIGHTNESS details Page
            | SurveyVentilations                              | AirPermeabilityResult | SurveyBGenerals                           | NoOfSidesSheltered | Number | StructuralInfiltrationID | WoodenFloorID | SurveyItems            | LibraryItem | MarketingName |
            | SurveyData.SurveyVentilation.SurveyVentilations | AirPermeabilityResult | SurveyData.SurveyBuilding.SurveyBGenerals | NoOfSidesSheltered | Number | StructuralInfiltrationID | WoodenFloorID | SurveyData.SurveyItems | LibraryItem | MarketingName |


        And Ventilation Method Page detail
            | SurveyVentilations                              | Method              | FanPower | HeatExchanger | Manufacturer | Model | Wetrooms | AdjustedHeatExchangerEfficiency | ExternalUninsulatedDucting |
            | SurveyData.SurveyVentilation.SurveyVentilations | VentilationMethodID | FanPower | HeatExchanger | Manufacturer | Model | Wetrooms | AdjustedHeatExchangerEfficiency | ExternalUninsulatedDucting |

        And Space Heating section

        And Space Heating system Properties
            | SurveySHSelectedTypes                               | SpaceHeatingTypeID | SurveySHHeatSourceProperties                               | HeatingSystemCategoryID | SubCategory1ID | SubCategory2ID | HeatingSystem | HeatEmitterType | HeatingSystemControlsID | LoadWeatherCompensation |
            | SurveyData.SurveySpaceHeating.SurveySHSelectedTypes | SpaceHeatingTypeID | SurveyData.SurveySpaceHeating.SurveySHHeatSourceProperties | HeatingSystemCategoryID | SubCategory1ID | SubCategory2ID | HeatingSystem | HeatEmitterType | HeatingSystemControlsID | LoadWeatherCompensation |


        And Pumps and Fans Page
            | SurveySHGainLosses                               | PumpsCentralHeating | CentralHeatingThermostat | CentralHeatingThermostatContainer | CentralHeatingInsideDwelling | CentralHeatingTotalElectirc | PumpsOilBoiler | OilBoilerThermostat | OilBoilerInsideDwelling | PumpsGasBoilerFlueFan | WarmAirHeatingOrFanCoilRadiator |
            | SurveyData.SurveySpaceHeating.SurveySHGainLosses | PumpsCentralHeating | CentralHeatingThermostat | CentralHeatingThermostatContainer | CentralHeatingInsideDwelling | CentralHeatingTotalElectirc | PumpsOilBoiler | OilBoilerThermostat | OilBoilerInsideDwelling | PumpsGasBoilerFlueFan | WarmAirHeatingOrFanCoilRadiator |

        And Heat Sources Page
            | SurveyWHStorageTypes                               | SurveySHHeatSources                               | LibraryItem | LibraryItemTypeID | LibraryItemSourceID | MarketingName | Manufacturer | Model | LibraryItemHeatSource | HeatingSourceTypeId | DEAPSeasonalEfficiency | LibraryItemHeatPump | HeatPumpTypeId | SpaceHeatingStandardId | WaterHeatingStandardId | DEAPWHSeasonalEfficiency | TemperatureControlId | TOL | WTOL | SpaceHeatingTestData | TemperatureCategoryId | ApplicationHeatingCapacityA | ApplicationHeatingCapacityB | ApplicationHeatingCapacityC | ApplicationHeatingCapacityD | ApplicationHeatingCapacityE | ApplicationHeatingCoefficientOfPerformanceA | ApplicationHeatingCoefficientOfPerformanceB | ApplicationHeatingCoefficientOfPerformanceC | ApplicationHeatingCoefficientOfPerformanceD | ApplicationHeatingCoefficientOfPerformanceE | WaterHeatingSourceOfDataId | WaterHeatingEfficiency | ReferenceHotWaterTemperature | CapacityOfHeatPump | DeclaredLoadProfileId | StandByHeatLoss | VolumeOfDHW | DesignFlowTemperature | LinkToWater | DailyOperationHours | PercentageOfHeat | FuelTypeID | DomesticHotWaterStorageId |
            | SurveyData.SurveyWaterHeating.SurveyWHStorageTypes | SurveyData.SurveySpaceHeating.SurveySHHeatSources | LibraryItem | LibraryItemTypeID | LibraryItemSourceID | MarketingName | Manufacturer | Model | LibraryItemHeatSource | HeatingSourceTypeId | DEAPSeasonalEfficiency | LibraryItemHeatPump | HeatPumpTypeId | SpaceHeatingStandardId | WaterHeatingStandardId | DEAPWHSeasonalEfficiency | TemperatureControlId | TOL | WTOL | SpaceHeatingTestData | TemperatureCategoryId | ApplicationHeatingCapacityA | ApplicationHeatingCapacityB | ApplicationHeatingCapacityC | ApplicationHeatingCapacityD | ApplicationHeatingCapacityE | ApplicationHeatingCoefficientOfPerformanceA | ApplicationHeatingCoefficientOfPerformanceB | ApplicationHeatingCoefficientOfPerformanceC | ApplicationHeatingCoefficientOfPerformanceD | ApplicationHeatingCoefficientOfPerformanceE | WaterHeatingSourceOfDataId | WaterHeatingEfficiency | ReferenceHotWaterTemperature | CapacityOfHeatPump | DeclaredLoadProfileId | StandByHeatLoss | VolumeOfDHW | DesignFlowTemperature | LinkToWater | DailyOperationHours | PercentageOfHeat | FuelTypeID | DomesticHotWaterStorageId |


        And Group Schema in Heat Sources Page
            | SurveySHHeatSourceGroups                               | SurveySHHeatSourceGroupItems | PercentageOfHeat | PercentageEfficiency | DistributionLossFactor | PercentageOfSecondaryHeat | SurveySHCHPGroups                               | FractionOfHeat | PercentageEffciencyOfSecondarySystem | ChargingOnConsumption | SecondarySpaceHeatingFuelID | HeatingSystemID | FuelTypeID | CHPElectricalEfficiencyOfCHPunit | HeatEfficiencyOfCHP |
            | SurveyData.SurveySpaceHeating.SurveySHHeatSourceGroups | SurveySHHeatSourceGroupItems | PercentageOfHeat | PercentageEfficiency | DistributionLossFactor | PercentageOfSecondaryHeat | SurveyData.SurveySpaceHeating.SurveySHCHPGroups | FractionOfHeat | PercentageEffciencyOfSecondarySystem | ChargingOnConsumption | SecondarySpaceHeatingFuelID | HeatingSystemID | FuelTypeID | CHPElectricalEfficiencyOfCHPunit | HeatEfficiencyOfCHP |

        And Summer Internal Temperature Page
            | SurveySHSummers                               | AirChangeRate | SummerMeanExternal |
            | SurveyData.SurveySpaceHeating.SurveySHSummers | AirChangeRate | SummerMeanExternal |

        And Water Heating Page
        And Heat Source details in Water Heating Page
            | SurveyWHHeatSources                               | LibraryItem | LibraryItemTypeID | LibraryItemSourceID | MarketingName | Manufacturer | Model | LibraryItemHeatSource | HeatingSourceTypeId | LibraryItemHeatPump | HeatPumpTypeId | SpaceHeatingStandardId | WaterHeatingStandardId | DEAPSeasonalEfficiency | DEAPWHSeasonalEfficiency | TemperatureControlId | TOL | WTOL | SpaceHeatingTestData | TemperatureCategoryId | ApplicationHeatingCapacityA | ApplicationHeatingCapacityB | ApplicationHeatingCapacityC | ApplicationHeatingCapacityD | ApplicationHeatingCapacityE | ApplicationHeatingCoefficientOfPerformanceA | ApplicationHeatingCoefficientOfPerformanceB | ApplicationHeatingCoefficientOfPerformanceC | ApplicationHeatingCoefficientOfPerformanceD | ApplicationHeatingCoefficientOfPerformanceE | WaterHeatingSourceOfDataId | WaterHeatingEfficiency | ReferenceHotWaterTemperature | CapacityOfHeatPump | DeclaredLoadProfileId | StandByHeatLoss | VolumeOfDHW | DesignFlowTemperature | DailyOperationHours | PercentageOfHeat | FuelTypeID | DomesticHotWaterStorageId |
            | SurveyData.SurveyWaterHeating.SurveyWHHeatSources | LibraryItem | LibraryItemTypeID | LibraryItemSourceID | MarketingName | Manufacturer | Model | LibraryItemHeatSource | HeatingSourceTypeId | LibraryItemHeatPump | HeatPumpTypeId | SpaceHeatingStandardId | WaterHeatingStandardId | DEAPSeasonalEfficiency | DEAPWHSeasonalEfficiency | TemperatureControlId | TOL | WTOL | SpaceHeatingTestData | TemperatureCategoryId | ApplicationHeatingCapacityA | ApplicationHeatingCapacityB | ApplicationHeatingCapacityC | ApplicationHeatingCapacityD | ApplicationHeatingCapacityE | ApplicationHeatingCoefficientOfPerformanceA | ApplicationHeatingCoefficientOfPerformanceB | ApplicationHeatingCoefficientOfPerformanceC | ApplicationHeatingCoefficientOfPerformanceD | ApplicationHeatingCoefficientOfPerformanceE | WaterHeatingSourceOfDataId | WaterHeatingEfficiency | ReferenceHotWaterTemperature | CapacityOfHeatPump | DeclaredLoadProfileId | StandByHeatLoss | VolumeOfDHW | DesignFlowTemperature | DailyOperationHours | PercentageOfHeat | FuelTypeID | DomesticHotWaterStorageId |

        And Options and Storage in Water Heating Page
            | SurveyWHLosses                               | Storage | StorageIndoorGroupScheme | Distribution | StorageVolume |
            | SurveyData.SurveyWaterHeating.SurveyWHLosses | Storage | StorageIndoorGroupScheme | Distribution | StorageVolume |


        And Options and Storage Losses in Water Heating Page
            | SurveyWHStorageTypes                               | InsulationTypeID | CylinderThickness | WaterStorageID | CylinderThermostatContainer | CylinderHeatedByBoiler | SurveyWHLosses                               | MakeModel | DeclaredLoss | SystemTypeID | CylinderThermostat |
            | SurveyData.SurveyWaterHeating.SurveyWHStorageTypes | InsulationTypeID | CylinderThickness | WaterStorageID | CylinderThermostatContainer | CylinderHeatedByBoiler | SurveyData.SurveyWaterHeating.SurveyWHLosses | MakeModel | DeclaredLoss | SystemTypeID | CylinderThermostat |

        And Combi Boiler in Water Heating Page

            | SurveyWHLosses                               | Distribution | CombiID | KeepHotID | AdditionalLoss | KeepHotConsumption |
            | SurveyData.SurveyWaterHeating.SurveyWHLosses | Distribution | CombiID | KeepHotID | AdditionalLoss | KeepHotConsumption |


        And Showers and Baths in Water Heating Page
            | SurveyItems            | LibraryItem | LibraryItemTypeID | MarketingName | ProducedDeliveredEnergy | PartLtotalcontribution | Number |
            | SurveyData.SurveyItems | LibraryItem | LibraryItemTypeID | MarketingName | ProducedDeliveredEnergy | PartLtotalcontribution | Number |

        And details Showers and Baths in Water Heating Page

        And user selects Survey that Exists
            | Description        |
            | Survey.Description |

        And Lighting details Page
            | IsLightingDesignKnown                           | SurveyItems            | LibraryItem | LibraryItemTypeID | MarketingName | Number | LibraryItemSourceID | Manufacturer | Model | LibraryItemBulb | Efficiency | Power |
            | SurveyData.SurveyLighting.IsLightingDesignKnown | SurveyData.SurveyItems | LibraryItem | LibraryItemTypeID | MarketingName | Number | LibraryItemSourceID | Manufacturer | Model | LibraryItemBulb | Efficiency | Power |

        And Renewable details
            | SurveyFuelData_Renewable            | RenewableTypeID | EnergyProducedOrSaved | ProducedDeliveredEnergy | PartLtotalcontribution | EnerProdFuel |
            | SurveyData.SurveyFuelData_Renewable | RenewableTypeID | EnergyProducedOrSaved | ProducedDeliveredEnergy | PartLtotalcontribution | EnerProdFuel |

        And MPCDER details

        And Result details Page
            | Results | TotalDwellingArea | LivingRoomArea | LivingRoom | TotalElementArea | TotalHeatLoss | AdjustedInfiltrationRate | Mainspaceheatingsystem |
            | Results | TotalDwellingArea | LivingRoomArea | LivingRoom | TotalElementArea | TotalHeatLoss | AdjustedInfiltrationRate | Mainspaceheatingsystem |