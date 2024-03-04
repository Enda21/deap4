package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
                "src/test/resources/Features/05_startSurveyJson_Lighting.feature",
                "src/test/resources/Features/06_startSurveyJson_Renewables.feature",
                "src/test/resources/Features/07_startSurveyJson_Results.feature"
}, glue = "StepDefinitions", plugin = { "pretty", "json:target/cucumber-reports/reports.json",
                "html:target/cucumber-reports/reports2.html" })
public class TestRunner3 {
}
