package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/resources/Features/03_startSurveyJson_SpaceHeating.feature",
        "src/test/resources/Features/04_startSurveyJson_WaterHeating.feature"
}, glue = "StepDefinitions", plugin = { "pretty", "json:target/cucumber-reports/reports.json",
        "html:target/cucumber-reports/reports2.html" })
public class TestRunner2 {
}
