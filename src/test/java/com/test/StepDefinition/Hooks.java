package com.test.StepDefinition;

import com.test.utils.PropertyReader;
import com.test.utils.ResourceAPI;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

    public class Hooks {

        public static WebDriver driver;

        @Before
        public void LaunchUrl() throws Exception {
            PropertyReader prop = new PropertyReader();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            String browserName = PropertyReader.getValue("browser");
            capabilities.setBrowserName(browserName);
            HashMap<String, String> driverDetails = new HashMap<String, String>();
            driverDetails.put("chrome", "webdriver.chrome.driver");
            driverDetails.put("firefox", "webdriver.gecko.driver");
            String driverPath = System.getProperty("user.dir") + "/resources/driver/" + browserName;
            System.setProperty(driverDetails.get(browserName), driverPath);

            switch (browserName) {
                case "chrome": {
                    driver = new ChromeDriver(capabilities);
                }

			/* ToDo - implement other drivers if required
			case "firefox": {
				driver = new FirefoxDriver(capabilities);
			}*/
                break;
                default:
            }
            driver.manage().timeouts().implicitlyWait(prop.getTimeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(prop.getTimeout(), TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(PropertyReader.getValue("url") + ResourceAPI.getUserName());
        }

        @After
        public void embedScreenshot(Scenario scenario) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
            driver.quit();
        }
    }


