package RunSurveys;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.SuiteConstants;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
				"src/test/resources/Features/01_startSurveyJson.feature",
                "src/test/resources/Features/02_startSurveyJson_Building.feature",
                "src/test/resources/Features/03_startSurveyJson_SpaceHeating.feature",
                "src/test/resources/Features/03_startSurveyJson_SpaceHeating.feature",
                "src/test/resources/Features/04_startSurveyJson_Ventilation.feature",
                "src/test/resources/Features/05_startSurveyJson_Lighting.feature",
                "src/test/resources/Features/07_startSurveyJson_WaterHeating.feature",
                "src/test/resources/Features/08_startSurveyJson_Results.feature"
                
				}, glue = "StepDefinitions", plugin = {
                                "pretty",
                                "json:target/cucumber-reports/reports.json",
                                "html:target/cucumber-reports/reports2.html" })
public class TestRunner1 {

        public static void main(String[] args) {
               String fixedPath = "deap4\\DataFile\\";
		String[] jsonFiles = { "10309532437.json" };
		for (String jsonFile : jsonFiles) {
    			String filePath = fixedPath + jsonFile;
    			runTests(filePath);
		}

        }

        private static void runTests(String jsonFile) {
                // Check if the file exists
        if (!Files.exists(Paths.get(jsonFile))) {
                System.out.println("File does not exist: " + jsonFile);
                return;
        }

        System.setProperty("surveyFile", jsonFile);

        System.out.println("Absolute Path: !!!! " + jsonFile);

                try {
                        Result result = JUnitCore.runClasses(TestRunner1.class);

                        System.out.println("Executing tests for " + jsonFile);

                        for (Failure failure : result.getFailures()) {
                                System.out.println(failure.toString());
                        }

                        if (result.wasSuccessful()) {
                                System.out.println("All tests passed successfully for " + jsonFile);
                        } else {
                                System.out.println("Tests failed for " + jsonFile);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

}
