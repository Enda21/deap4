package utils;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.Dimension;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver = null;

	private static WebDriverWait jsWait;
	public static JavascriptExecutor jsExec;
	public static NgWebDriver waitDriver = null;

	public void LaunchBrowser() {
		 if (driver == null) {
		// String projectPath = System.getProperty("user.dir");
		// System.out.println("Project path" + projectPath);

		// // Creating an object of EdgeDriver
		// // System.setProperty("webdriver.edge.driver",
		// // "src//test//resources//Drivers//msedgedriver.exe");
		// // EdgeOptions edgeOptions = new EdgeOptions();
		// // edgeOptions.setPageLoadStrategy("normal");
		// // driver = new EdgeDriver(edgeOptions);

		// // Creating an object of chromedriver for Linux
		// // ChromeOptions option = new ChromeOptions();
		// // option.addArguments("--remote-allow-origins=*", "--headless");
		// // System.setProperty("webdriver.chrome.driver", projectPath +
		// // "/src/test/resources/Drivers/chromedriver");
		// // driver = new ChromeDriver(option);

		// // Local Creating an object of chromedriver
		// ChromeOptions option = new ChromeOptions();
		// option.addArguments("--remote-allow-origins=*", "--headless");
		// System.setProperty("webdriver.chrome.driver", projectPath +
		// "/src/test/resources/Drivers/chromedriver.exe");
		// driver = new ChromeDriver(option);
		// driver.manage().window().maximize();

		// driver.navigate().to("https://deapuat.seai.ie/");
		// // driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(3));

		// sleep(10000);
		// // jsWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		// jsExec = (JavascriptExecutor) driver;
		// waitDriver = new NgWebDriver(jsExec);
		// }

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path" + projectPath);
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*","--headless");
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		System.setProperty("webdriver.chrome.driver", projectPath +
				"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver(option);

		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1920, 1080)); // Set window size

		driver.navigate().to("https://deapuat.seai.ie/");
		driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

		sleep(10000);
		// jsWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		jsExec = (JavascriptExecutor) driver;
		waitDriver = new NgWebDriver(jsExec);
	 }
	}

	public void waitForAngularPageToLoad() {

		sleep(5000);
		waitForPageLoaded(driver);
		sleep(5000);

	}

	/*
	 * public test (WebDriver driver) { this.driver=driver;
	 * PageFactory.initElements(driver, this); wait=new WebdriverWait(driver,60);
	 * 
	 * }
	 */
	public NgWebDriver getNgWebDriver() {
		jsExec = (JavascriptExecutor) driver;
		return (new NgWebDriver(jsExec));

	}

	public void waitUntilAngularReady() {
		try {
			Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
			if (!angularUnDefined) {
				Boolean angularInjectorUnDefined = (Boolean) jsExec
						.executeScript("return angular.element(document).injector() === undefined");
				if (!angularInjectorUnDefined) {
					poll(20);
					waitForAngularPageToLoad();
					poll(20);
				}
			}
		} catch (WebDriverException ignored) {
		}
	}

	public void waitUntilAngular5Ready() {
		try {
			Object angular5Check = jsExec.executeScript("return getAllAngularRootElements()[0].attributes['ng-app']");
			if (angular5Check != null) {
				Boolean angularPageLoaded = (Boolean) jsExec
						.executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1");
				if (!angularPageLoaded) {
					poll(20);
					waitForAngularPageToLoad();
					poll(20);
				}
			}
		} catch (WebDriverException ignored) {
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void poll(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForAngularLoad() {
		String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
		angularLoads(angularReadyScript);
	}

	private void angularLoads(String angularReadyScript) {
		try {
			ExpectedCondition<Boolean> angularLoad = driver -> Boolean
					.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());
			boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());
			if (!angularReady) {
				jsWait.until(angularLoad);
			}
		} catch (WebDriverException ignored) {
		}
	}

	// private void waitForAngular5Load() {

	public void waitForAngularPageToLoad2() {
		String angularReadyScript = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";
		angularLoads(angularReadyScript);
	}

	public void waitForAngularPageToLoad1() {

		JavascriptExecutor jsexec = ((JavascriptExecutor) driver);
		Object result = jsexec.executeScript(
				"return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)");
		System.out.println("Boolean" + (boolean) result);

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 * 
		 * wait.until(angularHasFinishedProcessing());
		 */

	}

	public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
		return new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver1) {
				JavascriptExecutor jsexec = ((JavascriptExecutor) driver1);
				Object result = jsexec.executeScript(
						"return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)");
				return Boolean.valueOf((boolean) result);
			}

		};
	}

	/*
	 * public void waitForAngularPageToLoad() { // sleep(2000); String
	 * hasAngularFinishedScript =
	 * "var callback = arguments[arguments.length - 1];\n" +
	 * 
	 * "var el = document.querySelector('html');\n" +
	 * 
	 * "if (!window.angular) {\n" +
	 * 
	 * "    callback('false')\n" +
	 * 
	 * "}\n" +
	 * 
	 * "if (angular.getTestability) {\n" +
	 * 
	 * "    angular.getTestability(el).whenStable(function(){callback('true')});\n"
	 * +
	 * 
	 * "} else {\n" +
	 * 
	 * "    if (!angular.element(el).injector()) {\n" +
	 * 
	 * "        callback('false')\n" +
	 * 
	 * "    }\n" +
	 * 
	 * "    var browser = angular.element(el).injector().get('$browser');\n" +
	 * 
	 * "    browser.notifyWhenNoOutstandingRequests(function(){callback('true')});\n"
	 * +
	 * 
	 * "}";
	 * 
	 * JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
	 * 
	 * Date now = new Date(); now.setSeconds(now.getSeconds() +
	 * SuiteConstants.maxTimeout); System.out.println("now time :" + now.getTime());
	 * System.out.println("new Date current time  :" + new Date().getTime());
	 * 
	 * boolean isPageLoaded = false;
	 * 
	 * 
	 * while (new Date().getTime() < now.getTime() && (!isPageLoaded)) {
	 * 
	 * try { isPageLoaded = Boolean.valueOf(javascriptExecutor.executeAsyncScript(
	 * hasAngularFinishedScript).toString());
	 * System.out.println("Current page load status:"+isPageLoaded);
	 * //Thread.sleep(2000); } catch (Exception e) {
	 * 
	 * 
	 * } }
	 */

	/*
	 * final String script = "var callback = arguments[arguments.length - 1];\n" +
	 * 
	 * "var el = document.querySelector('html');\n" +
	 * 
	 * "if (!window.angular) {\n" +
	 * 
	 * "    callback('false')\n" +
	 * 
	 * "}\n" +
	 * 
	 * "if (angular.getTestability) {\n" +
	 * 
	 * "    angular.getTestability(el).whenStable(function(){callback('true')});\n"
	 * +
	 * 
	 * "} else {\n" +
	 * 
	 * "    if (!angular.element(el).injector()) {\n" +
	 * 
	 * "        callback('false')\n" +
	 * 
	 * "    }\n" +
	 * 
	 * "    var browser = angular.element(el).injector().get('$browser');\n" +
	 * 
	 * "    browser.notifyWhenNoOutstandingRequests(function(){callback('true')});\n"
	 * +
	 * 
	 * "}";
	 * 
	 * ((JavascriptExecutor) driver).executeAsyncScript(script, new Object[0]);
	 */
	// }

	public static void sleep(int time) {
		try {
			TimeUnit.MILLISECONDS.sleep(time);
			// Thread.sleep(time);
		} catch (InterruptedException e) {

		}
	}

	public void selectByTextFromDropdown(WebElement element, By optionElement, int index) {

		element.click();
		sleep(2000);
		List<WebElement> options = driver.findElements(optionElement);
		System.out.println("Option size:" + options.size());
		options.get(index).click();
		sleep(1000);
	}

	public void selectByTextFromDropdown(WebElement element, By optionElement, String text) {

		element.click();
		sleep(2000);
		List<WebElement> options = driver.findElements(optionElement);
		System.out.println("Option size:" + options.size());
		for (WebElement option : options) {
			System.out.println("option get text value :" + option.getText().trim() + ":" + text + ":");
			System.out.println("option get text value :" + option.getText().equals(text) + ":" + text + ":");

			if (option.getText().contains(text.trim())) {

				option.click();
				waitForAngularPageToLoad();
				break;
			}
		}

	}

	public void selectByTextFromDropdown(WebElement element, By optionElement, Object text) {

		element.click();
		sleep(2000);
		List<WebElement> options = driver.findElements(optionElement);
		System.out.println("Option size:" + options.size());
		for (WebElement option : options) {
			System.out.println("option get text value :" + option.getText().trim() + ":" + text.toString() + ":");

			if (option.getText().contains(text.toString().trim())) {

				option.click();
				waitForAngularPageToLoad();
				break;
			}
		}

	}

	public void selectByTextFromDropdown(WebElement element, By optionElement) {

		System.out.println("Element from optionElement :" + optionElement);
		element.click();
		waitForAngularPageToLoad();
		driver.findElement(optionElement).click();
		waitForAngularPageToLoad();

	}

	public void click(WebElement element) {
		waitForElementPresent(element);

		element.clear();
		element.click();

	}

	public void clickAndWait(WebElement element) {
		waitForElementPresent(element);
		element.click();
		waitForAngularPageToLoad();
	}

	public void clickAndWait(By by) {
		WebElement element = driver.findElement(by);
		waitForElementPresent(element);
		element.click();
		waitForAngularPageToLoad();
	}

	public void sendKeys(By by, String value) {
		WebElement element = driver.findElement(by);
		waitForElementPresent(element);
		element.clear();
		element.sendKeys(value);
		waitForAngularPageToLoad();
	}

	public void sendKeys(WebElement element, String value) {
		waitForElementPresent(element);
		element.clear();
		element.sendKeys(value);
		waitForAngularPageToLoad();
	}

	public void clickClearSendKeys(WebElement element, String value) {
		waitForElementPresent(element);
		element.click();
		element.clear();
		element.sendKeys(value);
		waitForAngularPageToLoad();
	}

	public void selectByTextFromDropdown(WebElement element, String text) {
		element.click();
		sleep(2000);
		List<WebElement> options = element.findElements(By.xpath("//md-option/div"));
		System.out.println("Option size:" + options.size());
		for (WebElement option : options) {
			System.out.println("option get text value :" + option.getText());
			if (option.getText().contains(text)) {
				System.out.println("clicked a value:");
				option.click();
				sleep(1000);
				break;
			}
		}

	}

	/*
	 * public void CheckOrUnCheck(WebElement element, String status) { String
	 * actualStatus = element.getAttribute("aria-checked").trim().toLowerCase(); if
	 * (status.toLowerCase().trim().equals("yes") && actualStatus.equals("false")) {
	 * element.click(); } else if (status.toLowerCase().trim().equals("no") &&
	 * actualStatus.equals("true")) { element.click(); } }
	 */

	public boolean Check(WebElement element) {

		boolean actualStatus = element.getAttribute("aria-checked").trim().toLowerCase().equals("true");
		if (!actualStatus) {
			// check action not performed
			element.click();
			waitForAngularPageToLoad();
			actualStatus = true;
		}
		return actualStatus;
	}

	public boolean UnCheck(WebElement element) {

		boolean actualStatus = element.getAttribute("aria-checked").trim().toLowerCase().equals("false");
		if (!actualStatus) {
			element.click();
			waitForAngularPageToLoad();
			actualStatus = true;
		}
		return actualStatus;
	}

	public void checkOrUncheck(WebElement element, String expStatus) {

		boolean actualStatus = element.getAttribute("aria-checked").trim().toLowerCase().equals("true");
		if (!actualStatus && expStatus.trim().equalsIgnoreCase("true")) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			waitForAngularPageToLoad();
		}
		if (actualStatus && (expStatus.trim().equalsIgnoreCase("flase"))) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			waitForAngularPageToLoad();
		}
	}

	public boolean isChecked(WebElement element) {
		if (element.getAttribute("aria-checked").trim().equalsIgnoreCase("true")) {
			return true;
		} else {
			return false;
		}
	}

	public String GetElementText(By by) {

		waitForAngularPageToLoad();
		return driver.findElement(by).getText().trim();

	}

	public void WaitForElement(By by) {
		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * 
		 * WebDriverWait wait = new
		 * WebDriverWait(driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10
		 * )); wait.until(ExpectedConditions.visibilityOfElementLocated(by);
		 */

	}

	public static void waitForPageLoaded(WebDriver webDriver) {
		ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver)
				.executeAsyncScript("var callback = arguments[arguments.length - 1];"
						+ "if (document.readyState !== 'complete') {" + "  callback('document not ready');" + "} else {"
						+ "  try {" + "    var testabilities = window.getAllAngularTestabilities();"
						+ "    var count = testabilities.length;" + "    var decrement = function() {"
						+ "      count--;" + "      if (count === 0) {" + "        callback('complete');" + "      }"
						+ "    };" + "    testabilities.forEach(function(testability) {"
						+ "      testability.whenStable(decrement);" + "    });" + "  } catch (err) {"
						+ "    callback(err.message);" + "  }" + "}")
				.toString().equals("complete");

		try {
			FluentWait wait = new FluentWait(webDriver);
			wait.withTimeout(Duration.ofSeconds(35))
					// wait.withTimeout(25000, TimeUnit.MILLISECONDS)
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
					.ignoring(ElementClickInterceptedException.class);
			wait.until(expectation);

		} catch (Throwable error) {
			new Exception("Timeout waiting for Page Load Request to complete.");
		}
	}

	public static void waitForElementPresent(WebElement element) {
		try {
			FluentWait wait = new FluentWait(driver);
			wait.withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Throwable error) {
			new Exception("Timeout waiting for Page Load Request to complete.");
		}
	}

	/*
	 * public static void waitForPageLoaded3(WebDriver webDriver) {
	 * ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	 * public Boolean apply(WebDriver driver) { return ((JavascriptExecutor)
	 * driver).executeAsyncScript( "var callback = arguments[arguments.length - 1];"
	 * + "if (document.readyState !== 'complete') {" +
	 * "  callback('document not ready');" + "} else {" + "  try {" +
	 * "    var testabilities = window.getAllAngularTestabilities();" +
	 * "    var count = testabilities.length;" + "    var decrement = function() {"
	 * + "      count--;" + "      if (count === 0) {" +
	 * "        callback('complete');" + "      }" + "    };" +
	 * "    testabilities.forEach(function(testability) {" +
	 * "      testability.whenStable(decrement);" + "    });" + "  } catch (err) {"
	 * + "    callback(err.message);" + "  }" + "}" ).toString().equals("complete");
	 * } }; try { WebDriverWait wait = new
	 * WebDriverWait(webDriver,Duration.ofSeconds(25)); wait.until(expectation); }
	 * catch (Throwable error) { new
	 * Exception("Timeout waiting for Page Load Request to complete."); } }
	 */

	protected static String convertFromScientificNotation(String number) {
		// Check if in scientific notation
		if (number.trim().toLowerCase().contains("e")) {
			System.out.println("The scientific notation number'" + number
					+ "' detected, it will be converted to normal representation with 25 maximum fraction digits.");
			// DecimalFormat format = new DecimalFormat("#00,000,000.00");
			DecimalFormat formatter = new DecimalFormat();
			formatter.setMaximumFractionDigits(25);
			return formatter.format(number);

		} else
			return number;
	}

	public static void hoverOpenNavigation() {
		// Locate the element to hover over
		WebElement elementToHover = driver.findElement(By.xpath("//mat-nav-list[@role='navigation']"));

		// Create an instance of Actions class
		Actions actions = new Actions(driver);

		// Perform the hover action
		actions.moveToElement(elementToHover).perform();
	}

}