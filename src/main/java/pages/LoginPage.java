package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(id = "username")
	public WebElement txt_username;

	@FindBy(id = "password")
	public WebElement txt_password;

	@FindBy(id = "LoginBtn")
	public WebElement btn_login;

	@FindBy(xpath = "//span[contains(text(),'Accept')]")
	public WebElement btn_Accept;

	@FindBy(xpath = "//input[contains(@name,'averageStoreyHeight')]")
	public List<WebElement> storyHeight;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUsernameAndPassword(String username, String password) {
		assertTrue(txt_username.isDisplayed());
		txt_username.clear();
		txt_username.sendKeys(username);

		txt_password.clear();
		txt_password.sendKeys(password);

	}

	public void clickLogin2() {

		/*
		 * Actions actions = new Actions(driver);
		 * 
		 * WebElement menuOption = driver .findElement(By.id("LoginBtn")); sleep(3000);
		 * actions.moveToElement(menuOption).perform();
		 */
		btn_login.click();
		// sleep(20000);

	}

	public void clickLogin() {
		sleep(15000);
		btn_login.click();

		// ScenarioStorage.getScenario().log("Log in is successfull");
		sleep(15000);
		System.out.println("wait for accept popup ");
		// waitUntilAngular5Ready();

		btn_Accept.click();
		waitForAngularPageToLoad();

		/*
		 * driver.findElement(By.xpath("//*[contains(@class,'survey-date')][1]")).click(
		 * ); sleep(15000);
		 * 
		 * driver.findElement(By.xpath("//a[@aria-label='Building']")).click();
		 * 
		 * sleep(4000);
		 */

	}

	public void navigateToPortal() {
		driver.navigate().to("https://deapuat.seai.ie/portal");
	}

}
