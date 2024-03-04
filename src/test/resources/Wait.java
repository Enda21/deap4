import java.io.File;

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxBinary;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.support.ui.WebDriverWait;

 

import com.relevantcodes.extentreports.LogStatus;

 

public class Wait {

 

                public static WebDriver driver;

                static String userDirectory = System.getProperty("user.dir").replaceAll("\\\\", "/");

                public static SoftAssertChp softAssert = new SoftAssertChp();

 

                public WebDriver createWebDriver() throws InterruptedException {

                               

                                String browser = ConfigReader.getProperty("browser");

                /* String osName = System.getProperty("os.name");

                                String osNameMatch = osName.toLowerCase();

                                if(osNameMatch.contains("linux")) {

                                                System.out.println("Detected Linux Machine for the execution");

                                                if (browser.equals("firefox")) {

                                                                String Xport = System.getProperty("lmportal.xvfb.id", ":1");

                                                                final File firefoxPath = new File(System.getProperty("lmportal.deploy.firefox.path", "/home/ec2-user/firefox/firefox"));

                                                                FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);

                                                                firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);

                                                                driver = new FirefoxDriver(firefoxBinary, null);

                                                }

                                }else if(osNameMatch.contains("windows")) */{

                                                if (browser.equals("firefox")) {

                                                                driver = new FirefoxDriver();

                                                } else if (browser.equals("chrome")) {

                                                                System.setProperty("webdriver.chrome.driver", userDirectory + "/src/test/resources/Drivers/chromedriver.exe");

                                                                driver=new ChromeDriver();

                                                } else if (browser.equals("ie") || browser.equals("internetexplorer")) {

                                                                System.setProperty("webdriver.ie.driver",  userDirectory + "/src/test/resources/Drivers/IEDriverServer.exe");

                                                                driver = new InternetExplorerDriver();

                                                }

                                }

                               

                                return driver;

                }

               

                public void launchApplication(String url) throws InterruptedException {

                                driver.navigate().to(url);

                                System.out.println("Launch URL \"" + url + "\"");

                                ExtentReport.getTest().log(LogStatus.PASS, "Launch URL \"" + url + "\"");

                                driver.manage().window().maximize();

                                Thread.sleep(5000);

                }

               

                public static WebDriver getWebDriver() {

                                return driver;

                }

               

                public void quitWebDriver() {

                                driver.quit();

                }

               

                @SuppressWarnings("unchecked")

                public static void waitForAngularHasFinishedProcessing(){

                    try{

                        driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

                        WebDriverWait wait = new WebDriverWait(driver, 60, 100);

                        wait.until(angularHasFinishedProcessing());

                       } catch(Throwable e){

                    }

                }

               

                @SuppressWarnings("rawtypes")

                public static ExpectedCondition angularHasFinishedProcessing() {

                        return new ExpectedCondition<Boolean>() {

                            @Override

                            public Boolean apply(WebDriver driver) {

                                String hasAngularFinishedScript = "var callback = arguments[arguments.length - 1];\n" +

                                        "var el = document.querySelector('html');\n" +

                                        "if (!window.angular) {\n" +

                                        "    callback('false')\n" +

                                        "}\n" +

                                        "if (angular.getTestability) {\n" +

                                        "    angular.getTestability(el).whenStable(function(){callback('true')});\n" +

                                        "} else {\n" +

                                        "    if (!angular.element(el).injector()) {\n" +

                                        "        callback('false')\n" +

                                        "    }\n" +

                                        "    var browser = angular.element(el).injector().get('$browser');\n" +

                                        "    browser.notifyWhenNoOutstandingRequests(function(){callback('true')});\n" +

                                        "}";

 

                                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

                                String isProcessingFinished = javascriptExecutor.executeAsyncScript(hasAngularFinishedScript).toString();

 

                                return Boolean.valueOf(isProcessingFinished);

                            }

                        };

                    }

}