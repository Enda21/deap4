package StepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.stream.Collectors;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import pages.LoginPage;
import utils.BaseTest;
import utils.JsonUtils;
import utils.SuiteConstants;

public class startNewSurvey extends BaseTest {
	LoginPage loginPage = new LoginPage(driver);
	HashMap<String, HashMap<String, Object>> addedVentilationList = new HashMap<String, HashMap<String, Object>>();

	@Then("user will click the start new survay link")
	public void user_will_click_the_start_new_survay_link() {
		waitForAngularPageToLoad();
		Actions actions = new Actions(driver);
		WebElement startNewSur = driver.findElement(By.xpath("//span[contains(text(),'Start New Survey')]"));
		actions.moveToElement(startNewSur);
		actions.click().build().perform();

		// driver.findElement(By.xpath("//span[contains(text(),'Start New
		// Survey')]")).click();
		waitForAngularPageToLoad();
		// sleep(5000);
	}

	@When("user will navigate to new survay page")
	public void user_will_navigate_to_new_survay_page() {
		// driver.findElement(By.xpath("//span[contains(text(),'click here if MPRN is
		// unknown')]")).click();
	}

	@When("user selects value from list")
	public void user_selects_value_from_list() {

		driver.findElement(By.xpath("(//*[contains(@class,'survey-date')])[2]")).click();
		waitForAngularPageToLoad();

		Actions actions = new Actions(driver);
		WebElement subMenu = driver.findElement(By.xpath("//div[text()='Building']"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();

		// driver.findElement(By.xpath("//a[@aria-label='Building']")).click();

		waitForAngularPageToLoad();
	}

	@Then("user click here if MPRN is unknown")
	public void user_click_here_if_mprn_is_unknown() {
		// driver.findElement(By.name("DwellingMprn")).click();
		// driver.findElement(By.name("DwellingMprn")).sendKeys("10305693190");
		waitForAngularPageToLoad();
		driver.findElement(By.id("MPRNContainer")).click();
		driver.findElement(By.id("MPRNContainer")).sendKeys("10305693190");

		waitForAngularPageToLoad();

		Actions actions = new Actions(driver);
		WebElement subMenu = driver.findElement(By.xpath("//li//span[contains(text(),'SOUTH BERRINGS')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();

		// driver.findElement(By.xpath("(//span[contains(text(),'SOUTH
		// BERRINGS')])[2]")).click();

	}

	@Then("user have entered a MPRN")
	public void user_have_entered_a_mprn() {

	}

	@Then("user have entered a BER Number")
	public void user_have_entered_a_ber_number() {

	}

	@Then("user have entered Address Line {int}")
	public void user_have_entered_address_line(Integer int1) {

	}

	@Then("user selects city")
	public void user_selects_city() {

	}

	@Then("user have entered Eircode")
	public void user_have_entered_eircode() {

		driver.findElement(By.name("AddDwellingEircode")).sendKeys("A123456");

	}

	@Then("user selects Dwelling Type")
	public void user_selects_dwelling_type() {

	}

	@Then("user have entered Year of construction")
	public void user_have_entered_year_of_construction() {

	}

	@Then("clicks on next button")
	public void clicks_on_next_button() {

		driver.findElement(By.xpath("//button[text()='Next']")).click();
		sleep(6000);

	}

	@Then("user selects Type of Rating as {string}, Purpose as {string} and Building regulations as {string}")
	public void user_selects_type_of_rating_as_purpose_as_and_building_regulations_as(String RatingType,
			String RatingPurposeID, String BuildingRegulations) {
		driver.findElement(By.name("RatingTypeID")).click();
		waitForAngularPageToLoad();
		driver.findElement(By.xpath("//div[text()='" + RatingType + "']")).click();
		waitForAngularPageToLoad();
		driver.findElement(By.name("RatingPurposeID")).click();
		waitForAngularPageToLoad();
		driver.findElement(By.xpath("//div[text()='" + RatingPurposeID + "']")).click();
		waitForAngularPageToLoad();
		if (BuildingRegulations.trim().length() > 0) {
			driver.findElement(By.name("BuildingRegsID")).click();
			waitForAngularPageToLoad();
			driver.findElement(By.xpath("//div[text()='" + BuildingRegulations + "']")).click();
			waitForAngularPageToLoad();
		}
	}

	@Then("user selects Type of Rating as {string}")
	public void user_selects_type_of_rating(String RatingType) {

		driver.findElement(By.name("RatingTypeID")).click();
		waitForAngularPageToLoad();

		driver.findElement(By.xpath("//div[text()='" + RatingType + "']")).click();

		waitForAngularPageToLoad();

	}

	@Then("user selects Purpose as {string}")
	public void user_selects_purpose(String RatingPurposeID) {

		driver.findElement(By.name("RatingPurposeID")).click();
		waitForAngularPageToLoad();
		driver.findElement(By.xpath("//div[text()='" + RatingPurposeID + "']")).click();

		waitForAngularPageToLoad();

	}

	@Then("user selects Building regulations as {string}")
	public void user_selects_building_regulations(String BuildingRegulations) {

		driver.findElement(By.name("BuildingRegsID")).click();
		waitForAngularPageToLoad();

		driver.findElement(By.xpath("//div[text()='" + BuildingRegulations + "']")).click();

		waitForAngularPageToLoad();

	}

	@Then("user selects Planning reference")
	public void user_selects_planning_reference() {

	}

	@Then("user selects Date od plans")
	public void user_selects_date_od_plans() {

	}

	@Then("enters Description")
	public void enters_description() {

	}

	@Then("enters Accessor Comments")
	public void enters_accessor_comments() {

	}

	@Then("clicks on start survey button")
	public void clicks_on_start_survey_button() {

		driver.findElement(By.xpath("//button/span[text()='Start Survey']")).click();
	}

	@Then("user is navigated to the survey page")
	public void user_is_navigated_to_the_survey_page() {
	}

	@Then("user enters Dwelling details")
	public void user_enters_dwelling_details(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object dwellingDetails = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("DWELLING"));

		Object dwellingTypeObject = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(dwellingDetails),
				data.get(0).get("DwellingDescription"));

		String dwellingTypeIDValue = String.valueOf(dwellingTypeObject.toString()).trim();
		Object dwellingYearObject = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(dwellingDetails),
				data.get(0).get("Year"));

		String dwellingYearValue = String.valueOf(dwellingYearObject.toString()).trim();

		// selectByTextFromDropdown(driver.findElement(By.id("DwellingTypeIDContainer")),
		// By.xpath("//mat-option[@ng-reflect-value='" + dwellingTypeIDValue + "']"));
		selectByTextFromDropdown(driver.findElement(By.id("DwellingTypeIDContainer")),
				By.xpath("//span[contains(text(),'" + dwellingTypeIDValue + "')]"));

		driver.findElement(By.id("Year")).click();
		waitForAngularPageToLoad();
		driver.findElement(By.id("Year")).sendKeys(dwellingYearValue);

		driver.findElement(By.xpath("//span[text()=' Continue ']")).click();
		waitForAngularPageToLoad();

	}

	
	public void user_enters_floor_details(io.cucumber.datatable.DataTable dataTable) {
		Actions actions = new Actions(driver);
		sleep(30000);

		WebElement menuOption = driver.findElement(By.xpath("//a[contains(@href,'/building')]"));
		waitForElementPresent(menuOption);
		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object noOfStoreyObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("No of storeys"));

		List<HashMap<String, Object>> noOfStoreys = JsonUtils.getJsonArrayValueAsListOfMap(noOfStoreyObject);
		waitForAngularPageToLoad();

		actions.moveToElement(driver.findElement(By.name("averageStoreyHeight0"))).perform();
		clickAndWait(By.id("NumberOfStoreys"));

		String noOfStoreysValue = String.valueOf(noOfStoreys.get(0).get("NumberOfStoreys")).trim();

		sendKeys(By.name("NumberOfStoreys"), String.valueOf(noOfStoreysValue));

		driver.findElement(By.name("NumberOfStoreys")).sendKeys(Keys.TAB);
		waitForAngularPageToLoad();

		Object storysObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Storys"));

		List<HashMap<String, Object>> storys = JsonUtils.getJsonArrayValueAsListOfMap(storysObject);

		for (int i = 0; i < Integer.valueOf(noOfStoreysValue); i++) {

			loginPage.storyHeight.get(i).click();
			waitForAngularPageToLoad();
			loginPage.storyHeight.get(i).sendKeys(storys.get(i).get("AverageStoreyHeight").toString());
		}

		driver.findElement(By.name("LivingArea")).sendKeys(noOfStoreys.get(0).get("LivingArea").toString().trim());
		waitForAngularPageToLoad();
	}

	/*
	 * 
	 * //List<List<String>> lists = dataTable.asLists(String.class); //List<String>
	 * vList = lists.get(1); List<Map<String, String>> data =
	 * dataTable.asMaps(String.class, String.class);
	 * driver.findElement(By.name("NumberOfStoreys")).clear();
	 * driver.findElement(By.name("NumberOfStoreys")).sendKeys(data.get(0).
	 * get("Number of Storeys")); sleep(10000); for (int i = 0; i <
	 * Integer.valueOf(data.get(0).get("Number of Storeys")); i++) {
	 * loginPage.storyHeight.get(i).sendKeys(data.get(0).
	 * get("Average Storey Height "+(i + 1))); }
	 * driver.findElement(By.name("LivingArea")).sendKeys(data.get(0).
	 * get("Living area")); }
	 */

	@And("user adds floor details")
	public void user_adds_floor_details(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object noOfStoreyObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("No of storeys"));

		List<HashMap<String, Object>> noOfStoreys = JsonUtils.getJsonArrayValueAsListOfMap(noOfStoreyObject);

		List<List<String>> lists = dataTable.asLists(String.class);

		String noOfStoreysValue = String.valueOf(noOfStoreys.get(0).get("NumberOfStoreys")).trim();

		// Object storysObject = JsonUtils.getNestedJsonStringValueByKey(json,
		// data.get(0).get("Storys"));

		// List<HashMap<String, Object>> storys =
		// JsonUtils.getJsonArrayValueAsListOfMap(storysObject);

