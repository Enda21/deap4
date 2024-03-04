package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.*;
import pages.LoginPage;
import utils.BaseTest;
import pages.LoginPage;

public class hook extends BaseTest {

	@Before
	public void beforeMethod() {
        if (driver == null) {
            initializeDriver();
            performLogin();
        }
    }

    private void initializeDriver() {
        // Start ChromeDriver only if it's not already running
    	LaunchBrowser();
    }

    private void performLogin() {
        // Log in once at the beginning
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("Login into the App DONE IN THE BEFORE!!!");
        loginPage.enterUsernameAndPassword("105285", "Password24");
        loginPage.clickLogin();
    }

    public static WebDriver getDriver() {
        return driver;
    }

	@After
	public void afterMethod(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

				// Create the directory if it doesn't exist
				File screenshotDirectory = new File("target/screenshots/");
				if (!screenshotDirectory.exists()) {
					screenshotDirectory.mkdirs();
				}

				// Save the screenshot with a meaningful filename
				String screenshotFileName = "target/screenshots/" + "failedTest.png";
				Files.write(Paths.get(screenshotFileName), screenshot);

				// Attach the screenshot to the scenario
				scenario.attach(screenshot, "image/png", scenario.getName() + " (Failed)");

				// Print a message to the console
				System.out.println("Screenshot captured for failed scenario: " + screenshotFileName);
			}
		} catch (WebDriverException e) {
			// WebDriverException or other specific exceptions thrown by Selenium methods
			System.err.println("Exception while capturing screenshot: " + e.getMessage());
		} catch (IOException e) {
			// IOException for file operations
			System.err.println("Exception while writing screenshot to file: " + e.getMessage());
		} 
			//finally {
//			try {
//				// Quit the driver only if it's not null
//				if (driver != null) {
//					driver.quit();
//				}
//			} catch (Exception e) {
//				System.err.println("Exception during driver quit: " + e.getMessage());
//			}
//		}
	}

	@AfterStep
	public void tearDown(Scenario scenario) {
	}
}
