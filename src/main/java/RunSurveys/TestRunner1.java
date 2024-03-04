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
                "src/test/resources/Features/01_startSurveyJson_Building.feature",
                "src/test/resources/Features/02_startSurveyJson_Ventilation.feature"
		}, glue = "StepDefinitions", plugin = {
                                "pretty",
                                "json:target/cucumber-reports/reports.json",
                                "html:target/cucumber-reports/reports2.html" })
public class TestRunner1 {

        public static void main(String[] args) {
//                String[] jsonFiles = { "10309532437.json", "10001722562.json", "10000199106.json" };
        	  String[] jsonFiles = { "10309532437.json" };
                for (String jsonFile : jsonFiles) {
                        runTests(jsonFile);
                }
        }

        private static void runTests(String jsonFile) {
                String jsonFilePath = "C:\\Users\\BrodyE\\SEAI\\QA Automation\\DataFile\\" + File.separator + jsonFile;

                // Check if the file exists
                if (!Files.exists(Paths.get(jsonFilePath))) {
                        System.out.println("File does not exist: " + jsonFilePath);
                        return;
                }

                System.setProperty("surveyFile", jsonFilePath);

                System.out.println("Absolute Path: !!!! " + jsonFilePath);

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
