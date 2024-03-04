package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.BaseTest;
import utils.JsonUtils;
import utils.SuiteConstants;

public class LoginSteps extends BaseTest {

	@Given("user is on login page test")
	public void user_is_on_login_page_test() {

	}

	@When("clicks on login button test")
	public void clicks_on_login_button_test() {

	}

	@Then("user is navigated to the home page test")
	public void user_is_navigated_to_the_home_page_test() {

	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		LaunchBrowser();

	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsernameAndPassword(username, password);

	}

	@When("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.clickLogin();

	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {

	}

	@When("^read test data from Json file \"([^\"]*)\"$")
	public void read_test_data_from_Json_file(String fileName) throws Throwable {
		String surveyFilePath = System.getProperty("surveyFile");
		String jsonFilePath = surveyFilePath + fileName;
		JsonUtils.readJsonFile(jsonFilePath);

		//JsonUtils.readJsonFile(SuiteConstants.TestDataFolder + fileName);
	}

	@Given("user is on the Portal")
	public void navigate_to_portal() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.navigateToPortal();
	}
	
	@Then("user selects My Portal")
	public void open_my_portal() {
		sleep(5000);
		hoverOpenNavigation();
		Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(By.xpath("//app-survey-navigation-item[@label='My Portal']//span[@class='mat-list-item-content']"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();

		waitForAngularPageToLoad();
	}
	
	@Then("user selects Cancel button")
	public void select_cancel_button()
	{
		Actions actions = new Actions(driver);
		WebElement cancelButton = driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-button mat-button-base']"));

		actions.moveToElement(cancelButton).perform();

		cancelButton.click();
		waitForAngularPageToLoad();
	}
}