		Object floorLocationIDObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("FloorLocationID"));

		List<HashMap<String, Object>> floorLocationID = JsonUtils.getJsonArrayValueAsListOfMap(floorLocationIDObject);
		waitForAngularPageToLoad();

		for (int i = 0; i < floorLocationID.size(); i++) {

			driver.findElement(By.xpath("//span[contains(text(),'Add Floor')]")).click();
			waitForAngularPageToLoad();

			// List<String> vList = lists.get(i);

			// drop down value not selected
			selectByTextFromDropdown(driver.findElement(By.name("FloorLocationID")),
					By.xpath("//span[@class='mat-option-text']"),
					" Storey " + floorLocationID.get(i).get("FloorLocationID"));

			waitForAngularPageToLoad();
			selectByTextFromDropdown(driver.findElement(By.id("FloorTypeID")),
					By.xpath("//span[@class='mat-option-text']"), floorLocationID.get(i).get("FloorTypeDescription"));
			waitForAngularPageToLoad();
			selectByTextFromDropdown(driver.findElement(By.id("AgeBandID")),
					By.xpath("//span[@class='mat-option-text']"), floorLocationID.get(i).get("AgeBandDescription"));

			System.out.println("Description key value:" + floorLocationID.get(i).get("Description"));

			// go compare null
			if (!floorLocationID.get(i).get("Description").toString().trim().equalsIgnoreCase(null)) {
				driver.findElement(By.name("Description")).clear();
				driver.findElement(By.name("Description"))
						.sendKeys(floorLocationID.get(i).get("Description").toString());
				driver.findElement(By.name("Description")).clear();
			}
			driver.findElement(By.name("Area")).clear();
			driver.findElement(By.name("Area")).sendKeys(floorLocationID.get(i).get("Area").toString());
			waitForAngularPageToLoad();
			WebElement complianceCheckbox = driver.findElement(By.name("ComplianceCheck"));

			checkOrUncheck(complianceCheckbox, floorLocationID.get(i).get("ComplianceCheck").toString().trim());

			if (floorLocationID.get(i).get("ComplianceCheck").toString().trim().equalsIgnoreCase("true")) {
				Check(complianceCheckbox);

			} else {
				UnCheck(complianceCheckbox);
			}

			WebElement underFloorHeatingCheckbox = driver.findElement(By.name("UnderFloorHeating"));

			checkOrUncheck(underFloorHeatingCheckbox,
					floorLocationID.get(i).get("UnderFloorHeating").toString().trim());

			/*
			 * WebElement floorExposedPerimeter =
			 * driver.findElement(By.id("ExposedPerimeter")); if
			 * (floorExposedPerimeter.isEnabled()) {
			 * floorExposedPerimeter.sendKeys(vList.get(6)); }
			 * 
			 * WebElement floorExposedWallArea =
			 * driver.findElement(By.id("ExposedWallArea")); if
			 * (floorExposedWallArea.isEnabled()) {
			 * floorExposedWallArea.sendKeys(vList.get(7)); }
			 */

			WebElement element = driver.findElement(By.id("UValue"));

			if (element.isDisplayed() && element.isEnabled()) {

				driver.findElement(By.id("UValue")).clear();

				driver.findElement(By.id("UValue")).sendKeys(floorLocationID.get(i).get("UValue").toString());
			} else {
				System.out.println("NO ! Element is not enabled");
			}

			WebElement exposedPerimeter = driver.findElement(By.id("ExposedPerimeter"));

			if (exposedPerimeter.isDisplayed() && exposedPerimeter.isEnabled()) {

				driver.findElement(By.id("ExposedPerimeter")).clear();

				driver.findElement(By.id("ExposedPerimeter"))
						.sendKeys(floorLocationID.get(i).get("ExposedPerimeter").toString());
			} else {
				System.out.println("NO ! Element is not enabled");
			}

			/*
			 * checkbox how to handle if
			 * (floorLocationID.get(0).get("UnderFloorHeating").toString().trim().
			 * equalsIgnoreCase("true")) { Check(underFloorHeatingbox);
			 * 
			 * } else { UnCheck(underFloorHeatingbox); }
			 * 
			 */
			/*
			 * 
			 * if (UnCheck(underFloorHeating)) { underFloorHeating.click();
			 * waitForAngularPageToLoad(); }
			 */
			WebElement inRoof = driver.findElement(By.name("InRoof"));

			/*
			 * if (!inRoof.isSelected()) { inRoof.click(); waitForAngularPageToLoad(); }
			 */

			driver.findElement(By.xpath("//button/span[contains(text(),'Save')]")).click();
			waitForAngularPageToLoad();
		}
	}

	@Given("user enters Building details")
	public void user_enters_building_details(io.cucumber.datatable.DataTable dataTable) {
		waitForAngularPageToLoad();

		Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(By.xpath("//a[contains(@href,'/building')]"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();
	}

	@And("^user have to enter survey details$")
	public void user_have_to_enter_survey_details(io.cucumber.datatable.DataTable dataTable) {
		driver.findElement(By.id("MPRN")).click();
		waitForAngularPageToLoad();
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		System.out.println("Data file from list :" + data);
		// System.out.println("json value:",SuiteConstants.jsonString.toString());
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());
		System.out.println("json value:" + json);
		Object mprn = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("MPRN"));
		String mprnValue = mprn.toString().trim();
		System.out.println("mprnValue:" + mprnValue);

		// driver.findElement(By.name("MPRN")).sendKeys(convertFromScientificNotation(mprnValue));

		driver.findElement(By.name("MPRN")).sendKeys(mprnValue);

		waitForAngularPageToLoad();
		Actions actions = new Actions(driver);
		// WebElement subMenu =
		// driver.findElement(By.xpath("//li//span[contains(text(),'" +
		// Address.toString() + "')]"));
		WebElement subMenu = driver.findElement(By.xpath("//span[@class='mat-option-text']/span"));

		System.out.println("Address dropdown:" + subMenu);
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		waitForAngularPageToLoad();
		Object dwellingDescription = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("DwellingDescription"));

		Object year = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Year"));

		sleep(2000);
		Object bERCurrent = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("BERCurrent"));

		String bERCurrentValue = bERCurrent.toString();

		driver.findElement(By.name("BERCurrent")).click();
		driver.findElement(By.name("BERCurrent")).clear();
		driver.findElement(By.name("BERCurrent")).sendKeys(bERCurrentValue);

		waitForAngularPageToLoad();

		Object eircode = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Eircode"));

		selectByTextFromDropdown(driver.findElement(By.id("DwellingTypeIDContainer")),
				By.xpath("//span[@class='mat-option-text'][contains(text(),'" + dwellingDescription + "')]"));

		driver.findElement(By.id("Year")).click();
		driver.findElement(By.id("Year")).clear();

		driver.findElement(By.id("Year")).sendKeys(year.toString());

		driver.findElement(By.name("Eircode")).click();
		driver.findElement(By.name("Eircode")).clear();
		driver.findElement(By.name("Eircode")).sendKeys(eircode.toString());

		waitForAngularPageToLoad();

		driver.findElement(By.xpath("//span[text()=' Continue ']")).click();
		waitForAngularPageToLoad();		
	}

	@Then("user have to enter survey details popup")
	public void user_have_to_enter_survey_details_popup(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object typeOfRating = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Type of rating"));
		driver.findElement(By.name("RatingTypeID")).click();
		waitForAngularPageToLoad();
		driver.findElement(By.xpath("//div[@id='RatingTypeID-panel']//span[contains(text(),'" + typeOfRating + "')]"))
				.click();
		// driver.findElement(By.xpath("//div[text()='" + typeOfRating + "']")).click();
		waitForAngularPageToLoad();
		driver.findElement(By.name("RatingPurposeID")).click();
		waitForAngularPageToLoad();
		Object RatingPurposeID = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Purpose"));

		driver.findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'" + RatingPurposeID + "')]"))
				.click();

		waitForAngularPageToLoad();

		Object BuildingRegulations = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Regulation"));

		System.out.println("BuildingRegulations Value" + BuildingRegulations);

		selectByTextFromDropdown(driver.findElement(By.name("BuildingRegsID")),
				By.xpath("//mat-option[@ref-value='" + BuildingRegulations + "']"));

		// if (!BuildingRegulations.toString().trim().equals("None")) {
		// driver.findElement(By.xpath("//app-form-field[@label='Building
		// Regulations']")).click();
		// sleep(5000);
		// driver.findElement(By.xpath("//span[contains(text(),'" + BuildingRegulations
		// + "')]")).click();
		waitForAngularPageToLoad();

		// }
		Object Description = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Description"));

		driver.findElement(By.name("Description")).sendKeys(Description.toString());
		waitForAngularPageToLoad();
		driver.findElement(By.xpath("//button/span[contains(text(),'Start Survey')]")).click();
		sleep(2000);
	}

	
	public void clicks_add_roof_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		driver.findElement(By.id("roofs-tab")).click();

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object roofTypeObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Roof"));

		List<HashMap<String, Object>> roofTypeList = JsonUtils.getJsonArrayValueAsListOfMap(roofTypeObject);

		for (int i = 0; i < roofTypeList.size(); i++) {

			driver.findElement(By.xpath("//span[contains(text(),'Add Roof')]")).click();

			waitForAngularPageToLoad();
			String roofTypeValue = String.valueOf(roofTypeList.get(i).get(data.get(0).get("RoofType"))).trim();
			System.out.println("roofTypeValue" + roofTypeValue);
			selectByTextFromDropdown(driver.findElement(By.name("TGDLRoofTypeId")),
					By.xpath("//mat-option/span[contains(text(),'" + roofTypeValue + "')]"));

			waitForAngularPageToLoad();
			System.out.println("roof type list" + roofTypeList.get(i));

			String description = String.valueOf(roofTypeList.get(i).get(data.get(0).get("Description"))).trim();
			if (!description.trim().toLowerCase().equals("null")) {
				driver.findElement(By.id("Description")).clear();

				driver.findElement(By.id("Description")).sendKeys(description);

			}

			String insulation = String.valueOf(roofTypeList.get(i).get(data.get(0).get("Insulation"))).trim();

			System.out.println("Insulation : " + insulation);

			if (!insulation.trim().toLowerCase().equals("null")) {

				waitForAngularPageToLoad();

				selectByTextFromDropdown(driver.findElement(By.id("Insulation")),
						By.xpath("//mat-option[@ref-value='" + insulation + "']"));

			}

			String ageBand = String.valueOf(roofTypeList.get(i).get(data.get(0).get("AgeBand"))).trim();
			String[] ageBandList = ageBand.split(" ");
			System.out.println("age Band List:" + ageBandList[0]);

			System.out.println("Age Band:" + ageBand);

			String area = String.valueOf(roofTypeList.get(i).get(data.get(0).get("Area"))).trim();
			String uValue = String.valueOf(roofTypeList.get(i).get(data.get(0).get("UValue"))).trim();
			driver.findElement(By.id("Area")).clear();
			driver.findElement(By.id("Area")).sendKeys(area);

			driver.findElement(By.id("UValue")).clear();
			driver.findElement(By.id("UValue")).sendKeys(uValue);
			waitForAngularPageToLoad();

			driver.findElement(By.xpath("//button/span[contains(text(),'Save')]")).click();
			waitForAngularPageToLoad();

		}
		waitForAngularPageToLoad();
	}

	
	public void clicks_add_wall_s_details(io.cucumber.datatable.DataTable dataTable) {

		driver.findElement(By.id("walls-tab")).click();
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object wallTypeObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Wall"));

		List<HashMap<String, Object>> wallTypeList = JsonUtils.getJsonArrayValueAsListOfMap(wallTypeObject);

		for (int i = 0; i < wallTypeList.size(); i++) {
			driver.findElement(By.xpath("//span[contains(text(),'Add Wall')]")).click();
			waitForAngularPageToLoad();
			String wallTypeValue = String.valueOf(wallTypeList.get(i).get(data.get(0).get("WallType"))).trim();
			System.out.println("wallTypeValue" + wallTypeValue);
			/*
			 * selectByTextFromDropdown(driver.findElement(By.id("WallTypeID")),
			 * By.xpath("//span[contains(text(),'" + wallTypeValue + "')]"));
			 */

			selectByTextFromDropdown(driver.findElement(By.id("WallTypeID")),
					By.xpath("//mat-option[@ref-value='" + wallTypeValue + "']"));

			waitForAngularPageToLoad();

			// selectByTextFromDropdown(driver.findElement(By.name("WallType")),
			// wallTypeValue);

			System.out.println("wall type list" + wallTypeList.get(i));
			String description = String.valueOf(wallTypeList.get(i).get(data.get(0).get("Description"))).trim();
			System.out.println("description from json" + description);
			if (!description.trim().toLowerCase().equals("null")) {
				driver.findElement(By.id("Description")).clear();

				driver.findElement(By.id("Description")).sendKeys(description);

			}
			String ageWBand = String.valueOf(wallTypeList.get(i).get(data.get(0).get("AgeBandID"))).trim();
			String[] ageBandList = ageWBand.split(" ");
			System.out.println("age Band List:" + ageBandList[0]);

			System.out.println("Age Band:" + ageWBand);

			selectByTextFromDropdown(
					driver.findElement(By.xpath("//*[@id='AgeBandID' and @aria-required='true']")),
					By.xpath("//mat-option[@ref-value='" + ageWBand + "']"));

			// selectByTextFromDropdown(driver.findElement(By.name("AgeBandID")),By.xpath("//span[contains(text(),'"
			// + ageBandList + "')]"));

			String area = String.valueOf(wallTypeList.get(i).get(data.get(0).get("Area"))).trim();
			String uValue = String.valueOf(wallTypeList.get(i).get(data.get(0).get("UValue"))).trim();

			driver.findElement(By.id("Area")).clear();
			driver.findElement(By.id("Area")).sendKeys(area);

			String wallinSemiExposedCheckboxValue = String
					.valueOf(wallTypeList.get(i).get(data.get(0).get("SemiExposed"))).trim();

			if (!(wallinSemiExposedCheckboxValue.trim().equalsIgnoreCase("null"))) {
				WebElement wallinSemiExposedCheckbox = driver.findElement(By.name("SemiExposed"));
				checkOrUncheck(wallinSemiExposedCheckbox, wallinSemiExposedCheckboxValue);
			}

			driver.findElement(By.id("UValue")).clear();
			driver.findElement(By.id("UValue")).sendKeys(uValue);
			waitForAngularPageToLoad();
			driver.findElement(By.xpath("//button/span[contains(text(),'Save')]")).click();
			waitForAngularPageToLoad();

		}
		waitForAngularPageToLoad();

		/*
		 * 
		 * 
		 * List<List<String>> lists = dataTable.asLists(String.class); for (int i = 1; i
		 * < lists.size(); i++) {
		 * driver.findElement(By.xpath("//md-tab-item[contains(text(),'WALLS')]")).click
		 * (); sleep(5000); driver.findElement(By.id("AddWallBtn")).click();
		 * sleep(5000);
		 * 
		 * List<String> vList = lists.get(i);
		 * 
		 * selectByTextFromDropdown(driver.findElement(By.name("WallType")), By.xpath(
		 * "//md-option[contains(@ng-repeat,'bwd.refData.building.WallType')]/div"),
		 * vList.get(0)); sleep(2000);
		 * selectByTextFromDropdown(driver.findElement(By.name("WallAgeBandID")),
		 * By.xpath(
		 * "//md-option[contains(@ng-repeat,'bwd.refData.building.AgeBand')]/div"),
		 * vList.get(1)); driver.findElement(By.name("WallDescription")).clear();
		 * driver.findElement(By.name("WallDescription")).sendKeys(vList.get(2));
		 * 
		 * driver.findElement(By.name("wallArea")).clear();
		 * driver.findElement(By.name("wallArea")).sendKeys(vList.get(3));
		 * 
		 * WebElement includeComplianceCheckbox = driver
		 * .findElement(By.xpath("//md-checkbox[@ng-model='bwd.wall.ComplianceCheck']"))
		 * ;
		 * 
		 * if (UnCheck(includeComplianceCheckbox)) { includeComplianceCheckbox.click();
		 * sleep(2000); }
		 * 
		 * WebElement includeSemiExposedCheckbox = driver
		 * .findElement(By.xpath("//md-checkbox[@ng-model='bwd.wall.SemiExposed']"));
		 * 
		 * if (UnCheck(includeSemiExposedCheckbox)) {
		 * includeSemiExposedCheckbox.click(); sleep(2000); }
		 * driver.findElement(By.name("wallUValue")).clear();
		 * driver.findElement(By.name("wallUValue")).sendKeys(vList.get(6));
		 * sleep(5000);
		 * driver.findElement(By.xpath("//button/span[text()='Save']")).click();
		 * sleep(5000);
		 * 
		 * }
		 * 
		 * 
		 */
	}

	@Then("user selects new  Lib Iteam Rooms")
	public void user_selects_new_lib_iteam_rooms(io.cucumber.datatable.DataTable dataTable) {

	}

	@Then("clicks add Door details")
	public void clicks_add_Door_details(io.cucumber.datatable.DataTable dataTable) {
		// driver.findElement(By.xpath("//md-tab-item[contains(text(),'DOORS')]")).click();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object doorObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("AddDoorCommonItem"));
		System.out.println("door object:" + doorObject);
		List<HashMap<String, Object>> doorlist = JsonUtils.getJsonArrayValueAsListOfMap(doorObject);
		System.out.println("door list:" + doorlist);
		// for (int i = 0; i < doorlist.size(); i++) {

		for (int i = 0; i < doorlist.size(); i++) {

			JSONObject libItem = new JSONObject(doorlist.get(i).get(data.get(0).get("LibraryItem")).toString());
			Object libObject = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("MarketingName"));

			String marketingNameValue = String.valueOf(libObject.toString()).trim();

			driver.findElement(By.id("AddDoorBtn")).click();
			waitForAngularPageToLoad();

			driver.findElement(By.xpath("//div/h3/span[contains(text(),'" + marketingNameValue + "')]")).click();
			waitForAngularPageToLoad();

			driver.findElement(By.xpath("//button[@aria-label='Add Selected Items']")).click();
			waitForAngularPageToLoad();

		}

	}

	
	public void user_selects_new_lib_iteam_doort(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		driver.findElement(By.id("doors-tab")).click();
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object doorObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Doors"));
		System.out.println("door Object:" + doorObject);

		List<HashMap<String, Object>> doorlist = JsonUtils.getJsonArrayValueAsListOfMap(doorObject);
		System.out.println("Door list:" + doorlist);

		for (int i = 0; i < doorlist.size(); i++) {
			JSONObject libItem = new JSONObject(doorlist.get(i).get(data.get(0).get("LibraryItem")).toString());
			Object libObject = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("LibraryItemTypeID"));
			Object libItemDoor = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("LibraryItemDoor"));
			Object libItemDraughtStripped = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("DraughtStripped"));

			System.out.println("libItem Door:" + libItemDoor);

			String libraryItemTypeIDValue = String.valueOf(libObject.toString()).trim();
			System.out.println("libraryItemTypeID  Value" + libraryItemTypeIDValue);

			if (libraryItemTypeIDValue.equalsIgnoreCase("Door") || libraryItemTypeIDValue.equalsIgnoreCase("2")) {
				driver.findElement(By.xpath("//span[contains(text(),'Add Door')]")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]")).click();
				waitForAngularPageToLoad();
				// go drop down and xpath
				selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
						By.xpath("//mat-option/span[contains(text(),'Door')]"));

				// selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
				// By.xpath("//md-option[contains(@ng-repeat,'cli.refData.library.ItemTypes')
				// and @value='"
				// + libraryItemTypeIDValue.trim() + "']"));
				waitForAngularPageToLoad();

				String marketingName = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "MarketingName").toString();

				if (!marketingName.trim().toLowerCase().equals("null")) {

					driver.findElement(By.id("MarketingName")).clear();

					driver.findElement(By.id("MarketingName")).sendKeys(marketingName);
					waitForAngularPageToLoad();
				}
				String manufacturer = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Manufacturer").toString();

				if (!manufacturer.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("Manufacturer")).clear();

					driver.findElement(By.id("Manufacturer")).sendKeys(manufacturer);
					waitForAngularPageToLoad();
				}
				String model = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
						.toString();

				if (!model.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("Model")).clear();

					driver.findElement(By.id("Model")).sendKeys(model);
					waitForAngularPageToLoad();
				}

				String doorAreaValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemDoor.toString()), "DoorArea").toString();

				String uValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemDoor.toString()), "UValue").toString();

				driver.findElement(By.id("DoorArea")).clear();
				driver.findElement(By.id("DoorArea")).sendKeys(doorAreaValue);
				waitForAngularPageToLoad();

				driver.findElement(By.id("UValue")).clear();
				driver.findElement(By.id("UValue")).sendKeys(uValue);
				waitForAngularPageToLoad();

				/*
				 * String draughtStrippedCheckboxValue = String
				 * .valueOf(wallTypeList.get(i).get(data.get(0).get("DraughtStripped"))).trim();
				 */

				String draughtStrippedCheckboxValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemDoor.toString()), "DraughtStripped")
						.toString();

				if (!(draughtStrippedCheckboxValue.trim().equalsIgnoreCase("null"))) {
					WebElement draughtStrippedCheckbox = driver.findElement(By.name("DraughtStripped"));
					checkOrUncheck(draughtStrippedCheckbox, draughtStrippedCheckboxValue);
				}

				// check box property go
				/*
				 * WebElement draughtStripped =
				 * driver.findElement(By.id("LibraryDoorDraughtStripped"));
				 * 
				 * 
				 * asdas if
				 * (libItemDraughtStripped.get(i).get("DraughtStripped").toString().trim().
				 * equalsIgnoreCase("true")) { Check(draughtStripped);
				 * 
				 * } else { UnCheck(draughtStripped); }
				 */

				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//button/span/span[text()='Save']")).click();
				waitForAngularPageToLoad();

				List<WebElement> mNameList = driver
						.findElements(By.xpath("//span[contains(text(),'" + marketingName + "')]"));

				System.out.println("marketingName:" + marketingName);
				mNameList.get(mNameList.size() - 1).click();
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();

			} else {
				continue;

			}
		}
	}

	
	public void user_selects_new_lib_iteam_door(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		driver.findElement(By.id("doors-tab")).click();

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object doorObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Doors"));
		System.out.println("door Object:" + doorObject);

		List<HashMap<String, Object>> doorlist = JsonUtils.getJsonArrayValueAsListOfMap(doorObject);
		System.out.println("door list:" + doorlist);

		for (int i = 0; i < doorlist.size(); i++) {
			JSONObject libItem = new JSONObject(doorlist.get(i).get(data.get(0).get("LibraryItem")).toString());
			Object libObject = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("LibraryItemTypeID"));

			JSONObject libItemType = new JSONObject(doorlist.get(i).get(data.get(0).get("LibraryItemType")).toString());
			Object libItemTypeDescObject = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("LibraryItemTypeDescription"));

			Object libraryItemDoorObj = JsonUtils.getNestedJsonStringValueByKey(json,
					data.get(0).get("LibraryItemDoor"));
			System.out.println("libraryItemDoor Obj:" + libraryItemDoorObj);

			/*
			 * Object libItemType = JsonUtils.getNestedJsonStringValueByKey(libItem,
			 * data.get(0).get("libItemTypeDescription"));
			 * 
			 * Object libItemTypeDescription =
			 * JsonUtils.getNestedJsonStringValueByKey(libItemType,
			 * data.get(0).get("libItemTypeDescription"));
			 * 
			 * Object libItemTypeDescription =
			 * JsonUtils.getNestedJsonStringValueByKey(libItemType,
			 * data.get(0).get("libItemTypeDescription"));
			 */
			String libraryItemTypeIDValue = String.valueOf(libObject.toString()).trim();
			System.out.println("libraryItemTypeID  Value" + libraryItemTypeIDValue);

			String libItemTypeDescriptionValue = String.valueOf(libItemTypeDescObject.toString()).trim();
			System.out.println("libItemTypeDescription Value:" + libItemTypeDescriptionValue);

			if (libItemTypeDescriptionValue.equalsIgnoreCase("Door") || libraryItemTypeIDValue.equalsIgnoreCase("2"))

			{

				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[contains(text(),'Add Door')]")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]")).click();
				waitForAngularPageToLoad();

				String marketingName = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "MarketingName").toString();

				if (!marketingName.trim().toLowerCase().equals("null")) {

					driver.findElement(By.name("MarketingName")).clear();

					driver.findElement(By.name("MarketingName")).sendKeys(marketingName);
					waitForAngularPageToLoad();

				}
				String keyWords = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "AssessorKeywords")
						.toString();

				if (!keyWords.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("AssessorKeywords")).clear();

					driver.findElement(By.id("AssessorKeywords")).sendKeys(keyWords);
					waitForAngularPageToLoad();
				}

				String manufacturer = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Manufacturer").toString();

				if (!manufacturer.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("Manufacturer")).clear();

					driver.findElement(By.id("Manufacturer")).sendKeys(manufacturer);
					waitForAngularPageToLoad();
				}
				String model = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
						.toString();
				waitForAngularPageToLoad();
				if (!model.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("Model")).clear();

					driver.findElement(By.id("Model")).sendKeys(model);
					waitForAngularPageToLoad();
				}

				/*
				 * selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),By.
				 * xpath("//mat-option[contains(@ng-repeat,'cli.refData.library.ItemTypes') and @value='"
				 * + libraryItemTypeIDValue.trim() + "']"));
				 * 
				 */
				// need to write code to secte "LibraryItemTypeDescription": "Door"

				// selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),By.xpath("//mat-option/span
				// and @value='" + libraryItemTypeIDValue.trim() + "']"));

				System.out.println("libItemTypeDescription Value:" + libItemTypeDescriptionValue);

				// go drop down

				if (!libItemTypeDescriptionValue.trim().toLowerCase().equals("Door")) {

					selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
							By.xpath("//mat-option/span[contains(text(),' " + libItemTypeDescriptionValue + "')]"));

					waitForAngularPageToLoad();

					String drArea = JsonUtils
							.getNestedJsonStringValueByKey(new JSONObject(libraryItemDoorObj.toString()), "DoorArea")
							.toString();

					if (!drArea.trim().toLowerCase().equals("null")) {
						driver.findElement(By.id("DoorArea")).clear();

						driver.findElement(By.id("DoorArea")).sendKeys(drArea);
						waitForAngularPageToLoad();
					}
					String uValue = JsonUtils
							.getNestedJsonStringValueByKey(new JSONObject(libraryItemDoorObj.toString()), "UValue")
							.toString();

					driver.findElement(By.id("UValue")).sendKeys(uValue);

					waitForAngularPageToLoad();
				}

				driver.findElement(By.xpath("//button/span/span[text()='Save']")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[text()='" + marketingName + "']")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();

			} else {
				continue;

			}
		}
	}

	
	public void user_selects_new_lib_iteam_windows(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		driver.findElement(By.id("windows-tab")).click();
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object windowObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Windows"));
		System.out.println("window Object:" + windowObject);

		List<HashMap<String, Object>> windowlist = JsonUtils.getJsonArrayValueAsListOfMap(windowObject);
		System.out.println("window list:" + windowlist);

		// for (int i = 0; i < windowlist.size(); i++) {

		for (int i = 0; i < windowlist.size(); i++) {
			JSONObject libItem = new JSONObject(windowlist.get(i).get(data.get(0).get("LibraryItem")).toString());
			Object libObject = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("LibraryItemTypeID"));
			Object libItemWindow = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("Glazing"));

			System.out.println("libItemWindow Glazing:" + libItemWindow);

			String libraryItemTypeIDValue = String.valueOf(libObject.toString()).trim();
			System.out.println("libraryItemTypeID  Value" + libraryItemTypeIDValue);

			if (libraryItemTypeIDValue.equalsIgnoreCase("Window") || libraryItemTypeIDValue.equalsIgnoreCase("1"))

			{

				sleep(2000);
				driver.findElement(By.xpath("//span[contains(text(),'Add Window')]")).click();
				waitForAngularPageToLoad();
				sleep(2000);

				driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]")).click();
				waitForAngularPageToLoad();
				// go drop down and xpath
				selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
						By.xpath("//mat-option/span[contains(text(),'Window')]"));

				// selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
				// By.xpath("//md-option[contains(@ng-repeat,'cli.refData.library.ItemTypes')
				// and @value='"
				// + libraryItemTypeIDValue.trim() + "']"));
				waitForAngularPageToLoad();

				String marketingName = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "MarketingName").toString();

				if (!marketingName.trim().toLowerCase().equals("null")) {

					driver.findElement(By.id("MarketingName")).clear();

					driver.findElement(By.id("MarketingName")).sendKeys(marketingName);
					waitForAngularPageToLoad();

				}

				String keyWords = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "AssessorKeywords")
						.toString();

				if (!keyWords.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("AssessorKeywords")).clear();

					driver.findElement(By.id("AssessorKeywords")).sendKeys(keyWords);
					waitForAngularPageToLoad();
				}

				String manufacturer = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Manufacturer").toString();

				if (!manufacturer.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("Manufacturer")).clear();

					driver.findElement(By.id("Manufacturer")).sendKeys(manufacturer);
					waitForAngularPageToLoad();
				}
				String model = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
						.toString();

				if (!model.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("Model")).clear();

					driver.findElement(By.id("Model")).sendKeys(model);
					waitForAngularPageToLoad();
				}
				// go xpath for window detail and check the flow

				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//div[contains(text(),'Window Details')]")).click();

				waitForAngularPageToLoad();
				/*
				 * String oValue = JsonUtils .getNestedJsonStringValueByKey(new
				 * JSONObject(libItemWindow.toString()), "Openings").toString();
				 * 
				 * driver.findElement(By.name("Openings")).sendKeys(oValue);
				 * waitForAngularPageToLoad();
				 * 
				 * String dValue = JsonUtils.getNestedJsonStringValueByKey(new
				 * JSONObject(libItemWindow.toString()), "DraughtStrippedOpenings").toString();
				 * 
				 * driver.findElement(By.name("DraughtStrippedOpenings")).sendKeys(dValue);
				 * waitForAngularPageToLoad();
				 */

				String gtValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "GlazingTypeID")
						.toString();

				String glazingTypeIDObject = JsonUtils.getNestedJsonStringValueByKey(
						new JSONObject(libItemWindow.toString()), "GlazingType.GlazingTypeID").toString();

				selectByTextFromDropdown(driver.findElement(By.name("GlazingTypeID")),
						By.xpath("//mat-option[@ref-value='" + glazingTypeIDObject + "']"));

				String FType = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "FrameFactorID")
						.toString();

				waitForAngularLoad();
				selectByTextFromDropdown(driver.findElement(By.id("FrameFactorID")),
						By.xpath("//mat-option[@ref-value='" + FType + "']"));

				/*
				 * selectByTextFromDropdown(driver.findElement(By.name("FrameFactorID")), By.
				 * xpath("//md-option[contains(@ng-repeat,'cli.refData.window.FrameFactor') and @value='"
				 * + FType.trim() + "']"));
				 */
				waitForAngularPageToLoad();

				/*
				 * String gType=JsonUtils.getNestedJsonStringValueByKey(new
				 * JSONObject(libItemWindow.toString()), "GapID").toString();
				 * 
				 * 
				 * selectByTextFromDropdown(driver.findElement(By.name("GapID")), By.
				 * xpath("//md-option[contains(@ng-repeat,'cli.refData.window.GapType') and @value='"
				 * +gType.trim()+"']"));
				 * 
				 * sleep(2000);
				 */

				String ffValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "FrameFactorValue")
						.toString();
				driver.findElement(By.id("FrameFactorValue")).clear();
				driver.findElement(By.id("FrameFactorValue")).sendKeys(ffValue);
				waitForAngularPageToLoad();

				String uValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "UValue").toString();

				driver.findElement(By.id("UValue")).sendKeys(uValue);
				waitForAngularPageToLoad();

				String libraryWindowRoofWindowCheckbox = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "RoofWindow")
						.toString();

				if (!(libraryWindowRoofWindowCheckbox.trim().equalsIgnoreCase("null"))) {
					WebElement roofWindowCheckbox = driver.findElement(By.name("RoofWindow"));
					checkOrUncheck(roofWindowCheckbox, libraryWindowRoofWindowCheckbox);
				}
				String stValue = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()),
						"SolarEnergyTransmittance").toString();

				driver.findElement(By.id("SolarEnergyTransmittance")).sendKeys(stValue);
				waitForAngularPageToLoad();

				// driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
				// waitForAngularPageToLoad();
				String bType = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "BlindID").toString();

				/*
				 * selectByTextFromDropdown(driver.findElement(By.id("BlindID")), By.
				 * xpath("//md-option[contains(@ng-repeat,'cli.refData.window.BlindType') and @value='"
				 * + bType.trim() + "']"));
				 */

				waitForAngularPageToLoad();

				String oHType = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "OverhangID")
						.toString();

				/*
				 * selectByTextFromDropdown(driver.findElement(By.id("OverhangID")), By.
				 * xpath("//md-option[contains(@ng-repeat,'cli.refData.window.OverhangType') and @value='"
				 * + oHType.trim() + "']"));
				 */

				waitForAngularPageToLoad();

				String odRatio = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "OverhangDepthID")
						.toString();

				/*
				 * if (!odRatio.trim().toLowerCase().equals("null")) {
				 * 
				 * 
				 * selectByTextFromDropdown(driver.findElement(By.id("OverhangDepthID")),
				 * By.xpath(
				 * "//md-option[contains(@ng-repeat,'cli.refData.window.OverhangDepthRatio') and @value='"
				 * + odRatio.trim() + "']")); }
				 */

				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//button/span/span[text()='Save']")).click();
				waitForAngularPageToLoad();
				sleep(2000);

				List<WebElement> marketingNameList = driver
						.findElements(By.xpath("//span[text()='" + marketingName + "']"));

				System.out.println("marketingName:" + marketingNameList);
				marketingNameList.get(marketingNameList.size() - 1).click();

				// driver.findElement(By.xpath("//span[text()='"+ marketingName +"']")).click();

				waitForAngularPageToLoad();
				sleep(5000);

				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();
				sleep(11000);
				String areaValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "Area").toString();
				driver.findElement(By.id("Area")).click();
				driver.findElement(By.id("Area")).clear();
				driver.findElement(By.id("Area")).sendKeys(areaValue);
				waitForAngularPageToLoad();

				String oHId = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()),
						"WindowOrientation.OrientationID").toString();

				selectByTextFromDropdown(driver.findElement(By.id("OrientationID")),
						By.xpath("//mat-option[@ref-value='" + oHId + "']"));

				waitForAngularPageToLoad();

				String oShId = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()),
						"WindowOvershading.OvershadingID").toString();

				selectByTextFromDropdown(driver.findElement(By.id("OvershadingID")),
						By.xpath("//mat-option[@ref-value='" + oShId + "']"));

				waitForAngularPageToLoad();
				/*
				 * By.
				 * xpath("//md-option[contains(@ng-repeat,'sid.refData.window.WindowOvershading') and @value='"
				 * + oShId.trim() + "']"));
				 */

				String openingsValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItemWindow.toString()), "Openings").toString();
				driver.findElement(By.id("Openings")).click();
				driver.findElement(By.id("Openings")).clear();
				driver.findElement(By.id("Openings")).sendKeys(openingsValue);
				waitForAngularPageToLoad();

				String draughtStrippedOpeningsValue = JsonUtils.getNestedJsonStringValueByKey(
						new JSONObject(libItemWindow.toString()), "DraughtStrippedOpenings").toString();

				driver.findElement(By.id("DraughtStrippedOpenings")).clear();
				driver.findElement(By.id("DraughtStrippedOpenings")).sendKeys(draughtStrippedOpeningsValue);
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				sleep(3000);
				waitForAngularPageToLoad();
			} else {
				continue;
			}

			/*
			 * driver.findElement(By.xpath("//div/h3/span[contains(text(),'" +
			 * libraryItemTypeIDValue + "')]")).click();
			 * addedVentilationList.put(libraryItemTypeIDValue, windowlist.get(i));
			 * 
			 * driver.findElement(By.xpath("//md-tab-item[contains(text(),'WINDOWS')]")).
			 * click();
			 * 
			 * driver.findElement(By.xpath("//button/span[text()='Add']")).click();
			 * sleep(5000);
			 */

		}

	}

	@Then("clicks add window details")
	public void clicks_add_window_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyItemsObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("NoOfItems"));
		System.out.println("SurveyItemsObject:" + surveyItemsObject);
		List<HashMap<String, Object>> windowList = JsonUtils.getJsonArrayValueAsListOfMap(surveyItemsObject);
		System.out.println("window list:" + windowList);

		for (int i = 0; i < windowList.size(); i++) {
			JSONObject winItem = new JSONObject(windowList.get(i).get(data.get(0).get("LibraryItem")).toString());

			Object libWindowObject = JsonUtils.getNestedJsonStringValueByKey(winItem, "LibraryItemWindow");

			String libWindowValue = String.valueOf(libWindowObject.toString()).trim();
			if (!libWindowValue.equals("null")) {

				driver.findElement(By.name("Number")).clear();
				driver.findElement(By.name("Number")).sendKeys(windowList.get(0).get("Number").toString());

				// selectByTextFromDropdown(driver.findElement(By.xpath("//md-select[contains(@ng-model,'sid.item.RoomID')]")),
				// By.xpath("//md-option[contains(@ng-repeat,'sid.data.surveyDetails.SurveyRooms')]"),
				// vList.get(1));
				// sleep(2000);

				driver.findElement(By.name("Description")).clear();
				driver.findElement(By.name("Description")).sendKeys(windowList.get(0).get("Description").toString());

				Object areaObject = JsonUtils.getNestedJsonStringValueByKey(winItem, data.get(0).get("Area"));

				String areaValue = String.valueOf(areaObject.toString()).trim();

				driver.findElement(By.name("Area")).clear();
				driver.findElement(By.name("Area")).sendKeys(areaValue);

				Object orientationObject = JsonUtils.getNestedJsonStringValueByKey(winItem,
						data.get(0).get("Orientation"));

				String orientationValue = String.valueOf(orientationObject.toString()).trim();

				selectByTextFromDropdown(driver.findElement(By.xpath(
						"//md-select[contains(@ng-model,'sid.item.LibraryItem.LibraryItemWindow.OrientationID')]")),
						By.xpath("//md-option[contains(@ng-repeat,'sid.refData.window.WindowOrientations')]"),
						orientationValue);
				Object uVObject = JsonUtils.getNestedJsonStringValueByKey(winItem, data.get(0).get("UValue"));

				String uVValue = String.valueOf(uVObject.toString()).trim();

				driver.findElement(By.name("UValue")).clear();
				driver.findElement(By.name("UValue")).sendKeys(uVValue);

				Object overShadingObject = JsonUtils.getNestedJsonStringValueByKey(winItem,
						data.get(0).get("OverShading"));

				String overShadingValue = String.valueOf(overShadingObject.toString()).trim();

				selectByTextFromDropdown(driver.findElement(By.xpath(
						"//md-select[contains(@ng-model,'sid.item.LibraryItem.LibraryItemWindow.OvershadingID')]")),
						By.xpath("//md-option[contains(@ng-repeat,'sid.refData.window.WindowOvershading')]"),
						overShadingValue);

				driver.findElement(By.xpath("//button[@aria-label='Save']")).click();
				sleep(2000);
				break;

			}

		}

	}

	@Then("clicks add Rooms details")
	public void clicks_add_rooms_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {

			driver.findElement(By.xpath("//md-tab-item[contains(text(),'ROOMS')]")).click();
			sleep(5000);
			driver.findElement(By.id("AddRoomBtn")).click();
			sleep(5000);

			List<String> vList = lists.get(i);
			selectByTextFromDropdown(driver.findElement(By.name("RoomTypeID")), vList.get(0));
			sleep(2000);
			selectByTextFromDropdown(driver.findElement(By.name("FloorNumber")), vList.get(1));
			sleep(2000);

			driver.findElement(By.name("RoomName")).clear();
			driver.findElement(By.name("RoomName")).sendKeys(vList.get(2));
			sleep(5000);
			driver.findElement(By.xpath("//button/span[text()='Save']")).click();
			sleep(5000);
		}
	}

	@Then("user selects {string} door")
	public void user_selects_solid_exposed_door_door(String CommonItems) {
		driver.findElement(By.xpath("//md-tab-item[contains(text(),'DOORS')]")).click();
		sleep(5000);
		driver.findElement(By.id("AddDoorBtn")).click();
		sleep(5000);

		driver.findElement(By.xpath("//div/h3/span[contains(text(),'" + CommonItems + "')]")).click();

		sleep(2000);

		driver.findElement(By.xpath("//button[@aria-label='Add Selected Items']")).click();
		sleep(5000);

	}

	@Then("user selects {string} Windows")
	public void user_selects_windows(String doubleAir) {
		sleep(2000);
		driver.findElement(By.xpath("//md-tab-item[contains(text(),'WINDOWS')]")).click();
		sleep(5000);
		driver.findElement(By.id("AddWindowBtn")).click();
		sleep(5000);

		driver.findElement(By.xpath("//span[contains(text(),'" + doubleAir + "')]")).click();
		sleep(3000);

		driver.findElement(By.xpath("//button/span[text()='Add']")).click();
		sleep(5000);

	}

	@Then("clicks Global Factors add Global Factors details")
	public void clicks_global_factors_add_global_factors_details(io.cucumber.datatable.DataTable dataTable) {

		sleep(2000);
		driver.findElement(By.id("global-factors-tab")).click();

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyBGeneralsTypeObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveyBGenerals"));

		List<HashMap<String, Object>> surveyBGeneralsList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveyBGeneralsTypeObject);

		for (int i = 0; i < surveyBGeneralsList.size(); i++) {

			waitForAngularPageToLoad();
			String thermalMassCategoryIDValue = String
					.valueOf(surveyBGeneralsList.get(i).get(data.get(0).get("ThermalMassCategoryID"))).trim();
			System.out.println("ThermalMassCategoryID" + thermalMassCategoryIDValue);

			waitForAngularLoad();
			selectByTextFromDropdown(driver.findElement(By.id("ThermalMassCategoryID")),
					By.xpath("//mat-option[@ref-value='" + thermalMassCategoryIDValue + "']"));
			/*
			 * 
			 * switch (thermalMassCategoryIDValue) { case "2":
			 * selectByTextFromDropdown(driver.findElement(By.name("TGDLRoofTypeId")),
			 * By.xpath("//mat-option/span[contains(text(),'Low')]")); break;
			 * 
			 * case "3":
			 * 
			 * waitForAngularLoad();
			 * selectByTextFromDropdown(driver.findElement(By.name("ThermalMassCategoryID"))
			 * , By.xpath("//mat-option[@ref-value='" + thermalMassCategoryIDValue + "']"));
			 * 
			 * break;
			 * 
			 * case "4":
			 * 
			 * waitForAngularLoad();
			 * selectByTextFromDropdown(driver.findElement(By.name("ThermalMassCategoryID"))
			 * , By.xpath("//mat-option[@ref-value='" + thermalMassCategoryIDValue + "']"));
			 * 
			 * break;
			 * 
			 * case "5":
			 * selectByTextFromDropdown(driver.findElement(By.name("TGDLRoofTypeId")),
			 * By.xpath("//mat-option/span[contains(text(),'Medium-high')]"));
			 * 
			 * break;
			 * 
			 * case "6":
			 * selectByTextFromDropdown(driver.findElement(By.name("TGDLRoofTypeId")),
			 * By.xpath("//mat-option/span[contains(text(),'High')]"));
			 * 
			 * break;
			 * 
			 * }
			 */
			// selectByTextFromDropdown(driver.findElement(By.name("TGDLRoofTypeId")),
			// By.xpath("//mat-option/span[contains(text(),'" + thermalMassCategoryIDValue +
			// "')]"));

			waitForAngularPageToLoad();
			String thermalBridgingFactorIDValue = String
					.valueOf(surveyBGeneralsList.get(i).get(data.get(0).get("ThermalBridgingFactorID"))).trim();
			System.out.println("thermalBridgingFactorIDValue" + thermalBridgingFactorIDValue);

			waitForAngularLoad();
			selectByTextFromDropdown(driver.findElement(By.id("ThermalBridgingFactorID")),
					By.xpath("//mat-option[@ref-value='" + thermalBridgingFactorIDValue + "']"));

			/*
			 * 
			 * switch (thermalBridgingFactorIDValue) { case "1":
			 * selectByTextFromDropdown(driver.findElement(By.name("ThermalBridgingFactorID"
			 * )), By.xpath("//mat-option/span[contains(text(),'Default')]")); break;
			 * 
			 * case "2":
			 * selectByTextFromDropdown(driver.findElement(By.name("ThermalBridgingFactorID"
			 * )), By.xpath(
			 * "//mat-option/span[contains(text(),'Acceptable Construction Details 2008, 2011 and 2019 TGDL')]"
			 * ));
			 * 
			 * break;
			 * 
			 * case "3":
			 * selectByTextFromDropdown(driver.findElement(By.name("ThermalBridgingFactorID"
			 * )), By.
			 * xpath("//mat-option/span[contains(text(),'Building Regulation 2005 TGDL')]"))
			 * ;
			 * 
			 * break;
			 * 
			 * case "4":
			 * selectByTextFromDropdown(driver.findElement(By.name("ThermalBridgingFactorID"
			 * )), By.xpath("//mat-option/span[contains(text(),' User Defined ')]"));
			 * 
			 * break;
			 * 
			 * }
			 */ waitForAngularPageToLoad();
			String thermalBridgingFactorValue = String
					.valueOf(surveyBGeneralsList.get(i).get(data.get(0).get("ThermalBridgingFactor"))).trim();
			System.out.println("thermalBridgingFactorValue" + thermalBridgingFactorValue);
			Boolean filed = driver.findElement(By.id("ThermalBridgingFactor")).isEnabled();
			if (filed) {

				driver.findElement(By.id("ThermalBridgingFactor")).clear();

				driver.findElement(By.id("ThermalBridgingFactor")).sendKeys(thermalBridgingFactorValue);
			} else {
				System.out.println("NO ! Element is not enabled");
			}

		}
	}

	/*
	 * waitForAngularPageToLoad(); List<List<String>> lists =
	 * dataTable.asLists(String.class); for (int i = 1; i < lists.size(); i++) {
	 * 
	 * driver.findElement(By.id("global-factors-tab")).click();
	 * 
	 * waitForAngularPageToLoad(); List<String> vList = lists.get(i);
	 * selectByTextFromDropdown(driver.findElement(By.id("ThermalMassCategoryID")),
	 * 
	 * (By.xpath("//span[contains(text(),'" + vList.get(0) + "')]")));
	 * 
	 * waitForAngularPageToLoad();
	 * selectByTextFromDropdown(driver.findElement(By.id("ThermalBridgingFactorID"))
	 * , (By.xpath("//span[contains(text(),'" + vList.get(1) + "')]")));
	 * waitForAngularPageToLoad();
	 * 
	 * WebElement element = driver.findElement(By.name("ThermalBridgingFactor")); //
	 * if(element.isDisplayed()) if (element.isEnabled()) {
	 * driver.findElement(By.name("ThermalBridgingFactor")).clear();
	 * driver.findElement(By.name("ThermalBridgingFactor")).sendKeys(vList.get(2));
	 * }
	 * 
	 * }
	 */

	@Then("Configure INFILTRATION DUE TO OPENINGS in Ventilation details Page")
	public void configure_infiltration_due_to_openings_in_ventilation_details_page(
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		waitForAngularPageToLoad();
		driver.findElement(By.id("air-tightness-tab")).click();
		waitForAngularPageToLoad();
		driver.findElement(By.id("infiltration-tab")).click();

		waitForAngularPageToLoad();

		Object surveyBGeneralsObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveyBGenerals"));
		System.out.println("surveyBGenerals Object:" + surveyBGeneralsObject);
		List<HashMap<String, Object>> surveyBGeneralsList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveyBGeneralsObject);
		System.out.println("surveyBGeneralsList List:" + surveyBGeneralsList);
		// for (int i = 0; i < doorlist.size(); i++) {

		for (int i = 0; i < surveyBGeneralsList.size(); i++) {

			waitForAngularPageToLoad();
			sleep(2000);
			String draughtLobbyCheckboxValue = String
					.valueOf(surveyBGeneralsList.get(i).get(data.get(0).get("DraughtLobby"))).trim();

			if ((draughtLobbyCheckboxValue.trim().equalsIgnoreCase("true"))) {
				WebElement draughtLobbyCheckbox = driver.findElement(By.xpath("//input[@name='DraughtLobby']"));

				checkOrUncheck(draughtLobbyCheckbox, draughtLobbyCheckboxValue);
				// draughtLobbyCheckbox.click();
			}

		}

		waitForAngularPageToLoad();

		Object ventilationObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("AddVentilationCommonItem"));
		System.out.println("ventilation Object:" + ventilationObject);
		List<HashMap<String, Object>> ventilationList = JsonUtils.getJsonArrayValueAsListOfMap(ventilationObject);
		System.out.println("ventilation List:" + ventilationList);
		// for (int i = 0; i < doorlist.size(); i++) {

		for (int i = 0; i < ventilationList.size(); i++) {

			JSONObject libItem = new JSONObject(ventilationList.get(i).get(data.get(0).get("LibraryItem")).toString());
			Object libObject = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("MarketingName"));

			String marketingNameValue = String.valueOf(libObject.toString()).trim();
			if (marketingNameValue.equalsIgnoreCase("Chimney") || marketingNameValue.equalsIgnoreCase("Flue")
					|| marketingNameValue.equalsIgnoreCase("Flueless Combustion Room Heater")
					|| marketingNameValue.equalsIgnoreCase("Intermittent Fan")
					|| marketingNameValue.equalsIgnoreCase("Passive, Non-Closable Vent")) {

				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[contains(text(),'Add Ventilation Item')]")).click();
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[contains(text(),'" + marketingNameValue + "')]")).click();
				addedVentilationList.put(marketingNameValue, ventilationList.get(i));
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();
				for (String key : addedVentilationList.keySet()) {
					HashMap<String, Object> value = addedVentilationList.get(key);
					System.out.println("Key = " + key + ", Value = " + value);

					driver.findElement(By.xpath("//span[contains(text(),'" + key + "')]")).click();
					waitForAngularPageToLoad();
					sleep(2000);
					driver.findElement(By.id("Number")).clear();
					driver.findElement(By.id("Number")).sendKeys(value.get(data.get(0).get("Number")).toString());

					/*
					 * selectByTextFromDropdown(driver.findElement(By.xpath(
					 * "//md-select[contains(@ng-model,'sid.item.RoomID')]")), By.xpath(
					 * "//md-option[contains(@ng-repeat,'sid.data.surveyDetails.SurveyRooms')]"),
					 * vList.get(2));
					 * 
					 * driver.findElement(By.name("Description")).clear();
					 * driver.findElement(By.name("Description")).sendKeys(vList.get(3));
					 */
					driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
					waitForAngularPageToLoad();

				}
			} else {
				continue;
			}

		}
	}

	@When("user enters Ventilation details")
	public void user_enters_ventilation_details() {

	}

	@When("clicks Global Factors add Ventilation details")
	public void clicks_global_factors_add_ventilation_details(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 0; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(
					By.xpath("//div[contains(@class,'vent-openings-name flex')]/span[text()='" + vList.get(0) + "']"))
					.click();
			sleep(2000);
			driver.findElement(By.name("Number")).clear();
			driver.findElement(By.name("Number")).sendKeys(vList.get(1));

			selectByTextFromDropdown(driver.findElement(By.xpath("//md-select[contains(@ng-model,'sid.item.RoomID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.data.surveyDetails.SurveyRooms')]"), vList.get(2));

			driver.findElement(By.name("Description")).clear();
			driver.findElement(By.name("Description")).sendKeys(vList.get(3));
			driver.findElement(By.xpath("//button[@aria-label='Save']")).click();
			sleep(2000);

		}

	}

	@Then("edit Window Details")
	public void edit_window_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);
			driver.findElement(By.name("Number")).clear();
			driver.findElement(By.name("Number")).sendKeys(vList.get(0));

			selectByTextFromDropdown(driver.findElement(By.xpath("//md-select[contains(@ng-model,'sid.item.RoomID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.data.surveyDetails.SurveyRooms')]"), vList.get(1));
			sleep(2000);
			driver.findElement(By.name("Description")).clear();
			driver.findElement(By.name("Description")).sendKeys(vList.get(2));

			driver.findElement(By.name("Area")).clear();
			driver.findElement(By.name("Area")).sendKeys(vList.get(3));

			selectByTextFromDropdown(
					driver.findElement(By.xpath(
							"//md-select[contains(@ng-model,'sid.item.LibraryItem.LibraryItemWindow.OrientationID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.refData.window.WindowOrientations')]"),
					vList.get(4));

			driver.findElement(By.name("UValue")).clear();
			driver.findElement(By.name("UValue")).sendKeys(vList.get(5));

			selectByTextFromDropdown(
					driver.findElement(By.xpath(
							"//md-select[contains(@ng-model,'sid.item.LibraryItem.LibraryItemWindow.OvershadingID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.refData.window.WindowOvershading')]"), vList.get(6));

			selectByTextFromDropdown(
					driver.findElement(By.xpath(
							"//md-select[contains(@ng-model,'sid.item.LibraryItem.LibraryItemWindow.BlindID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.refData.window.BlindType')]"), vList.get(7));

			driver.findElement(By.name("Openings")).clear();
			driver.findElement(By.name("Openings")).sendKeys(vList.get(8));

			driver.findElement(By.name("DraughtStrippedOpenings")).clear();
			driver.findElement(By.name("DraughtStrippedOpenings")).sendKeys(vList.get(9));

			selectByTextFromDropdown(
					driver.findElement(By.xpath(
							"//md-select[contains(@ng-model,'sid.item.LibraryItem.LibraryItemWindow.OverhangID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.refData.window.OverhangType')]"), vList.get(10));

			selectByTextFromDropdown(driver.findElement(By.xpath(
					"//md-select[contains(@ng-model,'sid.item.LibraryItem.LibraryItemWindow.OverhangDepthID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.refData.window.OverhangDepthRatio')]"),
					vList.get(11));

			WebElement includeSemiExposedCheckbox = driver.findElement(
					By.xpath("//md-checkbox[@ng-model='sid.item.LibraryItem.LibraryItemWindow.RoofWindow']"));

			if (UnCheck(includeSemiExposedCheckbox)) {
				includeSemiExposedCheckbox.click();
				sleep(2000);

			}

			driver.findElement(By.xpath("//button[@aria-label='Save']")).click();
			sleep(2000);

		}

	}

	@Then("Configure STRUCTURAL AIR TIGHTNESS details Page")
	public void configure_structural_air_tightness_details_page(io.cucumber.datatable.DataTable dataTable) {

		sleep(2000);
		waitForAngularPageToLoad();

		driver.findElement(By.id("air-tightness-tab")).click();
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyVentilationsObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveyVentilations"));
		System.out.println("Survey Object:" + surveyVentilationsObject);
		List<HashMap<String, Object>> surveyVentilationList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveyVentilationsObject);
		System.out.println("survey Ventilation List:" + surveyVentilationList);
		// for (int i = 0; i < doorlist.size(); i++) {

		for (int i = 0; i < surveyVentilationList.size(); i++) {

			waitForAngularPageToLoad();
			String thermalBridgingFactorValue = String
					.valueOf(surveyVentilationList.get(i).get(data.get(0).get("ThermalBridgingFactor"))).trim();
			System.out.println("thermalBridgingFactorValue" + thermalBridgingFactorValue);

			String airPermeabilityResultValue = String
					.valueOf(surveyVentilationList.get(i).get(data.get(0).get("AirPermeabilityResult"))).trim();

			String structuralInfiltrationIDValue = String
					.valueOf(surveyVentilationList.get(i).get(data.get(0).get("StructuralInfiltrationID"))).trim();

			String woodenFloorIDValue = String
					.valueOf(surveyVentilationList.get(i).get(data.get(0).get("WoodenFloorID"))).trim();

			String numberValue = String.valueOf(surveyVentilationList.get(i).get(data.get(0).get("Number"))).trim();

			System.out.println("airPermeabilityResultValue" + airPermeabilityResultValue);
			if (airPermeabilityResultValue.equalsIgnoreCase("null")) {

				selectByTextFromDropdown(driver.findElement(By.id("StructuralInfiltrationID")),
						By.xpath("//mat-option[@ref-value='" + structuralInfiltrationIDValue + "']"));
				waitForAngularLoad();

				selectByTextFromDropdown(driver.findElement(By.id("WoodenFloorID")),
						By.xpath("//mat-option[@ref-value='" + woodenFloorIDValue + "']"));
				waitForAngularLoad();

			}

			else if (!airPermeabilityResultValue.equalsIgnoreCase("null")) {
				waitForAngularPageToLoad();

				// go check box method

				/*
				 * String classAtr = driver
				 * .findElement(By.cssSelector("mat-checkbox")).getAttribute("class");
				 * 
				 * Assert(classAtr.contains("mat-checkbox-checked")).toBe(true);
				 */

				driver.findElement(By.id("AirPermeabilityTest")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.id("AirPermeabilityResult")).clear();
				driver.findElement(By.id("AirPermeabilityResult")).sendKeys(airPermeabilityResultValue);
				waitForAngularPageToLoad();

			}

			Object surveyBGeneralsTypeObject = JsonUtils.getNestedJsonStringValueByKey(json,
					data.get(0).get("SurveyBGenerals"));
			System.out.println("surveyBGenerals Type Object" + surveyBGeneralsTypeObject);

			List<HashMap<String, Object>> surveyBGeneralsTypeList = JsonUtils
					.getJsonArrayValueAsListOfMap(surveyBGeneralsTypeObject);
			System.out.println("surveyBGeneralsType List:" + surveyBGeneralsTypeList);

			// Object libObject =
			// JsonUtils.getNestedJsonStringValueByKey1(surveyBGeneralsTypeList,
			// data.get(0).get("MarketingName"));

			/*
			 * Object surveyBGeneralsTypeObject =
			 * JsonUtils.getNestedJsonStringValueByKey(json,
			 * data.get(0).get("SurveyBGenerals"));
			 * 
			 * List<HashMap<String, Object>> surveyBGeneralsList =
			 * JsonUtils.getJsonArrayValueAsListOfMap(surveyBGeneralsTypeObject); Object
			 * libObject = JsonUtils.getNestedJsonStringValueByKey(surveyBGeneralsList,
			 * data.get(0).get("MarketingName"));
			 */

			for (int j = 0; j < surveyBGeneralsTypeList.size(); j++) {

				waitForAngularPageToLoad();
				String noOfSidesShelteredValue = String
						.valueOf(surveyBGeneralsTypeList.get(j).get(data.get(0).get("NoOfSidesSheltered"))).trim();
				System.out.println("thermalBridgingFactorValue" + thermalBridgingFactorValue);

				driver.findElement(By.id("NoOfSidesSheltered")).clear();
				driver.findElement(By.id("NoOfSidesSheltered")).sendKeys(noOfSidesShelteredValue);
			}

		}

		Object sidesShelteredObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("SurveyBGenerals"));
		System.out.println("sidesSheltered Object:" + sidesShelteredObject);
		List<HashMap<String, Object>> sidesShelteredList = JsonUtils.getJsonArrayValueAsListOfMap(sidesShelteredObject);
		System.out.println("sidesSheltered List:" + sidesShelteredList);

		waitForAngularPageToLoad();
		//
		// Object ventilationObject = JsonUtils.getNestedJsonStringValueByKey(json,
		// data.get(0).get("AddVentilationCommonItem"));
		// System.out.println("ventilation Object:" + ventilationObject);
		// List<HashMap<String, Object>> ventilationList =
		// JsonUtils.getJsonArrayValueAsListOfMap(ventilationObject);
		// System.out.println("ventilation List:" + ventilationList);
		//
		// waitForAngularPageToLoad();
		// driver.findElement(By.id("AirPermeabilityTest")).click();
		// waitForAngularPageToLoad();
		//
		// driver.findElement(By.id("AirPermeabilityResult")).clear();
		// driver.findElement(By.id("AirPermeabilityResult")).sendKeys("0.17");
		// waitForAngularPageToLoad();
		//
		// driver.findElement(By.id("NoOfSidesSheltered")).clear();
		// driver.findElement(By.id("NoOfSidesSheltered"))
		// .sendKeys(sidesShelteredList.get(0).get(data.get(0).get("NoOfSidesSheltered").trim()).toString());

		Object surveyItemsObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("SurveyItems"));

		List<HashMap<String, Object>> libraryItemList = JsonUtils.getJsonArrayValueAsListOfMap(surveyItemsObject);
		System.out.println("ventilation List:" + libraryItemList);
		// for (int i = 0; i < doorlist.size(); i++) {

		for (int i = 0; i < libraryItemList.size(); i++) {

			JSONObject libItem = new JSONObject(libraryItemList.get(i).get(data.get(0).get("LibraryItem")).toString());
			Object marketingName = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("MarketingName"));

			String marketingNameValue = String.valueOf(marketingName.toString()).trim();

			if (marketingNameValue.equalsIgnoreCase("Attic Hatch - Draught Stripped")
					|| marketingNameValue.equalsIgnoreCase("Attic Hatch - Not Draught Stripped")) {

				driver.findElement(By.xpath("//span[contains(text(),'Add Attic Hatch')]")).click();
				waitForAngularPageToLoad();
				addedVentilationList.clear();

				driver.findElement(By.xpath("//span[contains(text(),'" + marketingNameValue + "')]")).click();

				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();

			} else {
				continue;
			}

		}

	}

	private Object Assert(boolean contains) {
		// TODO Auto-generated method stub
		return null;
	}

	@Then("Add Attic Hatch details")
	public void add_attic_hatch_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		driver.findElement(By.xpath("//button/span[contains(text(),'Add Attic Hatch')]")).click();
		sleep(3000);

		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);
			driver.findElement(By.xpath("//div/h3/span[contains(text(),'" + vList.get(0) + "')]")).click();
			sleep(1000);
		}

		driver.findElement(By.xpath("//button[@aria-label='Add Selected Items']")).click();
		sleep(2000);

	}

	@Then("clicks Attic Hatch and edit details")
	public void clicks_attic_hatch_and_edit_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 0; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(
					By.xpath("//div[contains(@class,'vent-openings-name flex')]/span[text()='" + vList.get(0) + "']"))
					.click();
			sleep(2000);
			driver.findElement(By.name("Number")).clear();
			driver.findElement(By.name("Number")).sendKeys(vList.get(1));

			selectByTextFromDropdown(driver.findElement(By.xpath("//md-select[contains(@ng-model,'sid.item.RoomID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.data.surveyDetails.SurveyRooms')]"), vList.get(2));

			driver.findElement(By.name("Description")).clear();
			driver.findElement(By.name("Description")).sendKeys(vList.get(3));
			driver.findElement(By.xpath("//button[@aria-label='Save']")).click();
			sleep(2000);

		}

	}

	@Then("VENTILATION METHOD detail")
	public void ventilation_method_detail(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			driver.findElement(By.xpath("//md-tab-item[contains(text(),'VENTILATION METHOD')]")).click();
			sleep(5000);
			List<String> vList = lists.get(i);
			selectByTextFromDropdown(driver.findElement(By.id("VentilationMethodID")),
					By.xpath("//md-option[contains(@ng-repeat,'vm.refData.ventilation.VentilationMethod')]"),
					vList.get(0));
			sleep(4000);

		}

	}

	@Then("Ventilation Method Page detail")
	public void ventilation_method_page_detail(io.cucumber.datatable.DataTable dataTable) {

		sleep(2000);
		waitForAngularPageToLoad();

		driver.findElement(By.id("method-tab")).click();
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyVentilationsObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveyVentilations"));
		System.out.println("Survey Object:" + surveyVentilationsObject);
		List<HashMap<String, Object>> surveyVentilationList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveyVentilationsObject);
		System.out.println("survey Ventilation List:" + surveyVentilationList);
		// for (int i = 0; i < doorlist.size(); i++) {

		waitForAngularPageToLoad();
		String methodValue = String.valueOf(surveyVentilationList.get(0).get(data.get(0).get("Method"))).trim();
		System.out.println("method Value" + methodValue);

		switch (methodValue) {

			case "1":
				selectByTextFromDropdown(driver.findElement(By.id("VentilationMethodID")),
						By.xpath("//mat-option[@ref-value='" + methodValue + "']"));

				break;

			case "4":
				selectByTextFromDropdown(driver.findElement(By.id("VentilationMethodID")),
						By.xpath("//mat-option[@ref-value='" + methodValue + "']"));

				driver.findElement(By.name("FanPower")).clear();
				driver.findElement(By.name("FanPower"))
						.sendKeys(surveyVentilationList.get(0).get(data.get(0).get("FanPower").trim()).toString());
				waitForAngularLoad();

				// driver.findElement(By.name("Manufacturer"))
				// .sendKeys(surveyVentilationList.get(0).get(data.get(0).get("Manufacturer").trim()).toString());
				//
				// driver.findElement(By.name("Model"))
				// .sendKeys(surveyVentilationList.get(0).get(data.get(0).get("Model").trim()).toString());
				//
				// driver.findElement(By.name("Wetrooms"))
				// .sendKeys(surveyVentilationList.get(0).get(data.get(0).get("Wetrooms").trim()).toString());

				break;

			case "6":
				selectByTextFromDropdown(driver.findElement(By.id("VentilationMethodID")),
						By.xpath("//mat-option[@ref-value='" + methodValue + "']"));

				driver.findElement(By.name("FanPower")).clear();
				driver.findElement(By.name("FanPower"))
						.sendKeys(surveyVentilationList.get(0).get(data.get(0).get("FanPower").trim()).toString());
				waitForAngularLoad();
				driver.findElement(By.name("HeatExchanger")).clear();
				driver.findElement(By.name("HeatExchanger"))
						.sendKeys(surveyVentilationList.get(0).get(data.get(0).get("HeatExchanger").trim()).toString());

				WebElement externalUninsulatedDucting = driver.findElement(By.name("ExternalUninsulatedDucting"));

				checkOrUncheck(externalUninsulatedDucting,
						surveyVentilationList.get(0).get("ExternalUninsulatedDucting").toString().trim());

				waitForAngularPageToLoad();
				break;

		}
	}

	@Given("user enters Space Heating section")
	public void space_heating_section() {
		sleep(4000);
		waitForAngularPageToLoad();
		Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(By.xpath("//a[contains(@href,'/space-heating')]"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();

		waitForAngularPageToLoad();

		driver.findElement(By.id("pumps-fans-tab")).click();

		waitForAngularPageToLoad();

		driver.findElement(By.id("ctrl-resp-tab")).click();

		waitForAngularPageToLoad();

	}

	@Then("Controls and Responsiveness in Space Heating section")
	public void controls_and_responsiveness_in_space_heating_section() {
		sleep(2000);
		Actions actions = new Actions(driver);

		WebElement menuOption = driver
				.findElement(By.xpath("//md-list[@ng-if='s.viewData.access.canViewSurvey']/md-list-item[4]"));

		actions.moveToElement(menuOption).perform();

		sleep(1000);
	}

	@Then("Space Heating Controls and Responsiveness Page")
	public void space_heating_controls_and_responsiveness_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object spaceHeatingObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveySHSelectedTypes"));
		System.out.println("space Heating Object" + spaceHeatingObject);
		List<HashMap<String, Object>> spaceHeatingDetialList = JsonUtils
				.getJsonArrayValueAsListOfMap(spaceHeatingObject);
		System.out.println("space Heating List:" + spaceHeatingDetialList);

		driver.findElement(By.xpath("//*[@name='SpaceHeatingTypeID'][@value='"
				+ spaceHeatingDetialList.get(0).get(data.get(0).get("SpaceHeatingTypeID")) + "']")).click();

	}

	@Then("Space Heating system Properties")
	public void space_heating_system_properties(io.cucumber.datatable.DataTable dataTable) {

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveySHHeatSourcePropertiesObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveySHHeatSourceProperties"));

		List<HashMap<String, Object>> surveySHHeatSourcePropertiesList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveySHHeatSourcePropertiesObject);

		for (int i = 0; i < surveySHHeatSourcePropertiesList.size(); i++) {

			waitForAngularPageToLoad();
			String heatingSystemCategoryIDValue = String
					.valueOf(surveySHHeatSourcePropertiesList.get(i).get(data.get(0).get("HeatingSystemCategoryID")))
					.trim();
			System.out.println("heatingSystemCategoryID Value" + heatingSystemCategoryIDValue);

			Object surveySHSelectedTypesObject = JsonUtils.getNestedJsonStringValueByKey(json,
					data.get(0).get("SurveySHSelectedTypes"));

			List<HashMap<String, Object>> surveySHSelectedTypesObjectList = JsonUtils
					.getJsonArrayValueAsListOfMap(surveySHSelectedTypesObject);

			for (int j = 0; j < surveySHSelectedTypesObjectList.size(); j++) {

				String surveyWHStorageTypesIDValue = String
						.valueOf(surveySHSelectedTypesObjectList.get(i).get(data.get(0).get("SpaceHeatingTypeID")))
						.trim();

				if (surveyWHStorageTypesIDValue.trim().toLowerCase().equals("2")) {

					waitForAngularPageToLoad();

					/*
					 * Actions actions = new Actions(driver);
					 * 
					 * WebElement spaceHeatingTypeIDOption = driver .findElement(By.
					 * xpath("//*[@name='SpaceHeatingTypeID' and @value='2']/../../span[2]"));
					 * 
					 * actions.moveToElement(spaceHeatingTypeIDOption).perform();
					 * 
					 * spaceHeatingTypeIDOption.click();
					 */

					driver.findElement(By.xpath("//*[@name='SpaceHeatingTypeID' and @value='2']/../../span[2]"))
							.click();

					waitForAngularPageToLoad();
					driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
					waitForAngularPageToLoad();

					// driver.findElement(By.xpath("//*[@name='SpaceHeatingTypeID' and
					// @value='2']")).click();

				}

			}

			selectByTextFromDropdown(driver.findElement(By.name("HeatingSystemCategoryID")),
					By.xpath("//mat-option[@ref-value='" + heatingSystemCategoryIDValue + "']"));

			String subCategory1IDValue = String
					.valueOf(surveySHHeatSourcePropertiesList.get(i).get(data.get(0).get("SubCategory1ID"))).trim();
			System.out.println("subCategory1ID Value" + subCategory1IDValue);
			waitForAngularPageToLoad();
			if (!subCategory1IDValue.trim().toLowerCase().equals("null")) {

				selectByTextFromDropdown(driver.findElement(By.name("SubCategory1ID")),
						By.xpath("//mat-option[@ref-value='" + subCategory1IDValue + "']"));
				waitForAngularPageToLoad();
			}
			if (subCategory1IDValue.equalsIgnoreCase("9")) {
				String subCategory2IDValue = String
						.valueOf(surveySHHeatSourcePropertiesList.get(i).get(data.get(0).get("SubCategory2ID"))).trim();
				System.out.println("subCategory2ID Value" + subCategory2IDValue);

				selectByTextFromDropdown(driver.findElement(By.name("SubCategory2ID")),
						By.xpath("//mat-option[@ref-value='" + subCategory2IDValue + "']"));
				waitForAngularPageToLoad();
			}

			String heatingSystemValue = String
					.valueOf(surveySHHeatSourcePropertiesList.get(i).get(data.get(0).get("HeatingSystem"))).trim();
			System.out.println("heatingSystem Value" + heatingSystemValue);

			selectByTextFromDropdown(driver.findElement(By.name("HeatingSystem")),
					By.xpath("//mat-option[@ref-value='" + heatingSystemValue + "']"));
			waitForAngularPageToLoad();
			String heatEmitterTypeValue = String
					.valueOf(surveySHHeatSourcePropertiesList.get(i).get(data.get(0).get("HeatEmitterType"))).trim();
			System.out.println("heatEmitterTypeValue" + heatEmitterTypeValue);

			waitForAngularLoad();
			if (!heatEmitterTypeValue.trim().toLowerCase().equals("null")) {

				selectByTextFromDropdown(driver.findElement(By.name("HeatEmitterType")),
						By.xpath("//mat-option[@ref-value='" + heatEmitterTypeValue + "']"));
			}
			String heatingSystemControlsIDValue = String
					.valueOf(surveySHHeatSourcePropertiesList.get(i).get(data.get(0).get("HeatingSystemControlsID")))
					.trim();
			System.out.println("heatingSystemControlsID Value" + heatingSystemControlsIDValue);

			selectByTextFromDropdown(driver.findElement(By.name("HeatingSystemControlsID")),
					By.xpath("//mat-option[@ref-value='" + heatingSystemControlsIDValue + "']"));
			// comparing value is true or not
			// go check box method needed

			String loadWeatherCompensation = String
					.valueOf(surveySHHeatSourcePropertiesList.get(i).get(data.get(0).get("LoadWeatherCompensation")))
					.trim();

			// WebElement element = driver.findElement(By.id("LoadWeatherCompensation"));

			// if (element.isDisplayed() && element.isEnabled()) {

			if (loadWeatherCompensation.equalsIgnoreCase("true")) {

				WebElement loadWeatherCompensationid = driver.findElement(By.id("LoadWeatherCompensation"));
				// checkOrUncheck(loadWeatherCompensationid,floorLocationID.get(i).get("ComplianceCheck").toString().trim());

				driver.findElement(By.id("LoadWeatherCompensation")).click();
				waitForAngularPageToLoad();

				// }

			}
		}

	}

	@And("Group Schema in Heat Sources Page")
	public void group_schema_in_heat_sources_page(io.cucumber.datatable.DataTable dataTable) {

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveySHHeatSourceGroupsObj = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveySHHeatSourceGroups"));

		List<HashMap<String, Object>> surveySHHeatSourceGroupsObjList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveySHHeatSourceGroupsObj);

		for (int k = 0; k < surveySHHeatSourceGroupsObjList.size(); k++) {
			Object surveySHHeatSourceGroupItemsObj = JsonUtils.getNestedJsonStringValueByKey(
					new JSONObject(surveySHHeatSourceGroupsObjList.get(k)),
					data.get(0).get("SurveySHHeatSourceGroupItems"));

			List<HashMap<String, Object>> surveySHHeatSourceGroupItemsObjList = JsonUtils
					.getJsonArrayValueAsListOfMap(surveySHHeatSourceGroupItemsObj);

			for (int i = 0; i < surveySHHeatSourceGroupItemsObjList.size(); i++) {

				driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]")).click();
				waitForAngularPageToLoad();

				String fuelTypeIDValue = String
						.valueOf(surveySHHeatSourceGroupItemsObjList.get(i).get(data.get(0).get("FuelTypeID"))).trim();
				System.out.println("FuelTypeID Value" + fuelTypeIDValue);

				List<WebElement> mNameList = driver
						.findElements(By.xpath("//*[@id='FuelTypeID']"));

				System.out.println("marketingName:" + mNameList);
				mNameList.get(mNameList.size() - 1).click();

				Actions actions = new Actions(driver);
				sleep(2000);
				WebElement menuOption = driver
						.findElement(By.xpath("//mat-option[@ref-value='" + fuelTypeIDValue + "']"));

				actions.moveToElement(menuOption).perform();
				menuOption.click();

				waitForAngularPageToLoad();

				String percentageOfHeatValue = String
						.valueOf(surveySHHeatSourceGroupItemsObjList.get(i).get(data.get(0).get("PercentageOfHeat")))
						.trim();
				System.out.println("percentageOfHeat Value" + percentageOfHeatValue);

				driver.findElement(By.id("PercentageOfHeat")).click();
				driver.findElement(By.id("PercentageOfHeat")).clear();
				driver.findElement(By.id("PercentageOfHeat")).sendKeys(percentageOfHeatValue);

				String percentageEfficiencyValue = String
						.valueOf(
								surveySHHeatSourceGroupItemsObjList.get(i).get(data.get(0).get("PercentageEfficiency")))
						.trim();
				System.out.println("percentageEfficiencyValue" + percentageEfficiencyValue);

				driver.findElement(By.id("PercentageEfficiency")).click();
				driver.findElement(By.id("PercentageEfficiency")).clear();
				driver.findElement(By.id("PercentageEfficiency")).sendKeys(percentageEfficiencyValue);

				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
				waitForAngularPageToLoad();

			}
		}

		for (int i = 0; i < surveySHHeatSourceGroupsObjList.size(); i++) {

			String distributionLossFactorValue = String
					.valueOf(surveySHHeatSourceGroupsObjList.get(i).get(data.get(0).get("DistributionLossFactor")))
					.trim();
			System.out.println("distributionLossFactorValue" + distributionLossFactorValue);

			driver.findElement(By.id("DistributionLossFactor")).click();
			driver.findElement(By.id("DistributionLossFactor")).clear();
			driver.findElement(By.id("DistributionLossFactor")).sendKeys(distributionLossFactorValue);

			String percentageOfSecondaryHeatValue = String
					.valueOf(surveySHHeatSourceGroupsObjList.get(i).get(data.get(0).get("PercentageOfSecondaryHeat")))
					.trim();
			System.out.println("percentageOfSecondaryHeatValue" + percentageOfSecondaryHeatValue);

			driver.findElement(By.id("PercentageOfSecondaryHeat")).click();
			driver.findElement(By.id("PercentageOfSecondaryHeat")).clear();
			driver.findElement(By.id("PercentageOfSecondaryHeat")).sendKeys(percentageOfSecondaryHeatValue);

			String percentageEffciencyOfSecondarySystemValue = String
					.valueOf(surveySHHeatSourceGroupsObjList.get(i)
							.get(data.get(0).get("PercentageEffciencyOfSecondarySystem")))
					.trim();
			System.out.println("percentageEffciencyOfSecondarySystemValue" + percentageEffciencyOfSecondarySystemValue);

			driver.findElement(By.id("PercentageEffciencyOfSecondarySystem")).click();
			driver.findElement(By.id("PercentageEffciencyOfSecondarySystem")).clear();
			driver.findElement(By.id("PercentageEffciencyOfSecondarySystem"))
					.sendKeys(percentageEffciencyOfSecondarySystemValue);

			String chargingOnConsumptionValue = String
					.valueOf(surveySHHeatSourceGroupsObjList.get(i).get(data.get(0).get("ChargingOnConsumption")))
					.trim();
			System.out.println("chargingOnConsumptionValue :" + chargingOnConsumptionValue);

			if (!chargingOnConsumptionValue.trim().toLowerCase().equals("null")) {

				if (chargingOnConsumptionValue.trim().toLowerCase().equals("true")) {

					List<WebElement> mNameList = driver
							.findElements(By.xpath("//*[@id='ChargingOnConsumption']"));

					System.out.println("marketingName:" + mNameList);
					mNameList.get(mNameList.size() - 1).click();

					waitForAngularPageToLoad();

				}

			}
			String secondarySpaceHeatingFuelIDValue = String
					.valueOf(surveySHHeatSourceGroupsObjList.get(i).get(data.get(0).get("SecondarySpaceHeatingFuelID")))
					.trim();

			if (!secondarySpaceHeatingFuelIDValue.trim().toLowerCase().equals("null")) {

				WebElement secondarySpaceHeatingFuelID = driver.findElement(By.id("SecondarySpaceHeatingFuelID"));

				checkOrUncheck(secondarySpaceHeatingFuelID, secondarySpaceHeatingFuelIDValue);
			}

		}

		Object surveySHCHPGroupsObj = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveySHCHPGroups"));

		List<HashMap<String, Object>> surveySHCHPGroupsObjectList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveySHCHPGroupsObj);

		for (int i = 0; i < surveySHCHPGroupsObjectList.size(); i++) {

			String fractionOfHeatValue = String
					.valueOf(surveySHCHPGroupsObjectList.get(i).get(data.get(0).get("FractionOfHeat"))).trim();
			System.out.println("fractionOfHeatValue" + fractionOfHeatValue);

			driver.findElement(By.id("FractionOfHeat")).click();
			driver.findElement(By.id("FractionOfHeat")).clear();
			driver.findElement(By.id("FractionOfHeat")).sendKeys(fractionOfHeatValue);

			String heatingSystemIDValue = String
					.valueOf(surveySHCHPGroupsObjectList.get(i).get(data.get(0).get("HeatingSystemID"))).trim();

			if (!heatingSystemIDValue.trim().toLowerCase().equals("null")) {

				selectByTextFromDropdown(driver.findElement(By.id("HeatingSystemID")),
						By.xpath("//mat-option[@ref-value='" + heatingSystemIDValue + "']"));
				waitForAngularLoad();

			}

			String fuelTypeIDValue = String
					.valueOf(surveySHCHPGroupsObjectList.get(i).get(data.get(0).get("FuelTypeID"))).trim();

			if (!fuelTypeIDValue.trim().toLowerCase().equals("null")) {

				selectByTextFromDropdown(driver.findElement(By.id("FuelTypeID")),
						By.xpath("//mat-option[@ref-value='" + fuelTypeIDValue + "']"));
				waitForAngularLoad();

			}

			String cHPElectricalEfficiencyOfCHPunitValue = String
					.valueOf(
							surveySHCHPGroupsObjectList.get(i).get(data.get(0).get("CHPElectricalEfficiencyOfCHPunit")))
					.trim();
			System.out.println("cHPElectricalEfficiencyOfCHPunitValue" + cHPElectricalEfficiencyOfCHPunitValue);

			driver.findElement(By.id("CHPElectricalEfficiencyOfCHPunit")).click();
			driver.findElement(By.id("CHPElectricalEfficiencyOfCHPunit")).clear();
			driver.findElement(By.id("CHPElectricalEfficiencyOfCHPunit"))
					.sendKeys(cHPElectricalEfficiencyOfCHPunitValue);

			String heatEfficiencyOfCHPValue = String
					.valueOf(surveySHCHPGroupsObjectList.get(i).get(data.get(0).get("HeatEfficiencyOfCHP"))).trim();
			System.out.println("heatEfficiencyOfCHPValue" + heatEfficiencyOfCHPValue);

			driver.findElement(By.id("HeatEfficiencyOfCHP")).click();
			driver.findElement(By.id("HeatEfficiencyOfCHP")).clear();
			driver.findElement(By.id("HeatEfficiencyOfCHP")).sendKeys(heatEfficiencyOfCHPValue);

		}

	}

	@Given("Space Heating Controls and Responsiveness")
	public void space_heating_controls_and_responsiveness(io.cucumber.datatable.DataTable dataTable) {

	}

	@Then("Pumps and Fans Page")
	public void pumps_and_fans_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		driver.findElement(By.id("pumps-fans-tab")).click();
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveySHGainLossesObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveySHGainLosses"));

		List<HashMap<String, Object>> surveySHGainLossesObjectPropertiesList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveySHGainLossesObject);

		waitForAngularPageToLoad();

		for (int i = 0; i < surveySHGainLossesObjectPropertiesList.size(); i++) {

			String pumpsCentralHeatingObject = String
					.valueOf(surveySHGainLossesObjectPropertiesList.get(i).get(data.get(0).get("PumpsCentralHeating")))
					.trim();
			String pumpsCentralHeatingValue = String.valueOf(pumpsCentralHeatingObject.toString()).trim();

			if (!pumpsCentralHeatingValue.trim().toLowerCase().equals("null")) {

				driver.findElement(By.id("PumpsCentralHeating")).click();
				waitForAngularPageToLoad();
				driver.findElement(By.id("PumpsCentralHeating")).sendKeys(pumpsCentralHeatingValue);
			}

			String pumpsOilBoilerObject = String
					.valueOf(surveySHGainLossesObjectPropertiesList.get(i).get(data.get(0).get("PumpsOilBoiler")))
					.trim();
			String pumpsOilBoilerObjectValue = String.valueOf(pumpsOilBoilerObject.toString()).trim();

			if (!pumpsOilBoilerObjectValue.trim().toLowerCase().equals("null")) {

				driver.findElement(By.id("PumpsOilBoiler")).click();
				waitForAngularPageToLoad();
				driver.findElement(By.id("PumpsOilBoiler")).sendKeys(pumpsOilBoilerObjectValue);
			}

			String pumpsGasBoilerFlueFanObject = String
					.valueOf(
							surveySHGainLossesObjectPropertiesList.get(i).get(data.get(0).get("PumpsGasBoilerFlueFan")))
					.trim();
			String pumpsGasBoilerFlueFanObjectValue = String.valueOf(pumpsGasBoilerFlueFanObject.toString()).trim();

			if (!pumpsGasBoilerFlueFanObjectValue.trim().toLowerCase().equals("null")) {

				driver.findElement(By.id("PumpsGasBoilerFlueFan")).click();
				waitForAngularPageToLoad();
				driver.findElement(By.id("PumpsGasBoilerFlueFan")).sendKeys(pumpsGasBoilerFlueFanObjectValue);
			}

			WebElement oilBoilerInsideDwellingcheckbox = driver.findElement(By.name("OilBoilerInsideDwelling"));

			checkOrUncheck(oilBoilerInsideDwellingcheckbox,
					surveySHGainLossesObjectPropertiesList.get(i).get("OilBoilerInsideDwelling").toString().trim());

			/*
			 * driver.findElement(By.name("PumpsCentralHeating")).clear();
			 * driver.findElement(By.name("PumpsCentralHeating")).sendKeys(
			 * surveySHGainLossesObjectPropertiesList.get(i)
			 * .get(data.get(0).get("PumpsCentralHeating").trim()).toString());
			 */
			/*
			 * String centralHeatingThermostatContainer =
			 * String.valueOf(surveySHGainLossesObjectPropertiesList.get(i)
			 * .get(data.get(0).get("CentralHeatingThermostatContainer"))).trim();
			 */

			String centralHeatingThermostat = String.valueOf(
					surveySHGainLossesObjectPropertiesList.get(i).get(data.get(0).get("CentralHeatingThermostat")))
					.trim();

			WebElement centralHeatingThermostatcheckbox = driver.findElement(By.name("CentralHeatingThermostat"));

			checkOrUncheck(centralHeatingThermostatcheckbox,
					surveySHGainLossesObjectPropertiesList.get(i).get("CentralHeatingThermostat").toString().trim());

			WebElement centralHeatingInsideDwellingcheckbox = driver
					.findElement(By.name("CentralHeatingInsideDwelling"));

			checkOrUncheck(centralHeatingInsideDwellingcheckbox, surveySHGainLossesObjectPropertiesList.get(i)
					.get("CentralHeatingInsideDwelling").toString().trim());

			WebElement warmAirHeatingOrFanCoilRadiatorcheckbox = driver
					.findElement(By.name("WarmAirHeatingOrFanCoilRadiator"));

			checkOrUncheck(warmAirHeatingOrFanCoilRadiatorcheckbox, surveySHGainLossesObjectPropertiesList.get(i)
					.get("WarmAirHeatingOrFanCoilRadiator").toString().trim());

			/*
			 * String warmAirHeatingOrFanCoilRadiator =
			 * String.valueOf(surveySHGainLossesObjectPropertiesList.get(i)
			 * .get(data.get(0).get("WarmAirHeatingOrFanCoilRadiator"))).trim();
			 * 
			 * if (warmAirHeatingOrFanCoilRadiator.equals("true")) {
			 * 
			 * driver.findElement(By.id("WarmAirHeatingOrFanCoilRadiator")).click();
			 * waitForAngularPageToLoad();
			 */

			/*
			 * driver.findElement(By.name("PumpsOilBoiler")).clear();
			 * driver.findElement(By.name("PumpsOilBoiler")).sendKeys(
			 * surveySHGainLossespropertieDetialList.get(0).get(data.get(0).get(
			 * "PumpsOilBoiler").trim()).toString()); waitForAngularPageToLoad();
			 * 
			 * driver.findElement(By.name("PumpsGasBoilerFlueFan")).clear();
			 * driver.findElement(By.name("PumpsGasBoilerFlueFan")).sendKeys(
			 * surveySHGainLossespropertieDetialList.get(0)
			 * .get(data.get(0).get("PumpsGasBoilerFlueFan").trim()).toString());
			 * 
			 * waitForAngularPageToLoad();
			 * driver.findElement(By.name("CentralHeatingTotalElectirc")).clear();
			 * driver.findElement(By.name("CentralHeatingTotalElectirc")).sendKeys(
			 * surveySHGainLossespropertieDetialList.get(0)
			 * .get(data.get(0).get("CentralHeatingTotalElectirc").trim()).toString());
			 * waitForAngularPageToLoad();
			 * 
			 */

			// driver.findElement(By.id("WarmAirHeatingOrFanCoilRadiator")).click();

			/*
			 * if (surveySHGainLossespropertieDetialList.get(0).get(data.get(0).get(
			 * "CentralHeatingThermostat").trim()) .toString().equalsIgnoreCase("true")) {
			 * driver.findElement(By.name("CentralHeatingThermostat")).click(); } if
			 * (surveySHGainLossespropertieDetialList.get(0).get(data.get(0).get(
			 * "CentralHeatingInsideDwelling").trim()) .toString().equalsIgnoreCase("true"))
			 * { driver.findElement(By.name("CentralHeatingInsideDwelling")).click(); }
			 */
		}

	}

	@Then("Heat Sources Page")
	public void heat_sources_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		driver.findElement(By.id("heat-sources-tab")).click();
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveySHHeatSourcePropertiesObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveySHHeatSources"));

		System.out.println("surveySHHeatSourceProperties Object" + surveySHHeatSourcePropertiesObject);

		List<HashMap<String, Object>> surveySHHeatSourcePropertiesObjectList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveySHHeatSourcePropertiesObject);
		System.out.println("surveySHHeatSourcePropertiesObject List" + surveySHHeatSourcePropertiesObjectList);

		for (int i = 0; i < surveySHHeatSourcePropertiesObjectList.size(); i++) {

			JSONObject libItem = new JSONObject(
					surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get("LibraryItem")).toString());

			String designFlowTemperature = String
					.valueOf(
							surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get("DesignFlowTemperature")))
					.trim();

			System.out.println("designFlowTemperature : " + designFlowTemperature);

			System.out.println("libItem designFlowTemperature:" + designFlowTemperature);

			String designFlowTemperatureValue = String.valueOf(designFlowTemperature.toString()).trim();

			Object libObject = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("LibraryItemTypeID"));
			Object libObject2 = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("LibraryItemSourceID"));

			Object libraryItemHeatSourceObject = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("LibraryItemHeatSource"));

			Object libraryItemHeatPumpObject = JsonUtils.getNestedJsonStringValueByKey(
					new JSONObject(libraryItemHeatSourceObject.toString()), data.get(0).get("LibraryItemHeatPump"));

			String libraryItemTypeIDValue = String.valueOf(libObject.toString()).trim();
			String libraryItemSourceIDValue = String.valueOf(libObject2.toString()).trim();
			System.out.println("libraryItemTypeID  Value " + libraryItemTypeIDValue);

			sleep(2000);

			if (libraryItemTypeIDValue.equalsIgnoreCase("8"))

			{
				String marketingName = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "MarketingName").toString();

				if (marketingName
						.equalsIgnoreCase("Default electric (direct acting) room heater - Portable electric heaters")) {
					driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]")).click();
					waitForAngularPageToLoad();

					driver.findElement(By.xpath("//span[contains(text(),'" + marketingName + "')]")).click();
					waitForAngularPageToLoad();
					sleep(5000);
					waitForAngularPageToLoad();
					driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
					waitForAngularPageToLoad();

					String fuelTypeID = surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get("FuelTypeID"))
							.toString();
					selectByTextFromDropdown(
							driver.findElement(By.xpath("//*[@id='FuelTypeID' and @aria-required='true']")),
							By.xpath("//mat-option[@ref-value='" + fuelTypeID + "']"));

					String percentageOfHeat = surveySHHeatSourcePropertiesObjectList.get(i)
							.get(data.get(0).get("PercentageOfHeat")).toString();

					WebElement element = driver.findElement(By.id("PercentageOfHeat"));
					if (element.isDisplayed() && element.isEnabled()) {
						element.clear();
						element.sendKeys(percentageOfHeat);

						waitForAngularPageToLoad();
					}

					driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
					waitForAngularPageToLoad();

				}

				else if (libraryItemSourceIDValue.equalsIgnoreCase("1"))

				{
					driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]")).click();
					waitForAngularPageToLoad();
					driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]")).click();
					waitForAngularPageToLoad();
					String manufacturer = JsonUtils
							.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Manufacturer")
							.toString();

					selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
							By.xpath("//mat-option[@ref-value='" + libraryItemTypeIDValue + "']"));

					if (!marketingName.trim().toLowerCase().equals("null")) {

						driver.findElement(By.id("MarketingName")).click();
						driver.findElement(By.id("MarketingName")).sendKeys(marketingName);
						waitForAngularPageToLoad();

					}
					driver.findElement(By.id("Manufacturer")).clear();

					driver.findElement(By.id("Manufacturer")).sendKeys(manufacturer);
					waitForAngularPageToLoad();

					String model = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
							.toString();

					driver.findElement(By.id("Model")).clear();

					driver.findElement(By.id("Model")).sendKeys(model);
					waitForAngularPageToLoad();

					String HeatingSourceTypeId = JsonUtils.getNestedJsonStringValueByKey(
							new JSONObject(libraryItemHeatSourceObject.toString()), "HeatingSourceTypeId").toString();

					selectByTextFromDropdown(driver.findElement(By.id("HeatingSourceTypeId")),
							By.xpath("//mat-option[@ref-value='" + HeatingSourceTypeId + "']"));
					waitForAngularPageToLoad();

					if (HeatingSourceTypeId.equalsIgnoreCase("6") || HeatingSourceTypeId.equalsIgnoreCase("4")
							|| HeatingSourceTypeId.equalsIgnoreCase("7") || HeatingSourceTypeId.equalsIgnoreCase("2")) {

						String dEAPWHSeasonalEfficiency = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libraryItemHeatSourceObject.toString()),
										"DEAPSeasonalEfficiency")
								.toString();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).clear();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).sendKeys(dEAPWHSeasonalEfficiency);

					}

					waitForAngularPageToLoad();

					driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
					waitForAngularPageToLoad();

					driver.findElement(By.xpath("//span[contains(text(),'" + marketingName + "')]")).click();
					waitForAngularPageToLoad();
					sleep(5000);
					waitForAngularPageToLoad();
					driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
					waitForAngularPageToLoad();

					String fuelTypeID = surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get("FuelTypeID"))
							.toString();
					selectByTextFromDropdown(
							driver.findElement(By.xpath("//*[@id='FuelTypeID' and @aria-required='true']")),
							By.xpath("//mat-option[@ref-value='" + fuelTypeID + "']"));

					String percentageOfHeat = surveySHHeatSourcePropertiesObjectList.get(i)
							.get(data.get(0).get("PercentageOfHeat")).toString();

					WebElement element = driver.findElement(By.id("PercentageOfHeat"));
					if (element.isDisplayed() && element.isEnabled()) {
						element.clear();
						element.sendKeys(percentageOfHeat);

						waitForAngularPageToLoad();
					}

					String linkToWaterCheckboxValue = String
							.valueOf(surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get("LinkToWater")))
							.trim();

					if (!(linkToWaterCheckboxValue.trim().equalsIgnoreCase("null"))) {
						WebElement linkToWaterCheckBox = driver.findElement(By.name("LinkToWater"));
						checkOrUncheck(linkToWaterCheckBox,
								surveySHHeatSourcePropertiesObjectList.get(i).get("LinkToWater").toString().trim());
					}

					driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
					waitForAngularPageToLoad();

				}

				// value 3 - method

				else if (libraryItemSourceIDValue.equalsIgnoreCase("3"))

				{
					driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]")).click();
					waitForAngularPageToLoad();
					driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]")).click();
					waitForAngularPageToLoad();
					String manufacturer = JsonUtils
							.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Manufacturer")
							.toString();

					selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
							By.xpath("//mat-option[@ref-value='" + libraryItemTypeIDValue + "']"));

					if (!marketingName.trim().toLowerCase().equals("null")) {

						driver.findElement(By.id("MarketingName")).click();
						driver.findElement(By.id("MarketingName")).sendKeys(marketingName);
						waitForAngularPageToLoad();

					}
					driver.findElement(By.id("Manufacturer")).clear();

					driver.findElement(By.id("Manufacturer")).sendKeys(manufacturer);
					waitForAngularPageToLoad();

					String model = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
							.toString();

					driver.findElement(By.id("Model")).clear();

					driver.findElement(By.id("Model")).sendKeys(model);
					waitForAngularPageToLoad();

					String HeatingSourceTypeId = JsonUtils.getNestedJsonStringValueByKey(
							new JSONObject(libraryItemHeatSourceObject.toString()), "HeatingSourceTypeId").toString();

					selectByTextFromDropdown(driver.findElement(By.id("HeatingSourceTypeId")),
							By.xpath("//mat-option[@ref-value='" + HeatingSourceTypeId + "']"));
					waitForAngularPageToLoad();

					if (HeatingSourceTypeId.equalsIgnoreCase("6") || HeatingSourceTypeId.equalsIgnoreCase("4")
							|| HeatingSourceTypeId.equalsIgnoreCase("7")) {

						String dEAPWHSeasonalEfficiency = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libraryItemHeatSourceObject.toString()),
										"DEAPSeasonalEfficiency")
								.toString();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).clear();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).sendKeys(dEAPWHSeasonalEfficiency);

					}

					waitForAngularPageToLoad();

					driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
					waitForAngularPageToLoad();

					driver.findElement(By.xpath("//span[contains(text(),'" + marketingName + "')]")).click();
					waitForAngularPageToLoad();
					sleep(5000);
					waitForAngularPageToLoad();
					driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
					waitForAngularPageToLoad();

					String fuelTypeID = surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get("FuelTypeID"))
							.toString();
					selectByTextFromDropdown(
							driver.findElement(By.xpath("//*[@id='FuelTypeID' and @aria-required='true']")),
							By.xpath("//mat-option[@ref-value='" + fuelTypeID + "']"));

					String percentageOfHeat = surveySHHeatSourcePropertiesObjectList.get(i)
							.get(data.get(0).get("PercentageOfHeat")).toString();

					WebElement element = driver.findElement(By.id("PercentageOfHeat"));
					if (element.isDisplayed() && element.isEnabled()) {
						element.clear();
						element.sendKeys(percentageOfHeat);

						waitForAngularPageToLoad();
					}

					String linkToWaterCheckboxValue = String
							.valueOf(surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get("LinkToWater")))
							.trim();

					if (!(linkToWaterCheckboxValue.trim().equalsIgnoreCase("null"))) {
						WebElement linkToWaterCheckBox = driver.findElement(By.name("LinkToWater"));
						checkOrUncheck(linkToWaterCheckBox,
								surveySHHeatSourcePropertiesObjectList.get(i).get("LinkToWater").toString().trim());
					}

					driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
					waitForAngularPageToLoad();

				}

				// value 2
				else if (libraryItemSourceIDValue.equalsIgnoreCase("2"))

				{

					// need to update sript

					driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]")).click();
					waitForAngularPageToLoad();
					driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]")).click();
					waitForAngularPageToLoad();
					String manufacturer = JsonUtils
							.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Manufacturer")
							.toString();
					selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
							By.xpath("//mat-option[@ref-value='" + libraryItemTypeIDValue + "']"));

					if (!marketingName.trim().toLowerCase().equals("null")) {

						driver.findElement(By.id("MarketingName")).click();
						driver.findElement(By.id("MarketingName")).sendKeys(marketingName);
						waitForAngularPageToLoad();

					}

					driver.findElement(By.id("Manufacturer")).clear();

					driver.findElement(By.id("Manufacturer")).sendKeys(manufacturer);
					waitForAngularPageToLoad();

					String model = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
							.toString();

					driver.findElement(By.id("Model")).clear();

					driver.findElement(By.id("Model")).sendKeys(model);
					waitForAngularPageToLoad();

					String HeatingSourceTypeId = JsonUtils.getNestedJsonStringValueByKey(
							new JSONObject(libraryItemHeatSourceObject.toString()), "HeatingSourceTypeId").toString();

					selectByTextFromDropdown(driver.findElement(By.id("HeatingSourceTypeId")),
							By.xpath("//mat-option[@ref-value='" + HeatingSourceTypeId + "']"));
					waitForAngularPageToLoad();

					if (HeatingSourceTypeId.equalsIgnoreCase("5")) {
						driver.findElement(By.xpath("//div[contains(text(),'Heat Pump Details')]")).click();

						String heatPumpTypeId = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(libraryItemHeatPumpObject.toString()), "HeatPumpTypeId").toString();

						System.out.println("heatPumpTypeId : " + heatPumpTypeId);
						waitForAngularPageToLoad();
						selectByTextFromDropdown(driver.findElement(By.id("HeatPumpTypeId")),
								By.xpath("//mat-option[@ref-value='" + heatPumpTypeId + "']"));

						String spaceHeatingStandardId = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libraryItemHeatPumpObject.toString()),
										"SpaceHeatingStandardId")
								.toString();

						selectByTextFromDropdown(driver.findElement(By.id("SpaceHeatingStandardId")),
								By.xpath("//mat-option[@ref-value='" + spaceHeatingStandardId + "']"));

						String waterHeatingStandardId = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libraryItemHeatPumpObject.toString()),
										"WaterHeatingStandardId")
								.toString();
						waitForAngularPageToLoad();
						selectByTextFromDropdown(driver.findElement(By.id("WaterHeatingStandardId")),
								By.xpath("//mat-option[@ref-value='" + waterHeatingStandardId + "']"));
						waitForAngularPageToLoad();
						String dEAPSeasonalEfficiency = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libraryItemHeatSourceObject.toString()),
										"DEAPSeasonalEfficiency")
								.toString();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).clear();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).sendKeys(dEAPSeasonalEfficiency);

						String dEAPWHSeasonalEfficiency = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libraryItemHeatSourceObject.toString()),
										"DEAPWHSeasonalEfficiency")
								.toString();

						driver.findElement(By.id("DEAPWHSeasonalEfficiency")).clear();

						driver.findElement(By.id("DEAPWHSeasonalEfficiency")).sendKeys(dEAPWHSeasonalEfficiency);

						String temperatureControlId = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libraryItemHeatPumpObject.toString()),
										"TemperatureControlId")
								.toString();

						selectByTextFromDropdown(driver.findElement(By.id("TemperatureControlId")),
								By.xpath("//mat-option[@ref-value='" + temperatureControlId + "']"));

						String TOL = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(libraryItemHeatPumpObject.toString()), "TOL").toString();

						driver.findElement(By.id("TOL")).clear();

						driver.findElement(By.id("TOL")).sendKeys(TOL);

						String WTOL = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(libraryItemHeatPumpObject.toString().trim()), "WTOL").toString();
						driver.findElement(By.id("WTOL")).clear();

						driver.findElement(By.id("WTOL")).sendKeys(WTOL);

						driver.findElement(By.xpath("//div[contains(text(),'Heat Pump Test Data')]")).click();

						waitForAngularPageToLoad();

						Object spaceHeatingTestDataObject = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(libraryItemHeatPumpObject.toString()),
								data.get(0).get("SpaceHeatingTestData"));

						Object spaceHeatingTestDataObject1 = JsonUtils.getNestedJsonStringValueByKey(json,
								data.get(0).get("SpaceHeatingTestData"));
						System.out.println("SpaceHeatingTestDataObject Object:" + spaceHeatingTestDataObject);

						List<HashMap<String, Object>> spaceHeatingTestDataObjectList = JsonUtils
								.getJsonArrayValueAsListOfMap(spaceHeatingTestDataObject);
						System.out.println("spaceHeatingTestDataObjectList List:" + spaceHeatingTestDataObjectList);

						for (int k = 0; k < spaceHeatingTestDataObjectList.size(); k++) {

							waitForAngularPageToLoad();
							String temperatureCategoryIdValue = String.valueOf(
									spaceHeatingTestDataObjectList.get(k).get(data.get(0).get("TemperatureCategoryId")))
									.trim();
							System.out.println("temperatureCategoryIdValue :" + temperatureCategoryIdValue);

							if (temperatureCategoryIdValue.equalsIgnoreCase("1")) {

								driver.findElement(By.xpath("//span[contains(text(),'Test Condition - Low (35°C)')]"))
										.click();

								waitForAngularLoad();

								String applicationHeatingCapacityA = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityA"))).trim();

								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityA'])[1]")),
										applicationHeatingCapacityA);

								String applicationHeatingCapacityB = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityB"))).trim();

								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityB'])[1]")),
										applicationHeatingCapacityB);

								String applicationHeatingCapacityC = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityC"))).trim();

								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityC'])[1]")),
										applicationHeatingCapacityC);

								String applicationHeatingCapacityD = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityD"))).trim();

								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityD'])[1]")),
										applicationHeatingCapacityD);

								String applicationHeatingCapacityE = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityE"))).trim();
								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityE'])[1]")),
										applicationHeatingCapacityE);

								String applicationHeatingCoefficientOfPerformanceA = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceA")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceA'])[1]")),
										applicationHeatingCoefficientOfPerformanceA);

								String applicationHeatingCoefficientOfPerformanceB = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceB")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceB'])[1]")),
										applicationHeatingCoefficientOfPerformanceB);

								String applicationHeatingCoefficientOfPerformanceC = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceC")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceC'])[1]")),
										applicationHeatingCoefficientOfPerformanceC);

								String applicationHeatingCoefficientOfPerformanceD = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceD")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceD'])[1]")),
										applicationHeatingCoefficientOfPerformanceD);

								String applicationHeatingCoefficientOfPerformanceE = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceE")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceE'])[1]")),
										applicationHeatingCoefficientOfPerformanceE);

							}
							if (temperatureCategoryIdValue.equalsIgnoreCase("3")) {

								driver.findElement(
										By.xpath("//span[contains(text(),'Test Condition - Medium (55°C)')]")).click();

								waitForAngularLoad();

								String applicationHeatingCapacityA = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityA"))).trim();

								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityA'])[3]")),
										applicationHeatingCapacityA);

								String applicationHeatingCapacityB = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityB"))).trim();

								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityB'])[3]")),
										applicationHeatingCapacityB);

								String applicationHeatingCapacityC = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityC"))).trim();

								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityC'])[3]")),
										applicationHeatingCapacityC);

								String applicationHeatingCapacityD = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityD"))).trim();

								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityD'])[3]")),
										applicationHeatingCapacityD);

								String applicationHeatingCapacityE = String.valueOf(spaceHeatingTestDataObjectList
										.get(k).get(data.get(0).get("ApplicationHeatingCapacityE"))).trim();
								clickClearSendKeys(
										driver.findElement(By.xpath("(//*[@id='ApplicationHeatingCapacityE'])[3]")),
										applicationHeatingCapacityE);

								String applicationHeatingCoefficientOfPerformanceA = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceA")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceA'])[3]")),
										applicationHeatingCoefficientOfPerformanceA);

								String applicationHeatingCoefficientOfPerformanceB = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceB")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceB'])[3]")),
										applicationHeatingCoefficientOfPerformanceB);

								String applicationHeatingCoefficientOfPerformanceC = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceC")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceC'])[3]")),
										applicationHeatingCoefficientOfPerformanceC);

								String applicationHeatingCoefficientOfPerformanceD = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceD")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceD'])[3]")),
										applicationHeatingCoefficientOfPerformanceD);

								String applicationHeatingCoefficientOfPerformanceE = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("ApplicationHeatingCoefficientOfPerformanceE")))
										.trim();

								clickClearSendKeys(
										driver.findElement(By
												.xpath("(//*[@id='ApplicationHeatingCoefficientOfPerformanceE'])[3]")),
										applicationHeatingCoefficientOfPerformanceE);

							}

						}

						String waterHeatingTestDataObject = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libraryItemHeatPumpObject.toString()),
										"WaterHeatingTestData")
								.toString();

						System.out.println("waterHeatingTestDataObject : " + waterHeatingTestDataObject);

						String waterHeatingSourceOfDataId = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(waterHeatingTestDataObject.toString()),
										"WaterHeatingSourceOfDataId")
								.toString();

						System.out.println("waterHeatingSourceOfDataId : " + waterHeatingSourceOfDataId);

						selectByTextFromDropdown(driver.findElement(By.id("WaterHeatingSourceOfDataId")),
								By.xpath("//mat-option[@ref-value='" + waterHeatingSourceOfDataId + "']"));
						waitForAngularPageToLoad();

						String waterHeatingEfficiency = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(waterHeatingTestDataObject.toString()),
										"WaterHeatingEfficiency")
								.toString();

						System.out.println("waterHeatingEfficiency : " + waterHeatingEfficiency);

						driver.findElement(By.name("WaterHeatingEfficiency")).click();
						driver.findElement(By.name("WaterHeatingEfficiency")).clear();
						driver.findElement(By.name("WaterHeatingEfficiency")).sendKeys(waterHeatingEfficiency);

						String referenceHotWaterTemperature = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(waterHeatingTestDataObject.toString().trim()),
								"ReferenceHotWaterTemperature").toString();

						driver.findElement(By.name("ReferenceHotWaterTemperature")).click();
						driver.findElement(By.name("ReferenceHotWaterTemperature")).clear();
						driver.findElement(By.name("ReferenceHotWaterTemperature"))
								.sendKeys(referenceHotWaterTemperature);

						String capacityOfHeatPump = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(waterHeatingTestDataObject.toString().trim()), "CapacityOfHeatPump")
								.toString();

						driver.findElement(By.name("CapacityOfHeatPump")).click();
						driver.findElement(By.name("CapacityOfHeatPump")).clear();
						driver.findElement(By.name("CapacityOfHeatPump")).sendKeys(capacityOfHeatPump);

						waitForAngularPageToLoad();

						String declaredLoadProfileId = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(waterHeatingTestDataObject.toString()),
										"DeclaredLoadProfileId")
								.toString();

						selectByTextFromDropdown(driver.findElement(By.id("DeclaredLoadProfileId")),
								By.xpath("//mat-option[@ref-value='" + declaredLoadProfileId + "']"));
						waitForAngularPageToLoad();

						String standByHeatLoss = JsonUtils
								.getNestedJsonStringValueByKey(
										new JSONObject(waterHeatingTestDataObject.toString().trim()), "StandByHeatLoss")
								.toString();

						driver.findElement(By.name("StandByHeatLoss")).click();
						driver.findElement(By.name("StandByHeatLoss")).clear();
						driver.findElement(By.name("StandByHeatLoss")).sendKeys(standByHeatLoss);

						// clickClearSendKeys(driver.findElement(By.id("(StandByHeatLoss")),standByHeatLoss);

						String volumeOfDHW = JsonUtils
								.getNestedJsonStringValueByKey(
										new JSONObject(waterHeatingTestDataObject.toString().trim()), "VolumeOfDHW")
								.toString();

						driver.findElement(By.name("VolumeOfDHW")).click();
						driver.findElement(By.name("VolumeOfDHW")).clear();
						driver.findElement(By.name("VolumeOfDHW")).sendKeys(volumeOfDHW);

						// clickClearSendKeys(driver.findElement(By.id("(VolumeOfDHW")),volumeOfDHW);

						driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
						waitForAngularPageToLoad();

						driver.findElement(By.xpath("//span[text()='" + marketingName + "']")).click();

						waitForAngularPageToLoad();
						driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
						waitForAngularPageToLoad();
						sleep(2000);

						String linkToWaterCheckboxValue = String.valueOf(
								surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get("LinkToWater")))
								.trim();

						if (!(linkToWaterCheckboxValue.trim().equalsIgnoreCase("null"))) {
							WebElement linkToWaterCheckBox = driver.findElement(By.name("LinkToWater"));
							checkOrUncheck(linkToWaterCheckBox,
									surveySHHeatSourcePropertiesObjectList.get(i).get("LinkToWater").toString().trim());
						}

						WebElement linkToWaterCheckBox = driver.findElement(By.name("LinkToWater"));

						driver.findElement(By.id("DesignFlowTemperature")).click();
						driver.findElement(By.id("DesignFlowTemperature")).clear();
						driver.findElement(By.id("DesignFlowTemperature")).sendKeys(designFlowTemperatureValue);

						String dailyOperationHours = String.valueOf(surveySHHeatSourcePropertiesObjectList.get(i)
								.get(data.get(0).get("DailyOperationHours"))).trim();

						System.out.println("libItem designFlowTemperature:" + dailyOperationHours);

						String dailyOperationHoursValue = String.valueOf(dailyOperationHours.toString()).trim();

						selectByTextFromDropdown(driver.findElement(By.id("DailyOperationHours")),
								By.xpath("//mat-option[@ref-value='" + dailyOperationHoursValue + "']"));
						waitForAngularPageToLoad();

						Object surveyWHStorageTypesObject = JsonUtils.getNestedJsonStringValueByKey(json,
								data.get(0).get("SurveyWHStorageTypes"));
						System.out.println("surveyWHStorageTypesObject Object" + surveyWHStorageTypesObject);

						List<HashMap<String, Object>> surveyWHStorageTypesObjectList = JsonUtils
								.getJsonArrayValueAsListOfMap(surveyWHStorageTypesObject);
						System.out.println("surveyWHStorageTypes Object List:" + surveyWHStorageTypesObjectList);

						for (int h = 0; h < surveyWHStorageTypesObjectList.size(); h++) {

							if (!(linkToWaterCheckboxValue.trim().equalsIgnoreCase("null"))) {

								String domesticHotWaterStorageIdValue = String.valueOf(surveyWHStorageTypesObjectList
										.get(h).get(data.get(0).get("DomesticHotWaterStorageId"))).trim();

								if (!(domesticHotWaterStorageIdValue.trim().equalsIgnoreCase("null"))) {

									selectByTextFromDropdown(driver.findElement(By.id("DomesticHotWaterStorageId")),
											By.xpath("//mat-option[@ref-value='" + domesticHotWaterStorageIdValue
													+ "']"));
								}
							}

						}

						driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
						waitForAngularPageToLoad();

					}

					if (HeatingSourceTypeId.equalsIgnoreCase("6")) {

						String dEAPWHSeasonalEfficiency = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libraryItemHeatSourceObject.toString()),
										"DEAPSeasonalEfficiency")
								.toString();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).clear();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).sendKeys(dEAPWHSeasonalEfficiency);
						driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

						waitForAngularPageToLoad();
						sleep(2000);

						driver.findElement(By.xpath("//span[contains(text(),'" + marketingName + "')]")).click();
						waitForAngularPageToLoad();

						waitForAngularPageToLoad();
						driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
						waitForAngularPageToLoad();

						String fuelTypeID = surveySHHeatSourcePropertiesObjectList.get(i)
								.get(data.get(0).get("FuelTypeID")).toString();
						selectByTextFromDropdown(
								driver.findElement(By.xpath("//*[@id='FuelTypeID' and @aria-required='true']")),
								By.xpath("//mat-option[@ref-value='" + fuelTypeID + "']"));

						String percentageOfHeat = surveySHHeatSourcePropertiesObjectList.get(i)
								.get(data.get(0).get("PercentageOfHeat")).toString();

						WebElement element = driver.findElement(By.id("PercentageOfHeat"));
						if (element.isDisplayed() && element.isEnabled()) {
							element.clear();
							element.sendKeys(percentageOfHeat);

							waitForAngularPageToLoad();
						}

						driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
						waitForAngularPageToLoad();

					}

				}

			}

		}

	}

	@Then("Summer Internal Temperature Page")
	public void summer_internal_temperature_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(5000);
		driver.findElement(By.id("summer-tab")).click();
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveySHGainLossesObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveySHSummers"));

		List<HashMap<String, Object>> surveySHGainLossesObjectPropertiesList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveySHGainLossesObject);

		for (int i = 0; i < surveySHGainLossesObjectPropertiesList.size(); i++) {

			String airChangeRate = String
					.valueOf(surveySHGainLossesObjectPropertiesList.get(i).get(data.get(0).get("AirChangeRate")))
					.trim();
			String summerMeanExternal = String
					.valueOf(surveySHGainLossesObjectPropertiesList.get(i).get(data.get(0).get("SummerMeanExternal")))
					.trim();

			waitForAngularPageToLoad();

			/*
			 * String airChangeRate = JsonUtils .getNestedJsonStringValueByKey(new
			 * JSONObject(surveySHGainLossesObject.toString()), "AirChangeRate")
			 * .toString();
			 * 
			 * 
			 * String summerMeanExternal = JsonUtils.getNestedJsonStringValueByKey( new
			 * JSONObject(surveySHGainLossesObject.toString()),
			 * "SummerMeanExternal").toString();
			 */

			if (!airChangeRate.trim().toLowerCase().equals("null")) {

				driver.findElement(By.name("AirChangeRate")).clear();
				driver.findElement(By.name("AirChangeRate")).sendKeys(airChangeRate);
				waitForAngularPageToLoad();
				driver.findElement(By.name("SummerMeanExternal")).clear();
				driver.findElement(By.name("SummerMeanExternal")).sendKeys(summerMeanExternal);

				waitForAngularPageToLoad();
			}

		}
	}

	@Then("CONTROLS AND RESPONSIVENESS in SPACE HEATING details Page")
	public void controls_and_responsiveness_in_space_heating_details_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		Actions actions = new Actions(driver);

		WebElement menuOption = driver
				.findElement(By.xpath("//md-list[@ng-if='s.viewData.access.canViewSurvey']/md-list-item[4]"));

		actions.moveToElement(menuOption).perform();

		sleep(1000);

		driver.findElement(By.xpath("//a[@aria-label='Space Heating']")).click();

		sleep(5000);

		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			// driver.findElement(By.xpath("//md-radio-button[@aria-label='" + vList.get(0)
			// + "']")).click();

			// need alternatce value
			selectByTextFromDropdown(driver.findElement(By.id("HeatingSystemCategoryID")),
					By.xpath("//md-option[contains(@ng-repeat,'shcr.refProp.categories')]"), vList.get(1));
			sleep(3000);

			selectByTextFromDropdown(
					driver.findElement(
							By.xpath("//md-select[contains(@ng-model,'shcr.refProp.ctrl.hsProp.SubCategory1ID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'shcr.refProp.subCategories1')]"), vList.get(2));

			selectByTextFromDropdown(driver.findElement(By.id("HeatingSystem")),
					By.xpath("//md-option[contains(@ng-repeat,'shcr.refProp.heatingSystems')]"), vList.get(3));

			selectByTextFromDropdown(driver.findElement(By.id("HeatingSystemControlsID")),
					By.xpath("//md-option[contains(@ng-repeat,'shcr.refProp.controls')]"), vList.get(4));

		}

	}

	@Then("PUMPS AND FANS details")
	public void pumps_and_fans_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);
			sleep(2000);
			driver.findElement(By.xpath("//md-tab-item[contains(text(),'PUMPS AND FANS')]")).click();
			sleep(5000);

			sleep(2000);
			driver.findElement(By.name("PumpsCentralHeating")).clear();
			driver.findElement(By.name("PumpsCentralHeating")).sendKeys(vList.get(1));

			driver.findElement(By.name("PumpsOilBoiler")).clear();
			driver.findElement(By.name("PumpsOilBoiler")).sendKeys(vList.get(2));

			driver.findElement(By.name("PumpsGasBoilerFlueFan")).clear();
			driver.findElement(By.name("PumpsGasBoilerFlueFan")).sendKeys(vList.get(3));

			WebElement controlledbyRoomThermostat = driver
					.findElement(By.xpath("//md-checkbox[@name='CentralHeatingThermostat']"));

			if (UnCheck(controlledbyRoomThermostat)) {
				controlledbyRoomThermostat.click();
				sleep(2000);
			}

			// need xpath
			WebElement controlledbyRoomThermostat2 = driver
					.findElement(By.xpath("//md-checkbox[@aria-label='Boiler Controlled by Room Thermostat']"));

			if (UnCheck(controlledbyRoomThermostat2)) {
				controlledbyRoomThermostat2.click();
				sleep(2000);
			}

			WebElement insideDwelling = driver.findElement(By.xpath("//md-checkbox[@aria-label='Inside Dwelling']"));

			if (UnCheck(insideDwelling)) {
				insideDwelling.click();
				sleep(2000);
			}
			WebElement insideDwelling2 = driver.findElement(By.xpath("//md-checkbox[@aria-label='Inside Dwelling']"));

			if (UnCheck(insideDwelling2)) {
				insideDwelling2.click();
				sleep(2000);
			}

			driver.findElement(By.name("CentralHeatingTotalElectirc")).clear();
			driver.findElement(By.name("CentralHeatingTotalElectirc")).sendKeys(vList.get(8));

			WebElement warmAirHeating = driver.findElement(
					By.xpath("//md-checkbox[@aria-label='Warm Air Heating Or Fan Coil Radiators Present']"));

			if (UnCheck(warmAirHeating)) {
				warmAirHeating.click();
				sleep(3000);
			}
		}
	}

	@Then("select HEAT SOURCES details")
	public void select_heat_sources_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(By.xpath("//md-tab-item[contains(text(),'HEAT SOURCES')]")).click();
			sleep(4000);

			driver.findElement(By.xpath("//button[@aria-label='Add Heat Source']")).click();
			sleep(3000);

			driver.findElement(By.xpath("//div/h3/span[(text()='" + vList.get(0) + "')]")).click();
			sleep(1000);
			driver.findElement(By.xpath("//button[@aria-label='Add Selected Items']")).click();
			sleep(5000);

			selectByTextFromDropdown(driver.findElement(By.id("heatSourceFuelTypeID")),
					By.xpath("//md-option[contains(@ng-repeat,'hsd.refData.heating.FuelType')]"), vList.get(1));

		}
		driver.findElement(By.xpath("//button/span[text()='Save']")).click();
		sleep(5000);
	}

	@Then("CHP Details")
	public void chp_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			selectByTextFromDropdown(driver.findElement(By.name("FuelTypeID")),
					By.xpath("//md-option[contains(@ng-repeat,'shhs.refData.heating.FuelType')]"), vList.get(0));

			sleep(2000);
			driver.findElement(By.name("FractionFromCHP")).clear();
			driver.findElement(By.name("FractionFromCHP")).sendKeys(vList.get(1));

			driver.findElement(By.name("HeatEfficiency")).clear();
			driver.findElement(By.name("HeatEfficiency")).sendKeys(vList.get(2));

			driver.findElement(By.name("ElectricalEfficiency")).clear();
			driver.findElement(By.name("ElectricalEfficiency")).sendKeys(vList.get(3));

		}

	}

	@Then("SUMMER INTERNAL TEMP Details")
	public void summer_internal_temp_details(io.cucumber.datatable.DataTable dataTable) {

		sleep(2000);
		driver.findElement(By.xpath("//md-tab-item[contains(text(),'SUMMER INTERNAL TEMP')]")).click();
		sleep(4000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(By.name("AirChangeRate")).clear();
			driver.findElement(By.name("AirChangeRate")).sendKeys(vList.get(0));

			driver.findElement(By.name("SummerMeanExternal")).clear();
			driver.findElement(By.name("SummerMeanExternal")).sendKeys(vList.get(1));

		}

	}

	@Then("Add shower and Baths in Water Heater Details page")
	public void add_shower_and_baths_in_water_heater_details_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		Actions actions = new Actions(driver);

		WebElement menuOption = driver
				.findElement(By.xpath("//md-list[@ng-if='s.viewData.access.canViewSurvey']/md-list-item[5]"));
		sleep(3000);
		actions.moveToElement(menuOption).perform();
		sleep(1000);
		driver.findElement(By.xpath("//a[@aria-label='Water Heating']")).click();
		sleep(4000);

		driver.findElement(By.xpath("//button[@aria-label='Add Showers & Baths']")).click();

		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);
			driver.findElement(By.xpath("//div/h3/span[contains(text(),'" + vList.get(0) + "')]")).click();
			sleep(1000);
		}

		driver.findElement(By.xpath("//button[@aria-label='Add Selected Items']")).click();
		sleep(2000);

	}

	@Then("Edit shower and Baths Details")
	public void edit_shower_and_baths_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 0; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(
					By.xpath("//div[contains(@class,'data-cell shower-name flex')][./span[.='" + vList.get(0) + "']]"))
					.click();
			sleep(2000);
			driver.findElement(By.name("Number")).clear();
			driver.findElement(By.name("Number")).sendKeys(vList.get(1));

			selectByTextFromDropdown(driver.findElement(By.xpath("//md-select[contains(@ng-model,'sid.item.RoomID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.data.surveyDetails.SurveyRooms')]"), vList.get(2));

			driver.findElement(By.name("Description")).clear();
			driver.findElement(By.name("Description")).sendKeys(vList.get(3));
			driver.findElement(By.xpath("//button[@aria-label='Save']")).click();
			sleep(2000);

		}

	}

	@Then("Options details")
	public void options_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 0; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			WebElement Distribution = driver.findElement(By.name("Distribution"));

			if (UnCheck(Distribution)) {
				Distribution.click();
				sleep(3000);
			}

			WebElement Storage = driver.findElement(By.name("Storage"));

			if (UnCheck(Storage)) {
				Storage.click();
				sleep(3000);
			}

			WebElement ElecImmersionInSummer = driver.findElement(By.name("ElecImmersionInSummer"));

			if (UnCheck(ElecImmersionInSummer)) {
				ElecImmersionInSummer.click();
				sleep(3000);
			}

			WebElement IsCombiBoiler = driver.findElement(By.name("IsCombiBoiler"));

			if (UnCheck(IsCombiBoiler)) {
				IsCombiBoiler.click();
				sleep(3000);
			}

		}

	}

	@Then("Storage details")
	public void storage_details(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 0; i < lists.size(); i++) {
			List<String> vList = lists.get(i);
			WebElement StorageIndoorGroupScheme = driver.findElement(By.name("StorageIndoorGroupScheme"));

			if (UnCheck(StorageIndoorGroupScheme)) {
				StorageIndoorGroupScheme.click();
				sleep(3000);
			}

			selectByTextFromDropdown(driver.findElement(By.name("WaterStorageID")),
					By.xpath("//md-option[contains(@ng-value,'st.WaterStorageID')]"), vList.get(1));

			driver.findElement(By.name("StorageVolume")).clear();
			driver.findElement(By.name("StorageVolume")).sendKeys(vList.get(2));

			WebElement IsManuLossAvailable = driver.findElement(By.name("IsManuLossAvailable"));

			if (UnCheck(IsManuLossAvailable)) {
				IsManuLossAvailable.click();
				sleep(3000);
			}

			driver.findElement(By.name("MakeModel")).clear();
			driver.findElement(By.name("MakeModel")).sendKeys(vList.get(3));

			driver.findElement(By.name("DeclaredLoss")).clear();
			driver.findElement(By.name("DeclaredLoss")).sendKeys(vList.get(4));

			selectByTextFromDropdown(driver.findElement(By.name("SystemTypeID")),
					By.xpath("//md-option[contains(@ng-value,'cl.SystemTypeID')]"), vList.get(5));

			WebElement LowWaterUsage = driver.findElement(By.name("LowWaterUsage"));

			if (UnCheck(LowWaterUsage)) {
				LowWaterUsage.click();
				sleep(3000);
			}

		}

	}

	@Then("Combi Boiler")
	public void combi_boiler(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 0; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			selectByTextFromDropdown(driver.findElement(By.name("CombiID")),
					By.xpath("//md-option[contains(@ng-value,'cbl.CombiID']"), vList.get(0));
			sleep(3000);

			selectByTextFromDropdown(driver.findElement(By.name("KeepHotID")),
					By.xpath("//md-option[contains(@ng-value,'kh.KeepHotID']"), vList.get(1));

			sleep(2000);

			driver.findElement(By.name("AdditionalLoss")).clear();
			driver.findElement(By.name("AdditionalLoss")).sendKeys(vList.get(2));

			driver.findElement(By.name("KeepHotConsumption")).clear();
			driver.findElement(By.name("KeepHotConsumption")).sendKeys(vList.get(3));

		}
	}

	@Then("Solar Details")
	public void solar_details(io.cucumber.datatable.DataTable dataTable) {
		driver.findElement(By.xpath("//md-tab-item[contains(text(),'SOLAR')]")).click();
		sleep(4000);

		driver.findElement(By.xpath("//button[@aria-label='Add Solar Collector']")).click();

		sleep(2000);

		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 0; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(By.xpath("//div/h3/span[contains(text(),'" + vList.get(0) + "')]")).click();
			sleep(3000);
			driver.findElement(By.xpath("//button[@aria-label='Add Selected Items']")).click();
			sleep(3000);

			driver.findElement(By.name("ApetureAreaOfCollector")).clear();
			driver.findElement(By.name("ApetureAreaOfCollector")).sendKeys(vList.get(1));

			driver.findElement(By.name("DedicatedStorageVolume")).clear();
			driver.findElement(By.name("DedicatedStorageVolume")).sendKeys(vList.get(2));

			driver.findElement(By.name("AnnualSolarRadiation")).clear();
			driver.findElement(By.name("AnnualSolarRadiation")).sendKeys(vList.get(3));

			driver.findElement(By.name("OvershadingFactor")).clear();
			driver.findElement(By.name("OvershadingFactor")).sendKeys(vList.get(3));

			WebElement CylinderStat = driver.findElement(By.xpath("//md-checkbox[@aria-label='Cylinder Stat']"));

			// CheckOrUnCheck(CylinderStat, vList.get(4));

			sleep(3000);
			/*
			 * if (UnCheck(CylinderStat)) { CylinderStat.click(); sleep(3000); }
			 */
			WebElement PumpSolarPowered = driver
					.findElement(By.xpath("//md-checkbox[@aria-label='Pump Solar Powered']"));

			if (UnCheck(PumpSolarPowered)) {
				PumpSolarPowered.click();
				sleep(3000);
			}
			/*
			 * WebElement StorageContainedcombinedCylinder = driver .findElement(By.
			 * xpath("//md-checkbox[@aria-label='Storage Contained within a combined Cylinder']"
			 * ));
			 * 
			 * //CheckOrUnCheck(StorageContainedcombinedCylinder, vList.get(5));
			 */
			/*
			 * if (UnCheck(StorageContainedcombinedCylinder)) {
			 * StorageContainedcombinedCylinder.click(); sleep(3000); }
			 */
			driver.findElement(By.xpath("//button/span[text()='Save']")).click();
			sleep(5000);
		}
	}

	@Then("HEAT SOURCE Details")
	public void heat_source_details(io.cucumber.datatable.DataTable dataTable) {
		driver.findElement(By.xpath("//md-tab-item[contains(text(),'HEAT SOURCE')]")).click();
		sleep(4000);

		driver.findElement(By.xpath("//button[@aria-label='Add Heat Source']")).click();

		sleep(2000);

		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 0; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(By.xpath("//div/h3/span[contains(text(),'" + vList.get(0) + "')]")).click();
			sleep(3000);
			driver.findElement(By.xpath("//button[@aria-label='Add Selected Items']")).click();
			sleep(3000);

			driver.findElement(By.name("AdjustmentFactorBasis")).clear();
			driver.findElement(By.name("AdjustmentFactorBasis")).sendKeys(vList.get(1));

			driver.findElement(By.xpath("//button/span[text()='Save']")).click();
			sleep(5000);
		}

	}

	@Then("COOLING SYSTEMS Details in Water Heater")
	public void cooling_systems_details_in_water_heater(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		Actions actions = new Actions(driver);

		WebElement menuOption = driver
				.findElement(By.xpath("//md-list[@ng-if='s.viewData.access.canViewSurvey']/md-list-item[5]"));

		actions.moveToElement(menuOption).perform();

		sleep(1000);

		driver.findElement(By.xpath("//a[@aria-label='Space Cooling']")).click();

		sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='Add Cooling Sysytem']")).click();

		sleep(2000);

		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(By.name("CoolingSystemManufacturer")).clear();
			driver.findElement(By.name("CoolingSystemManufacturer")).sendKeys(vList.get(1));

			driver.findElement(By.name("CoolingSystemModel")).clear();
			driver.findElement(By.name("CoolingSystemModel")).sendKeys(vList.get(2));

			selectByTextFromDropdown(driver.findElement(By.name("CoolingSystemFuelType")),
					By.xpath("//md-option[contains(@ng-value,'c.FuelTypeID')]"), vList.get(3));

			sleep(2000);

			driver.findElement(By.name("CoolingSystemSeasonalEnergyEfficiencyRatio")).clear();
			driver.findElement(By.name("CoolingSystemSeasonalEnergyEfficiencyRatio")).sendKeys(vList.get(4));
		}

	}

	@Then("Configure lighting in lighting details Page")
	public void configure_lighting_in_lighting_details_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		Actions actions = new Actions(driver);

		WebElement menuOption = driver
				.findElement(By.xpath("//md-list[@ng-if='s.viewData.access.canViewSurvey']/md-list-item[6]"));

		actions.moveToElement(menuOption).perform();

		sleep(1000);

		driver.findElement(By.xpath("//a[@aria-label='Lighting']")).click();

		sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='Add Bulb']")).click();

		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);
			driver.findElement(By.xpath("//div/h3/span[contains(text(),'" + vList.get(0) + "')]")).click();
			sleep(1000);
		}

		driver.findElement(By.xpath("//button[@aria-label='Add Selected Items']")).click();
		sleep(2000);

	}

	@Then("edit lighting in lighting details Page")
	public void edit_lighting_in_lighting_details_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 0; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(
					By.xpath("//div[contains(@class,'data-cell bulb-name flex')]/span[text()='" + vList.get(0) + "']"))
					.click();
			sleep(2000);
			driver.findElement(By.name("Number")).clear();
			driver.findElement(By.name("Number")).sendKeys(vList.get(1));

			selectByTextFromDropdown(driver.findElement(By.xpath("//md-select[contains(@ng-model,'sid.item.RoomID')]")),
					By.xpath("//md-option[contains(@ng-repeat,'sid.data.surveyDetails.SurveyRooms')]"), vList.get(2));

			driver.findElement(By.name("Description")).clear();
			driver.findElement(By.name("Description")).sendKeys(vList.get(3));
			driver.findElement(By.xpath("//button[@aria-label='Save']")).click();
			sleep(2000);

		}

	}

	@Then("RENEWABLES details Page")
	public void renewables_details_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		Actions actions = new Actions(driver);

		WebElement menuOption = driver
				.findElement(By.xpath("//md-list[@ng-if='s.viewData.access.canViewSurvey']/md-list-item[7]"));

		actions.moveToElement(menuOption).perform();

		sleep(1000);

		driver.findElement(By.xpath("//a[@aria-label='Renewables']")).click();

		sleep(5000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			List<String> vList = lists.get(i);

			driver.findElement(
					By.xpath("//md-radio-button[contains(@aria-label,'On-site energy-saving (non-renewable)')]"))
					.click();

			List<WebElement> energyProducedOrSavedList = driver.findElements(By.name("RenewableEnergyProducedOrSaved"));
			energyProducedOrSavedList.get(i - 1).clear();
			energyProducedOrSavedList.get(i - 1).sendKeys(vList.get(1));

			List<WebElement> energyConsumedList = driver.findElements(By.name("EnergyConsumed"));
			energyConsumedList.get(i - 1).clear();
			energyConsumedList.get(i - 1).sendKeys(vList.get(2));

			List<WebElement> renewableProducedDeliveredEnergyList = driver
					.findElements(By.name("RenewableProducedDeliveredEnergy"));
			renewableProducedDeliveredEnergyList.get(i - 1).clear();
			renewableProducedDeliveredEnergyList.get(i - 1).sendKeys(vList.get(3));

			driver.findElement(By.name("RenewableProducedDeliveredEnergy")).clear();
			driver.findElement(By.name("RenewableProducedDeliveredEnergy")).sendKeys(vList.get(4));

			driver.findElement(By.name("ConsumedDeliveredEnergy")).clear();

			driver.findElement(By.name("ConsumedDeliveredEnergy")).sendKeys(vList.get(5));

			driver.findElement(By.name("ConsumedPrimaryConversionFactor")).clear();
			driver.findElement(By.name("ConsumedPrimaryConversionFactor")).sendKeys(vList.get(6));

			selectByTextFromDropdown(driver.findElement(By.name("RenewableEnerProdFuel")),
					By.xpath("//md-option[contains(@ng-value,'c.FuelTypeID')]"), vList.get(7));

			driver.findElement(By.name("ConsumedCo2EmissionFactor")).clear();
			driver.findElement(By.name("ConsumedCo2EmissionFactor")).sendKeys(vList.get(8));

			sleep(5000);
		}

	}

	@Given("Water Heating Page")
	public void water_heating_page() {
		sleep(5000);
		hoverOpenNavigation();
		Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(By.xpath("//div[normalize-space()='Water Heating']"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();

		waitForAngularPageToLoad();

	}

	@Then("Heat Source details in Water Heating Page")
	public void heat_source_details_in_water_heating_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);

		WebElement addHeatSourceButton = driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]/.."));

		// boolean disabledStatus =
		// addHeatSourceButton.getAttribute("disabled").trim().toLowerCase().equals("true");
		//
		// if (disabledStatus == false) {

		// WebElement addHeatSourceButton =
		// driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]"));

		System.out.println("isenabled:" + addHeatSourceButton.isEnabled());
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyWHHeatSourcePropertiesObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveyWHHeatSources"));

		System.out.println("surveyWHHeatSourceProperties Object" + surveyWHHeatSourcePropertiesObject);

		List<HashMap<String, Object>> surveyWHHeatSourcePropertiesObjectList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveyWHHeatSourcePropertiesObject);
		System.out.println("surveyWHHeatSourcePropertiesObject List" + surveyWHHeatSourcePropertiesObjectList);

		System.out.println("surveyWHHeatSourcePropertiesObject List Count:"
				+ surveyWHHeatSourcePropertiesObjectList.size());

		for (int i = 0; i < surveyWHHeatSourcePropertiesObjectList.size(); i++) {

			JSONObject libItem = new JSONObject(surveyWHHeatSourcePropertiesObjectList.get(i)
					.get(data.get(0).get("LibraryItem")).toString());

			String designFlowTemperature = String.valueOf(
					surveyWHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get("DesignFlowTemperature")))
					.trim();

			System.out.println("designFlowTemperature : " + designFlowTemperature);

			System.out.println("libItem designFlowTemperature:" + designFlowTemperature);

			String designFlowTemperatureValue = String.valueOf(designFlowTemperature.toString()).trim();

			Object libObject = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("LibraryItemTypeID"));
			Object libObject2 = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("LibraryItemSourceID"));

			Object libraryItemHeatSourceObject = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("LibraryItemHeatSource"));

			Object libraryItemHeatPumpObject = JsonUtils.getNestedJsonStringValueByKey(
					new JSONObject(libraryItemHeatSourceObject.toString()),
					data.get(0).get("LibraryItemHeatPump"));

			String HeatingSourceTypeId = JsonUtils.getNestedJsonStringValueByKey(
					new JSONObject(libraryItemHeatSourceObject.toString()), "HeatingSourceTypeId").toString();

			/*
			 * String designFlowTemperature = String.valueOf(
			 * surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get(
			 * "DesignFlowTemperature"))) .trim();
			 */

			String libraryItemTypeIDValue = String.valueOf(libObject.toString()).trim();
			String libraryItemSourceIDValue = String.valueOf(libObject2.toString()).trim();
			System.out.println("libraryItemTypeID  Value " + libraryItemTypeIDValue);
			System.out.println("libraryItemSourceIDValue  Value " + libraryItemSourceIDValue);
			String marketingName = JsonUtils
					.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "MarketingName")
					.toString();

			if (libraryItemTypeIDValue.equalsIgnoreCase("8"))

			{

				if (libraryItemSourceIDValue.equalsIgnoreCase("1")
						|| libraryItemSourceIDValue.equalsIgnoreCase("3")) {

					if (marketingName.equalsIgnoreCase("Electric immersion (on-peak or off-peak)"))

					{

						if (!marketingName.trim().toLowerCase().equals("null")) {
							sleep(2000);

							driver.findElement(By.xpath("//span[contains(text(),'" + marketingName + "')]"))
									.click();
							waitForAngularPageToLoad();

						}
						waitForAngularPageToLoad();
						driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
						waitForAngularPageToLoad();
						sleep(2000);

						driver.findElement(By.name("AdjustmentFactorBasis")).clear();
						driver.findElement(By.name("AdjustmentFactorBasis")).sendKeys("1");
						waitForAngularPageToLoad();
						driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
						waitForAngularPageToLoad();

					}

					else if (HeatingSourceTypeId.equalsIgnoreCase("4")) {

						sleep(2000);
						driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]")).click();
						waitForAngularPageToLoad();

						driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]"))
								.click();
						waitForAngularPageToLoad();

						selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
								By.xpath("//mat-option[@ref-value='" + libraryItemTypeIDValue + "']"));

						if (!marketingName.trim().toLowerCase().equals("null")) {

							driver.findElement(By.id("MarketingName")).click();
							driver.findElement(By.id("MarketingName")).sendKeys(marketingName);
							waitForAngularPageToLoad();

						}

						String manufacturer = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(libItem.toString()), "Manufacturer").toString();

						driver.findElement(By.id("Manufacturer")).clear();

						driver.findElement(By.id("Manufacturer")).sendKeys(manufacturer);
						waitForAngularPageToLoad();

						String model = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
								.toString();

						driver.findElement(By.id("Model")).clear();

						driver.findElement(By.id("Model")).sendKeys(model);
						waitForAngularPageToLoad();

						selectByTextFromDropdown(driver.findElement(By.id("HeatingSourceTypeId")),
								By.xpath("//mat-option[@ref-value='" + HeatingSourceTypeId + "']"));
						waitForAngularPageToLoad();

						driver.findElement(By.xpath("//div[contains(text(),'Heat Pump Details')]")).click();

						String heatPumpTypeId = JsonUtils
								.getNestedJsonStringValueByKey(
										new JSONObject(libraryItemHeatPumpObject.toString()), "HeatPumpTypeId")
								.toString();

						System.out.println("heatPumpTypeId : " + heatPumpTypeId);

						waitForAngularPageToLoad();
						selectByTextFromDropdown(driver.findElement(By.id("HeatPumpTypeId")),
								By.xpath("//mat-option[@ref-value='" + heatPumpTypeId + "']"));

					}

					else if (HeatingSourceTypeId.equalsIgnoreCase("3")) {

						sleep(2000);
						driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]")).click();
						waitForAngularPageToLoad();

						driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]"))
								.click();
						waitForAngularPageToLoad();

						selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
								By.xpath("//mat-option[@ref-value='" + libraryItemTypeIDValue + "']"));

						if (!marketingName.trim().toLowerCase().equals("null")) {

							driver.findElement(By.id("MarketingName")).click();
							driver.findElement(By.id("MarketingName")).sendKeys(marketingName);
							waitForAngularPageToLoad();

						}

						String manufacturer = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(libItem.toString()), "Manufacturer").toString();

						driver.findElement(By.id("Manufacturer")).clear();

						driver.findElement(By.id("Manufacturer")).sendKeys(manufacturer);
						waitForAngularPageToLoad();

						String model = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
								.toString();

						driver.findElement(By.id("Model")).clear();

						driver.findElement(By.id("Model")).sendKeys(model);
						waitForAngularPageToLoad();

						selectByTextFromDropdown(driver.findElement(By.id("HeatingSourceTypeId")),
								By.xpath("//mat-option[@ref-value='" + HeatingSourceTypeId + "']"));
						waitForAngularPageToLoad();

						String dEAPSeasonalEfficiency = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(libraryItemHeatSourceObject.toString()),
								"DEAPSeasonalEfficiency").toString();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).clear();

						driver.findElement(By.id("DEAPSeasonalEfficiency")).sendKeys(dEAPSeasonalEfficiency);

						waitForAngularPageToLoad();
						driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
						waitForAngularPageToLoad();

						driver.findElement(By.xpath("//span[text()='" + marketingName + "']")).click();

						waitForAngularPageToLoad();
						driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
						waitForAngularPageToLoad();
						sleep(2000);

						String fuelTypeID = surveyWHHeatSourcePropertiesObjectList.get(i)
								.get(data.get(0).get("FuelTypeID")).toString();
						selectByTextFromDropdown(
								driver.findElement(By.xpath("//*[@id='FuelTypeID' and @aria-required='true']")),
								By.xpath("//mat-option[@ref-value='" + fuelTypeID + "']"));

						waitForAngularPageToLoad();

						String adjustmentFactorBasis = surveyWHHeatSourcePropertiesObjectList.get(i)
								.get(data.get(0).get("AdjustmentFactorBasis")).toString();

						driver.findElement(By.name("AdjustmentFactorBasis")).clear();
						driver.findElement(By.name("AdjustmentFactorBasis")).sendKeys(adjustmentFactorBasis);

					}

					else {

						String waterHeatingTestDataObject = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(libraryItemHeatPumpObject.toString()), "WaterHeatingTestData")
								.toString();

						System.out.println("waterHeatingTestDataObject : " + waterHeatingTestDataObject);

						sleep(2000);
						driver.findElement(By.xpath("//span[contains(text(),'Add Heat Source')]")).click();
						waitForAngularPageToLoad();

						driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]"))
								.click();
						waitForAngularPageToLoad();

						selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
								By.xpath("//mat-option[@ref-value='" + libraryItemTypeIDValue + "']"));

						if (!marketingName.trim().toLowerCase().equals("null")) {

							driver.findElement(By.id("MarketingName")).click();
							driver.findElement(By.id("MarketingName")).sendKeys(marketingName);
							waitForAngularPageToLoad();

						}

						String manufacturer = JsonUtils.getNestedJsonStringValueByKey(
								new JSONObject(libItem.toString()), "Manufacturer").toString();

						driver.findElement(By.id("Manufacturer")).clear();

						driver.findElement(By.id("Manufacturer")).sendKeys(manufacturer);
						waitForAngularPageToLoad();

						String model = JsonUtils
								.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
								.toString();

						driver.findElement(By.id("Model")).clear();

						driver.findElement(By.id("Model")).sendKeys(model);
						waitForAngularPageToLoad();

						selectByTextFromDropdown(driver.findElement(By.id("HeatingSourceTypeId")),
								By.xpath("//mat-option[@ref-value='" + HeatingSourceTypeId + "']"));
						waitForAngularPageToLoad();

						if (HeatingSourceTypeId.equalsIgnoreCase("5")) {
							driver.findElement(By.xpath("//div[contains(text(),'Heat Pump Details')]")).click();

							String heatPumpTypeId = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(libraryItemHeatPumpObject.toString()), "HeatPumpTypeId")
									.toString();

							System.out.println("heatPumpTypeId : " + heatPumpTypeId);

							waitForAngularPageToLoad();
							selectByTextFromDropdown(driver.findElement(By.id("HeatPumpTypeId")),
									By.xpath("//mat-option[@ref-value='" + heatPumpTypeId + "']"));

							String spaceHeatingStandardId = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(libraryItemHeatPumpObject.toString()),
									"SpaceHeatingStandardId").toString();

							selectByTextFromDropdown(driver.findElement(By.id("SpaceHeatingStandardId")),
									By.xpath("//mat-option[@ref-value='" + spaceHeatingStandardId + "']"));

							String waterHeatingStandardId = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(libraryItemHeatPumpObject.toString()),
									"WaterHeatingStandardId").toString();
							waitForAngularPageToLoad();
							selectByTextFromDropdown(driver.findElement(By.id("WaterHeatingStandardId")),
									By.xpath("//mat-option[@ref-value='" + waterHeatingStandardId + "']"));
							waitForAngularPageToLoad();
							String dEAPSeasonalEfficiency = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(libraryItemHeatSourceObject.toString()),
									"DEAPSeasonalEfficiency").toString();

							driver.findElement(By.id("DEAPSeasonalEfficiency")).clear();

							driver.findElement(By.id("DEAPSeasonalEfficiency"))
									.sendKeys(dEAPSeasonalEfficiency);

							String dEAPWHSeasonalEfficiency = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(libraryItemHeatSourceObject.toString()),
									"DEAPWHSeasonalEfficiency").toString();

							driver.findElement(By.id("DEAPWHSeasonalEfficiency")).clear();

							driver.findElement(By.id("DEAPWHSeasonalEfficiency"))
									.sendKeys(dEAPWHSeasonalEfficiency);

							String temperatureControlId = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(libraryItemHeatPumpObject.toString()),
									"TemperatureControlId").toString();

							selectByTextFromDropdown(driver.findElement(By.id("TemperatureControlId")),
									By.xpath("//mat-option[@ref-value='" + temperatureControlId + "']"));

							// value is -10.00 how to validate

							String TOL = JsonUtils
									.getNestedJsonStringValueByKey(
											new JSONObject(libraryItemHeatPumpObject.toString()), "TOL")
									.toString();

							driver.findElement(By.id("TOL")).clear();

							driver.findElement(By.id("TOL")).sendKeys(TOL);

							String WTOL = JsonUtils
									.getNestedJsonStringValueByKey(
											new JSONObject(libraryItemHeatPumpObject.toString().trim()), "WTOL")
									.toString();
							driver.findElement(By.id("WTOL")).clear();

							driver.findElement(By.id("WTOL")).sendKeys(WTOL);

							driver.findElement(By.xpath("//div[contains(text(),'Heat Pump Test Data')]"))
									.click();

							waitForAngularPageToLoad();

							Object spaceHeatingTestDataObject = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(libraryItemHeatPumpObject.toString()),
									data.get(0).get("SpaceHeatingTestData"));

							Object spaceHeatingTestDataObject1 = JsonUtils.getNestedJsonStringValueByKey(json,
									data.get(0).get("SpaceHeatingTestData"));
							System.out
									.println("SpaceHeatingTestDataObject Object:" + spaceHeatingTestDataObject);

							List<HashMap<String, Object>> spaceHeatingTestDataObjectList = JsonUtils
									.getJsonArrayValueAsListOfMap(spaceHeatingTestDataObject);
							System.out.println(
									"spaceHeatingTestDataObjectList List:" + spaceHeatingTestDataObjectList);

							for (int k = 0; k < spaceHeatingTestDataObjectList.size(); k++) {

								waitForAngularPageToLoad();
								String temperatureCategoryIdValue = String
										.valueOf(spaceHeatingTestDataObjectList.get(k)
												.get(data.get(0).get("TemperatureCategoryId")))
										.trim();
								System.out.println("temperatureCategoryIdValue :" + temperatureCategoryIdValue);

								if (temperatureCategoryIdValue.equalsIgnoreCase("1")) {

									driver.findElement(
											By.xpath("//span[contains(text(),'Test Condition - Low (35°C)')]"))
											.click();

									waitForAngularLoad();

									String applicationHeatingCapacityA = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityA")))
											.trim();

									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityA'])[1]")),
											applicationHeatingCapacityA);

									String applicationHeatingCapacityB = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityB")))
											.trim();

									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityB'])[1]")),
											applicationHeatingCapacityB);

									String applicationHeatingCapacityC = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityC")))
											.trim();

									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityC'])[1]")),
											applicationHeatingCapacityC);

									String applicationHeatingCapacityD = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityD")))
											.trim();

									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityD'])[1]")),
											applicationHeatingCapacityD);

									String applicationHeatingCapacityE = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityE")))
											.trim();
									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityE'])[1]")),
											applicationHeatingCapacityE);

									String applicationHeatingCoefficientOfPerformanceA = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceA")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceA'])[1]")),
											applicationHeatingCoefficientOfPerformanceA);

									String applicationHeatingCoefficientOfPerformanceB = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceB")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceB'])[1]")),
											applicationHeatingCoefficientOfPerformanceB);

									String applicationHeatingCoefficientOfPerformanceC = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceC")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceC'])[1]")),
											applicationHeatingCoefficientOfPerformanceC);

									String applicationHeatingCoefficientOfPerformanceD = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceD")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceD'])[1]")),
											applicationHeatingCoefficientOfPerformanceD);

									String applicationHeatingCoefficientOfPerformanceE = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceE")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceE'])[1]")),
											applicationHeatingCoefficientOfPerformanceE);

								}
								if (temperatureCategoryIdValue.equalsIgnoreCase("3")) {

									driver.findElement(By
											.xpath("//span[contains(text(),'Test Condition - Medium (55°C)')]"))
											.click();

									waitForAngularLoad();

									String applicationHeatingCapacityA = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityA")))
											.trim();

									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityA'])[3]")),
											applicationHeatingCapacityA);

									String applicationHeatingCapacityB = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityB")))
											.trim();

									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityB'])[3]")),
											applicationHeatingCapacityB);

									String applicationHeatingCapacityC = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityC")))
											.trim();

									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityC'])[3]")),
											applicationHeatingCapacityC);

									String applicationHeatingCapacityD = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityD")))
											.trim();

									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityD'])[3]")),
											applicationHeatingCapacityD);

									String applicationHeatingCapacityE = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get("ApplicationHeatingCapacityE")))
											.trim();
									clickClearSendKeys(
											driver.findElement(
													By.xpath("(//*[@id='ApplicationHeatingCapacityE'])[3]")),
											applicationHeatingCapacityE);

									String applicationHeatingCoefficientOfPerformanceA = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceA")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceA'])[3]")),
											applicationHeatingCoefficientOfPerformanceA);

									String applicationHeatingCoefficientOfPerformanceB = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceB")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceB'])[3]")),
											applicationHeatingCoefficientOfPerformanceB);

									String applicationHeatingCoefficientOfPerformanceC = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceC")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceC'])[3]")),
											applicationHeatingCoefficientOfPerformanceC);

									String applicationHeatingCoefficientOfPerformanceD = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceD")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceD'])[3]")),
											applicationHeatingCoefficientOfPerformanceD);

									String applicationHeatingCoefficientOfPerformanceE = String
											.valueOf(spaceHeatingTestDataObjectList.get(k)
													.get(data.get(0).get(
															"ApplicationHeatingCoefficientOfPerformanceE")))
											.trim();

									clickClearSendKeys(driver.findElement(By.xpath(
											"(//*[@id='ApplicationHeatingCoefficientOfPerformanceE'])[3]")),
											applicationHeatingCoefficientOfPerformanceE);

								}

							}

							/*
							 * String designFlowTemperature = String.valueOf(
							 * surveySHHeatSourcePropertiesObjectList.get(i).get(data.get(0).get(
							 * "DesignFlowTemperature"))) .trim();
							 * 
							 * 
							 * WaterHeatingSourceOfDataId
							 */
							/*
							 * Object waterHeatingTestDataObject = JsonUtils.getNestedJsonStringValueByKey(
							 * new JSONObject(libraryItemHeatPumpObject.toString()),
							 * data.get(0).get("WaterHeatingTestData"));
							 * 
							 * 
							 * String waterHeatingSourceOfDataId = JsonUtils
							 * .getNestedJsonStringValueByKey(new
							 * JSONObject(waterHeatingTestDataObject.toString()),
							 * "WaterHeatingSourceOfDataId") .toString();
							 */

							String waterHeatingSourceOfDataId = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(waterHeatingTestDataObject.toString()),
									"WaterHeatingSourceOfDataId").toString();

							System.out.println("waterHeatingSourceOfDataId : " + waterHeatingSourceOfDataId);

							selectByTextFromDropdown(driver.findElement(By.id("WaterHeatingSourceOfDataId")),
									By.xpath("//mat-option[@ref-value='" + waterHeatingSourceOfDataId + "']"));
							waitForAngularPageToLoad();

							String waterHeatingEfficiency = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(waterHeatingTestDataObject.toString()),
									"WaterHeatingEfficiency").toString();

							System.out.println("waterHeatingEfficiency : " + waterHeatingEfficiency);

							driver.findElement(By.name("WaterHeatingEfficiency")).click();
							driver.findElement(By.name("WaterHeatingEfficiency")).clear();
							driver.findElement(By.name("WaterHeatingEfficiency"))
									.sendKeys(waterHeatingEfficiency);

							/*
							 * clickClearSendKeys( driver.findElement( By.name("(WaterHeatingEfficiency")),
							 * waterHeatingEfficiency);
							 */

							String referenceHotWaterTemperature = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(waterHeatingTestDataObject.toString().trim()),
									"ReferenceHotWaterTemperature").toString();

							driver.findElement(By.name("ReferenceHotWaterTemperature")).click();
							driver.findElement(By.name("ReferenceHotWaterTemperature")).clear();
							driver.findElement(By.name("ReferenceHotWaterTemperature"))
									.sendKeys(referenceHotWaterTemperature);

							// clickClearSendKeys(driver.findElement(By.id("(ReferenceHotWaterTemperature")),+referenceHotWaterTemperature);

							String capacityOfHeatPump = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(waterHeatingTestDataObject.toString().trim()),
									"CapacityOfHeatPump").toString();

							driver.findElement(By.name("CapacityOfHeatPump")).click();
							driver.findElement(By.name("CapacityOfHeatPump")).clear();
							driver.findElement(By.name("CapacityOfHeatPump")).sendKeys(capacityOfHeatPump);

							// clickClearSendKeys(driver.findElement(By.id("(CapacityOfHeatPump")),capacityOfHeatPump);

							waitForAngularPageToLoad();

							String declaredLoadProfileId = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(waterHeatingTestDataObject.toString()),
									"DeclaredLoadProfileId").toString();

							selectByTextFromDropdown(driver.findElement(By.id("DeclaredLoadProfileId")),
									By.xpath("//mat-option[@ref-value='" + declaredLoadProfileId + "']"));
							waitForAngularPageToLoad();

							String standByHeatLoss = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(waterHeatingTestDataObject.toString().trim()),
									"StandByHeatLoss").toString();

							driver.findElement(By.name("StandByHeatLoss")).click();
							driver.findElement(By.name("StandByHeatLoss")).clear();
							driver.findElement(By.name("StandByHeatLoss")).sendKeys(standByHeatLoss);

							// clickClearSendKeys(driver.findElement(By.id("(StandByHeatLoss")),standByHeatLoss);

							String volumeOfDHW = JsonUtils.getNestedJsonStringValueByKey(
									new JSONObject(waterHeatingTestDataObject.toString().trim()), "VolumeOfDHW")
									.toString();

							driver.findElement(By.name("VolumeOfDHW")).click();
							driver.findElement(By.name("VolumeOfDHW")).clear();
							driver.findElement(By.name("VolumeOfDHW")).sendKeys(volumeOfDHW);

							// clickClearSendKeys(driver.findElement(By.id("(VolumeOfDHW")),volumeOfDHW);

							driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
							waitForAngularPageToLoad();

							driver.findElement(By.xpath("//span[text()='" + marketingName + "']")).click();

							waitForAngularPageToLoad();
							driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
							waitForAngularPageToLoad();
							sleep(2000);

							driver.findElement(By.name("AdjustmentFactorBasis")).clear();
							driver.findElement(By.name("AdjustmentFactorBasis")).sendKeys("1");

							String dailyOperationHours = String.valueOf(surveyWHHeatSourcePropertiesObjectList
									.get(i).get(data.get(0).get("DailyOperationHours"))).trim();

							System.out.println("libItem designFlowTemperature:" + dailyOperationHours);

							String dailyOperationHoursValue = String.valueOf(dailyOperationHours.toString())
									.trim();

							selectByTextFromDropdown(driver.findElement(By.id("DailyOperationHours")),
									By.xpath("//mat-option[@ref-value='" + dailyOperationHoursValue + "']"));
							waitForAngularPageToLoad();

							selectByTextFromDropdown(driver.findElement(By.id("DomesticHotWaterStorageId")),
									By.xpath("//mat-option[@ref-value='" + designFlowTemperatureValue + "']"));
							waitForAngularPageToLoad();

							driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
							waitForAngularPageToLoad();

						}
					}

				}
			}
		}

	}

	@Then("Options and Storage in Water Heating Page")
	public void options_and_storage_in_water_heating_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		driver.findElement(By.id("options-tab")).click();

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyWHLossesObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("SurveyWHLosses"));

		List<HashMap<String, Object>> surveyWHLossesList = JsonUtils.getJsonArrayValueAsListOfMap(surveyWHLossesObject);

		waitForAngularPageToLoad();

		for (int i = 0; i < surveyWHLossesList.size(); i++) {

			WebElement storageCheckbox = driver.findElement(By.name("Storage"));

			checkOrUncheck(storageCheckbox, surveyWHLossesList.get(i).get("Storage").toString().trim());

			waitForAngularPageToLoad();

			WebElement storageIndoorGroupScheme = driver.findElement(By.name("StorageIndoorGroupScheme"));

			checkOrUncheck(storageIndoorGroupScheme,
					surveyWHLossesList.get(i).get("StorageIndoorGroupScheme").toString().trim());

			waitForAngularPageToLoad();

			WebElement distributionScheme = driver.findElement(By.name("Distribution"));

			checkOrUncheck(distributionScheme, surveyWHLossesList.get(i).get("Distribution").toString().trim());

			waitForAngularPageToLoad();

			String storageVolumevale = String.valueOf(surveyWHLossesList
					.get(i).get(data.get(0).get("StorageVolume"))).trim();

			if (!storageVolumevale.trim().toLowerCase().equals("null")) {

				driver.findElement(By.name("StorageVolume")).clear();
				driver.findElement(By.name("StorageVolume"))
						.sendKeys(storageVolumevale);
			}
		}
		waitForAngularPageToLoad();

	}

	@Then("Options and Storage Losses in Water Heating Page")
	public void options_and_storage_losses_in_water_heating_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyWHStorageTypesObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveyWHStorageTypes"));

		List<HashMap<String, Object>> surveyWHStorageTypesObjectList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveyWHStorageTypesObject);

		for (int i = 0; i < surveyWHStorageTypesObjectList.size(); i++) {

			waitForAngularPageToLoad();
			String waterStorageIDValue = String
					.valueOf(surveyWHStorageTypesObjectList.get(i).get(data.get(0).get("WaterStorageID"))).trim();
			System.out.println("waterStorageID Value" + waterStorageIDValue);

			selectByTextFromDropdown(driver.findElement(By.name("WaterStorageID")),
					By.xpath("//mat-option[@ref-value='" + waterStorageIDValue + "']"));

			String cylinderThermostatContainer = String
					.valueOf(surveyWHStorageTypesObjectList.get(i).get(data.get(0).get("CylinderThermostatContainer")))
					.trim();

			String insulationTypeIDValue = String
					.valueOf(surveyWHStorageTypesObjectList.get(i).get(data.get(0).get("InsulationTypeID"))).trim();
			System.out.println("insulationTypeIDValue Value" + insulationTypeIDValue);

			if (!(insulationTypeIDValue.equalsIgnoreCase("null"))) {
				selectByTextFromDropdown(driver.findElement(By.name("InsulationTypeID")),
						By.xpath("//mat-option[@ref-value='" + insulationTypeIDValue + "']"));

				String cylinderThicknessValue = String
						.valueOf(surveyWHStorageTypesObjectList.get(i).get(data.get(0).get("CylinderThickness")))
						.trim();
				System.out.println("cylinderThicknessValue Value" + cylinderThicknessValue);

				driver.findElement(By.name("CylinderThickness")).clear();
				driver.findElement(By.name("CylinderThickness")).sendKeys(surveyWHStorageTypesObjectList.get(i)
						.get(data.get(0).get("CylinderThickness").trim()).toString());

			}

			if (cylinderThermostatContainer.equalsIgnoreCase("true")) {

				driver.findElement(By.id("CylinderThermostatContainer")).click();
				waitForAngularPageToLoad();

			}

			String cylinderHeatedByBoiler = String
					.valueOf(surveyWHStorageTypesObjectList.get(i).get(data.get(0).get("CylinderHeatedByBoiler")))
					.trim();

			if (cylinderHeatedByBoiler.equalsIgnoreCase("true")) {

				driver.findElement(By.id("CylinderHeatedByBoiler")).click();
				waitForAngularPageToLoad();
			}

			WebElement complianceCheckbox = driver.findElement(By.name("CylinderThermostat"));

			checkOrUncheck(complianceCheckbox,
					surveyWHStorageTypesObjectList.get(i).get("CylinderThermostat").toString().trim());

		}
		Object surveyWHLossesObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveyWHLosses"));

		List<HashMap<String, Object>> surveyWHLossesObjecttList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveyWHLossesObject);

		for (int j = 0; j < surveyWHLossesObjecttList.size(); j++) {

			String makeModel = String.valueOf(surveyWHLossesObjecttList.get(j).get(data.get(0).get("MakeModel")))
					.trim();

			if (!(makeModel.equals("null"))) {
				waitForAngularPageToLoad();

				driver.findElement(By.id("IsManuLossAvailable")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.name("MakeModel")).clear();
				driver.findElement(By.name("MakeModel")).sendKeys(
						surveyWHLossesObjecttList.get(j).get(data.get(0).get("MakeModel").trim()).toString());

				waitForAngularPageToLoad();

				driver.findElement(By.name("DeclaredLoss")).clear();
				driver.findElement(By.name("DeclaredLoss")).sendKeys(
						surveyWHLossesObjecttList.get(j).get(data.get(0).get("DeclaredLoss").trim()).toString());

			}

			String systemTypeIDValue = String
					.valueOf(surveyWHLossesObjecttList.get(j).get(data.get(0).get("SystemTypeID"))).trim();
			System.out.println("systemTypeID Value" + systemTypeIDValue);

			selectByTextFromDropdown(driver.findElement(By.name("SystemTypeID")),
					By.xpath("//mat-option[@ref-value='" + systemTypeIDValue + "']"));

		}

		// removed to check the flow

	}

	@Then("Combi Boiler in Water Heating Page")
	public void combi_boiler_in_water_heating_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		driver.findElement(By.id("combi-boiler-tab")).click();

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyWHLossesObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("SurveyWHLosses"));

		List<HashMap<String, Object>> surveyWHLossesList = JsonUtils.getJsonArrayValueAsListOfMap(surveyWHLossesObject);

		waitForAngularPageToLoad();

		for (int i = 0; i < surveyWHLossesList.size(); i++) {

			String combiIDValue = String.valueOf(surveyWHLossesList
					.get(i).get(data.get(0).get("CombiID"))).trim();

			if (!combiIDValue.trim().toLowerCase().equals("null")) {

				String distributionValue = String.valueOf(surveyWHLossesList
						.get(i).get(data.get(0).get("Distribution"))).trim();
				WebElement storageCheckbox = driver.findElement(By.name("IsCombiBoiler"));

				checkOrUncheck(storageCheckbox, distributionValue);

				waitForAngularPageToLoad();
				selectByTextFromDropdown(driver.findElement(By.id("CombiID")),
						By.xpath("//mat-option[@ref-value='" + combiIDValue + "']"));

				waitForAngularPageToLoad();

				String keepHotIDValue = String.valueOf(surveyWHLossesList
						.get(i).get(data.get(0).get("KeepHotID"))).trim();

				selectByTextFromDropdown(driver.findElement(By.id("KeepHotID")),
						By.xpath("//mat-option[@ref-value='" + keepHotIDValue + "']"));

				String additionalLossvale = String.valueOf(surveyWHLossesList
						.get(i).get(data.get(0).get("AdditionalLoss"))).trim();

				if (!additionalLossvale.trim().toLowerCase().equals("null")) {

					driver.findElement(By.name("AdditionalLoss")).clear();
					driver.findElement(By.name("AdditionalLoss"))
							.sendKeys(additionalLossvale);
				}

				String keepHotConsumptionvale = String.valueOf(surveyWHLossesList
						.get(i).get(data.get(0).get("KeepHotConsumption"))).trim();

				if (!keepHotConsumptionvale.trim().toLowerCase().equals("null")) {

					driver.findElement(By.name("KeepHotConsumption")).clear();
					driver.findElement(By.name("KeepHotConsumption"))
							.sendKeys(keepHotConsumptionvale);
				}

			}
		}

	}

	@And("Showers and Baths in Water Heating Page")

	public void showers_and_baths_in_water_heating_page(io.cucumber.datatable.DataTable dataTable) {

		sleep(2000);

		driver.findElement(By.id("showers-bath-tab")).click();

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyItemsObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("SurveyItems"));
		System.out.println("surveyItems Object:" + surveyItemsObject);
		List<HashMap<String, Object>> surveyItemsList = JsonUtils.getJsonArrayValueAsListOfMap(surveyItemsObject);
		System.out.println("surveyItems List:" + surveyItemsList);
		// for (int i = 0; i < doorlist.size(); i++) {

		for (int i = 0; i < surveyItemsList.size(); i++) {

			JSONObject libItem = new JSONObject(surveyItemsList.get(i).get(data.get(0).get("LibraryItem")).toString());
			Object libObject = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("LibraryItemTypeID"));

			String libraryItemTypeIDValue = String.valueOf(libObject.toString()).trim();
			Object marketingNameObject = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("MarketingName"));

			String marketingNameValue = String.valueOf(marketingNameObject.toString()).trim();

			if (libraryItemTypeIDValue.equalsIgnoreCase("11")) {
				// bath

				driver.findElement(By.xpath("//span[contains(text(),'Add Showers & Baths')]")).click();

				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[text()='" + marketingNameValue + "']")).click();
				addedVentilationList.put(marketingNameValue, surveyItemsList.get(i));
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[text()='" + marketingNameValue + "']")).click();

				waitForAngularPageToLoad();

				driver.findElement(By.name("Number")).clear();
				driver.findElement(By.name("Number"))
						.sendKeys(surveyItemsList.get(i).get(data.get(0).get("Number").trim()).toString());
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
				waitForAngularPageToLoad();

			} else if (libraryItemTypeIDValue.equalsIgnoreCase("10")) {
				// shower

				driver.findElement(By.xpath("//span[contains(text(),'Add Showers & Baths')]")).click();

				waitForAngularPageToLoad();

				List<WebElement> mNameList = driver
						.findElements(By.xpath("//span[text()='" + marketingNameValue + "']"));

				System.out.println("marketingName:" + mNameList);
				mNameList.get(mNameList.size() - 1).click();

				// driver.findElement(By.xpath("//span[text()='" + marketingNameValue +
				// "']")).click();
				addedVentilationList.put(marketingNameValue, surveyItemsList.get(i));
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[text()='" + marketingNameValue + "']")).click();

				waitForAngularPageToLoad();
				driver.findElement(By.name("Number")).clear();
				driver.findElement(By.name("Number"))
						.sendKeys(surveyItemsList.get(i).get(data.get(0).get("Number").trim()).toString());

				/*
				 * driver.findElement(By.name("Number")).clear();
				 * driver.findElement(By.name("Number"))
				 * .sendKeys(surveyItemsList.get(i).get(data.get(0).get("Number").trim()).
				 * toString()); waitForAngularPageToLoad();
				 */

				driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
				waitForAngularPageToLoad();

			}

		}

	}

	@Then("details Showers and Baths in Water Heating Page")
	public void details_showers_and_baths_in_water_heating_page() {

	}

	@Then("Lighting details Page")
	public void lighting_details_page(io.cucumber.datatable.DataTable dataTable) {

		sleep(2000);
		waitForAngularPageToLoad();
		Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(By.xpath("//a[contains(@href,'/lighting')]"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyItemsObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("SurveyItems"));
		System.out.println("surveyItems Object:" + surveyItemsObject);
		List<HashMap<String, Object>> surveyItemsList = JsonUtils.getJsonArrayValueAsListOfMap(surveyItemsObject);
		System.out.println("surveyItems List:" + surveyItemsList);
		// for (int i = 0; i < doorlist.size(); i++) {

		for (int i = 0; i < surveyItemsList.size(); i++) {

			JSONObject libItem = new JSONObject(surveyItemsList.get(i).get(data.get(0).get("LibraryItem")).toString());
			Object libObject = JsonUtils.getNestedJsonStringValueByKey(libItem, data.get(0).get("LibraryItemTypeID"));
			Object libraryItemSourceIDObj = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("LibraryItemSourceID"));
			String libraryItemTypeIDValue = String.valueOf(libObject.toString()).trim();
			String libraryItemSourceIDValue = String.valueOf(libraryItemSourceIDObj.toString()).trim();

			Object marketingNameObject = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("MarketingName"));

			String marketingNameValue = String.valueOf(marketingNameObject.toString()).trim();

			if (libraryItemTypeIDValue.equalsIgnoreCase("3") && (libraryItemSourceIDValue.equalsIgnoreCase("2"))) {

				JSONObject json1 = new JSONObject(SuiteConstants.jsonString.toString());
				System.out.println("json value:" + json1);
				Object isLightingDesignKnown = JsonUtils.getNestedJsonStringValueByKey(json1,
						data.get(0).get("IsLightingDesignKnown"));
				String isLightingDesignKnownValue = isLightingDesignKnown.toString().trim();
				if (!isLightingDesignKnownValue.trim().toLowerCase().equals("null")) {
					if (isLightingDesignKnownValue.trim().toLowerCase().equals("true")) {

						WebElement isLightingDesignKnownCheckbox = driver.findElement(By.name("IsLightingDesignKnown"));

						// isLightingDesignKnownCheckbox.click();

					}
				}

				driver.findElement(By.xpath("//span[contains(text(),' Add Bulb ')]")).click();
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[contains(text(),'Add New Item to Library')]")).click();
				waitForAngularPageToLoad();

				selectByTextFromDropdown(driver.findElement(By.id("LibraryItemTypeID")),
						By.xpath("//mat-option[@ref-value='" + libraryItemTypeIDValue + "']"));

				Object manufacturerObject = JsonUtils.getNestedJsonStringValueByKey(libItem,
						data.get(0).get("Manufacturer"));

				String manufacturerObjectValue = String.valueOf(manufacturerObject.toString()).trim();

				if (!marketingNameValue.trim().toLowerCase().equals("null")) {

					driver.findElement(By.id("MarketingName")).click();
					driver.findElement(By.id("MarketingName")).sendKeys(marketingNameValue);
					waitForAngularPageToLoad();

				}
				driver.findElement(By.id("Manufacturer")).clear();

				driver.findElement(By.id("Manufacturer")).sendKeys(manufacturerObjectValue);
				waitForAngularPageToLoad();

				String model = JsonUtils.getNestedJsonStringValueByKey(new JSONObject(libItem.toString()), "Model")
						.toString();

				driver.findElement(By.id("Model")).clear();

				driver.findElement(By.id("Model")).sendKeys(model);
				waitForAngularPageToLoad();

				Object libraryItemBulbObject = JsonUtils.getNestedJsonStringValueByKey(libItem,
						data.get(0).get("LibraryItemBulb"));

				String bulbTypeIDId = JsonUtils.getNestedJsonStringValueByKey(
						new JSONObject(libraryItemBulbObject.toString()), "BulbTypeID").toString();

				selectByTextFromDropdown(driver.findElement(By.id("BulbTypeID")),
						By.xpath("//mat-option[@ref-value='" + bulbTypeIDId + "']"));
				waitForAngularPageToLoad();

				String efficiencyValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libraryItemBulbObject.toString()),
								"Efficiency")
						.toString();

				driver.findElement(By.id("Efficiency")).clear();

				driver.findElement(By.id("Efficiency")).sendKeys(efficiencyValue);

				String powerValue = JsonUtils
						.getNestedJsonStringValueByKey(new JSONObject(libraryItemBulbObject.toString()),
								"Power")
						.toString();

				driver.findElement(By.id("Power")).clear();

				driver.findElement(By.id("Power")).sendKeys(powerValue);

				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'" + marketingNameValue + "')]")).click();
				waitForAngularPageToLoad();
				sleep(2000);
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'" + marketingNameValue + "')]")).click();
				waitForAngularPageToLoad();
				sleep(5000);
				waitForAngularPageToLoad();

				driver.findElement(By.name("Number")).clear();
				driver.findElement(By.name("Number"))
						.sendKeys(surveyItemsList.get(i).get(data.get(0).get("Number").trim()).toString());
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[text()='Save']")).click();

			}

			else if (libraryItemTypeIDValue.equalsIgnoreCase("3")) {

				driver.findElement(By.xpath("//span[contains(text(),' Add Bulb ')]")).click();
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[text()='" + marketingNameValue + "']")).click();
				addedVentilationList.put(marketingNameValue, surveyItemsList.get(i));
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[text()='" + marketingNameValue + "']")).click();

				waitForAngularPageToLoad();

				driver.findElement(By.name("Number")).clear();
				driver.findElement(By.name("Number"))
						.sendKeys(surveyItemsList.get(i).get(data.get(0).get("Number").trim()).toString());
				waitForAngularPageToLoad();
				driver.findElement(By.xpath("//span[text()='Save']")).click();

			}

		}

	}

	@When("Solar details in Water Heating Page")
	public void solar_details_in_water_heating_page(io.cucumber.datatable.DataTable dataTable) {

		sleep(2000);
		waitForAngularPageToLoad();
		Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(By.id("solar-tab"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();

		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyWHSolarsObject = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("SurveyWHSolars"));
		System.out.println("surveyWHSolars Object:" + surveyWHSolarsObject);
		List<HashMap<String, Object>> surveyWHSolarsList = JsonUtils.getJsonArrayValueAsListOfMap(surveyWHSolarsObject);
		System.out.println("surveyWHSolarsList:" + surveyWHSolarsList);
		// for (int i = 0; i < doorlist.size(); i++) {

		for (int i = 0; i < surveyWHSolarsList.size(); i++) {

			waitForAngularPageToLoad();

			JSONObject libItem = new JSONObject(
					surveyWHSolarsList.get(i).get(data.get(0).get("LibraryItem")).toString());
			Object marketingNamebject = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("MarketingName"));
			Object libraryItemTypeIDObj = JsonUtils.getNestedJsonStringValueByKey(libItem,
					data.get(0).get("LibraryItemTypeID"));

			driver.findElement(By.xpath("//span[contains(text(),'Add Solar Collector')]")).click();

			String libraryItemTypeIDObjValue = String.valueOf(libraryItemTypeIDObj.toString()).trim();

			String marketingNameValue = String.valueOf(marketingNamebject.toString()).trim();
			if (libraryItemTypeIDObjValue.equalsIgnoreCase("9")) {

				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'" + marketingNameValue + "')]")).click();
				addedVentilationList.put(marketingNameValue, surveyWHSolarsList.get(i));
				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Selected Item')]")).click();
				waitForAngularPageToLoad();

				// driver.findElement(By.xpath("//span[contains(text(),'" + marketingNameValue +
				// "')]")).click();

				waitForAngularPageToLoad();

				String apetureAreaOfCollectorValue = String
						.valueOf(surveyWHSolarsList.get(i).get(data.get(0).get("ApetureAreaOfCollector"))).trim();
				System.out.println("apetureAreaOfCollectorValue:" + apetureAreaOfCollectorValue);

				driver.findElement(By.name("ApetureAreaOfCollector")).clear();
				driver.findElement(By.name("ApetureAreaOfCollector")).sendKeys(apetureAreaOfCollectorValue);

				waitForAngularPageToLoad();
				String dedicatedStorageVolumeValue = String
						.valueOf(surveyWHSolarsList.get(i).get(data.get(0).get("DedicatedStorageVolume"))).trim();
				System.out.println("dedicatedStorageVolumeValue:" + dedicatedStorageVolumeValue);

				driver.findElement(By.name("DedicatedStorageVolume")).clear();
				driver.findElement(By.name("DedicatedStorageVolume")).sendKeys(dedicatedStorageVolumeValue);

				waitForAngularPageToLoad();
				String annualSolarRadiationValue = String
						.valueOf(surveyWHSolarsList.get(i).get(data.get(0).get("AnnualSolarRadiation"))).trim();
				System.out.println("annualSolarRadiation Value:" + annualSolarRadiationValue);

				driver.findElement(By.name("AnnualSolarRadiation")).clear();
				driver.findElement(By.name("AnnualSolarRadiation")).sendKeys(annualSolarRadiationValue);

				waitForAngularPageToLoad();
				String overshadingFactorValue = String
						.valueOf(surveyWHSolarsList.get(i).get(data.get(0).get("OvershadingFactor"))).trim();
				System.out.println("annualSolarRadiation Value:" + overshadingFactorValue);

				driver.findElement(By.name("OvershadingFactor")).clear();
				driver.findElement(By.name("OvershadingFactor")).sendKeys(overshadingFactorValue);

				waitForAngularPageToLoad();

				String cylinderStatCheckboxValue = String
						.valueOf(surveyWHSolarsList.get(i).get(data.get(0).get("CylinderStat"))).trim();

				if (!(cylinderStatCheckboxValue.trim().equalsIgnoreCase("null"))) {
					WebElement cylinderStatCheckbox = driver.findElement(By.name("CylinderStat"));
					checkOrUncheck(cylinderStatCheckbox, cylinderStatCheckboxValue);
				}
				waitForAngularPageToLoad();

				String pumpSolarPoweredCheckboxValue = String
						.valueOf(surveyWHSolarsList.get(i).get(data.get(0).get("PumpSolarPowered"))).trim();

				if (!(pumpSolarPoweredCheckboxValue.trim().equalsIgnoreCase("null"))) {
					WebElement pumpSolarPoweredCheckbox = driver.findElement(By.name("PumpSolarPowered"));
					checkOrUncheck(pumpSolarPoweredCheckbox, pumpSolarPoweredCheckboxValue);
				}

				waitForAngularPageToLoad();

				String storageWithinCombinedCyclinderCheckboxValue = String
						.valueOf(surveyWHSolarsList.get(i).get(data.get(0).get("StorageWithinCombinedCyclinder")))
						.trim();

				if (!(storageWithinCombinedCyclinderCheckboxValue.trim().equalsIgnoreCase("null"))) {
					WebElement storageWithinCombinedCyclinderCheckbox = driver
							.findElement(By.name("StorageWithinCombinedCyclinder"));
					checkOrUncheck(storageWithinCombinedCyclinderCheckbox, storageWithinCombinedCyclinderCheckboxValue);
				}

				waitForAngularPageToLoad();

				driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
				waitForAngularPageToLoad();

			} else {
				continue;
			}

		}

	}

	@Then("Renewable details")
	public void renewable_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyFuelData_RenewableObject = JsonUtils.getNestedJsonStringValueByKey(json,
				data.get(0).get("SurveyFuelData_Renewable"));
		System.out.println("surveyFuelData_RenewableObject :" + surveyFuelData_RenewableObject);
		List<HashMap<String, Object>> surveyFuelDataList = JsonUtils
				.getJsonArrayValueAsListOfMap(surveyFuelData_RenewableObject);
		System.out.println("surveyItems List:" + surveyFuelDataList);

		for (int i = 0; i < surveyFuelDataList.size(); i++) {
			String renewableTypeID = String.valueOf(surveyFuelDataList.get(i).get(data.get(0).get("RenewableTypeID")))
					.trim();

			System.out.println("renewableTypeID : " + renewableTypeID);

			if (!renewableTypeID.trim().toLowerCase().equals("null")) {

				driver.findElement(By.xpath("//span[contains(text(),'Add Renewable')]")).click();
				waitForAngularPageToLoad();

				selectByTextFromDropdown(driver.findElement(By.id("RenewableTypeID")),
						By.xpath("//mat-option[@ref-value='" + renewableTypeID + "']"));

				/*
				 * selectByTextFromDropdown(driver.findElement(By.id("RenewableTypeID")),
				 * By.xpath("//span[contains(text(),'Electrical (Solar PV/Wind)')]"));
				 */

				waitForAngularPageToLoad();

				String energyProducedOrSaved = String
						.valueOf(surveyFuelDataList.get(i).get(data.get(0).get("EnergyProducedOrSaved"))).trim();

				driver.findElement(By.id("EnergyProducedOrSaved")).clear();
				driver.findElement(By.id("EnergyProducedOrSaved")).sendKeys(energyProducedOrSaved);
				waitForAngularPageToLoad();

				String producedDeliveredEnergy = String
						.valueOf(surveyFuelDataList.get(i).get(data.get(0).get("ProducedDeliveredEnergy"))).trim();
				if (!producedDeliveredEnergy.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("ProducedDeliveredEnergy")).clear();
					driver.findElement(By.id("ProducedDeliveredEnergy")).sendKeys(producedDeliveredEnergy);
					waitForAngularPageToLoad();
				}
				String partLtotalcontribution = String
						.valueOf(surveyFuelDataList.get(i).get(data.get(0).get("PartLtotalcontribution"))).trim();

				if (!partLtotalcontribution.trim().toLowerCase().equals("null")) {
					driver.findElement(By.id("PartLtotalcontribution")).clear();
					driver.findElement(By.id("PartLtotalcontribution")).sendKeys(partLtotalcontribution);
				}
				waitForAngularPageToLoad();

				String enerProdFuel = String
						.valueOf(surveyFuelDataList.get(i).get(data.get(0).get("6CC"))).trim();

				// if (!enerProdFuel.trim().toLowerCase().equals("null")) {
				// selectByTextFromDropdown(driver.findElement(By.id("EnerProdFuel")),
				// By.xpath("//mat-option[@ref-value='" + enerProdFuel + "']"));

				// }

				driver.findElement(By.xpath("//button/span[contains(text(),'Save')]")).click();
				waitForAngularPageToLoad();

			}
		}
	}

	@Given("MPCDER details")
	public void mpcder_details() {
	}

	@Then("MPCDER details Page")
	public void mpcder_details_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		List<List<String>> lists = dataTable.asLists(String.class);
		for (int i = 1; i < lists.size(); i++) {
			driver.findElement(By.xpath("//md-tab-item[contains(text(),'MPCDER')]")).click();
			sleep(4000);
			List<String> vList = lists.get(i);
			selectByTextFromDropdown(driver.findElement(By.id("SpaceHeatingResourceID")),
					By.xpath("//md-option[contains(@ng-repeat,'rc.refData.renewables.RenewableResources')]"),
					vList.get(0));
			sleep(4000);
			selectByTextFromDropdown(driver.findElement(By.id("WaterHeatingResourceID")),
					By.xpath("//md-option[contains(@ng-repeat,'rc.refData.renewables.RenewableResources')]"),
					vList.get(1));

		}

	}

	@Then("Result details Page")
	public void result_details_page(io.cucumber.datatable.DataTable dataTable) {
		sleep(2000);
		Actions actions = new Actions(driver);
		waitForAngularPageToLoad();
		WebElement menuOption = driver.findElement(By.xpath("//a[contains(@href,'/results')]"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		sleep(2000);
		menuOption.click();
		waitForAngularPageToLoad();

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());
		System.out.println("json value:" + json);
		Object resultsObject = JsonUtils.getNestedJsonStringValueByKey(json, "Results.TotalDwellingArea");
		String totalDwellingAreaObjectValue = String.valueOf(resultsObject.toString()).trim();

		System.out.println("-----Result Details------");
		System.out.println("Expected - Total Dwelling Area Value from JSON:" + totalDwellingAreaObjectValue);
		System.out.println("Actual - Total Dwelling Area Value :"
				+ GetElementText(By.xpath("//span[contains(text(),'Total Dwelling Area')]/../span[2]")));

		org.junit.Assert.assertEquals("compare value totalDwellingAreaObjectValue", totalDwellingAreaObjectValue,
				GetElementText(By.xpath("//span[contains(text(),'Total Dwelling Area')]/../span[2]")));

		System.out.println("Living Room Area Value:"
				+ GetElementText(By.xpath("//span[contains(text(),'Living Room Area')]/../span[2]")));

		System.out.println("Living Room % Value:"
				+ GetElementText(By.xpath("//span[contains(text(),'Living Room %')]/../span[2]")));

		System.out.println(
				"Total Element Area Value:" + GetElementText(By.xpath("//span[contains(text(),exs)]/../span[2]")));

		System.out.println("Total Heat Loss Value:"
				+ GetElementText(By.xpath("//span[contains(text(),'Total Heat Loss')]/../span[2]")));

		System.out.println(
				"Total HLI Value:" + GetElementText(By.xpath("//span[contains(text(),'HLI (W/K/m')]/../span[2]")));

		sleep(2000);
		driver.findElement(By.id("results-tab")).click();

		waitForAngularPageToLoad();
		Object mainspaceheatingsystemObj = JsonUtils.getNestedJsonStringValueByKey(json,
				"Results.Mainspaceheatingsystem");
		String mainspaceheatingsystemObjValue = String.valueOf(mainspaceheatingsystemObj.toString()).trim();

		org.junit.Assert.assertEquals("compare value Mainspaceheatingsystem", mainspaceheatingsystemObjValue,
				GetElementText(By.xpath("//span[contains(text(),'Main space heating system')]/../span[2]")));

		// System.out.println("Adjusted Infiltration Rate
		// Value:"+GetElementText(By.xpath("//span[contains(text(),'Adjusted
		// Infiltration Rate (ac/h)")));

		waitForAngularPageToLoad();

	}

	@Then("Result details in Results Page")
	public void result_details_in_results_page(io.cucumber.datatable.DataTable dataTable) {

		sleep(2000);
		driver.findElement(By.id("results-tab")).click();

		waitForAngularPageToLoad();

	}

	@Then("user selects Survey that Exists")
	public void select_existing_survey(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		JSONObject json = new JSONObject(SuiteConstants.jsonString.toString());

		Object surveyDescription = JsonUtils.getNestedJsonStringValueByKey(json, data.get(0).get("Description"));
		System.out.println("survey Description:" + surveyDescription);

		sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'" + surveyDescription + "')]")).click();

		waitForAngularPageToLoad();
	}

	@Then("close the Browser")
	public void close_the_browser() {
		// Quit the WebDriver instance
		if (driver != null) {
			driver.quit();
		}

	}

	@Given("user Enters Ventilation section")
	public void select_ventilation_section() {
		waitForAngularPageToLoad();

		Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(By.xpath("//a[contains(@href,'/ventilation')]"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();
	}

	@Given("user Enters Lighting section")
	public void select_lighting_section() {

		waitForAngularPageToLoad();
		Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(By.xpath("//a[contains(@href,'/lighting')]"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();

		waitForAngularPageToLoad();
	}

	@Given("user Enters Renewables section")
	public void select_renewables_section() {
		sleep(2000);

		Actions actions = new Actions(driver);
		waitForAngularPageToLoad();
		WebElement menuOption = driver.findElement(By.xpath("//a[contains(@href,'/renewables')]"));

		actions.moveToElement(menuOption).perform();

		waitForAngularPageToLoad();
		menuOption.click();
		waitForAngularPageToLoad();

	}
}