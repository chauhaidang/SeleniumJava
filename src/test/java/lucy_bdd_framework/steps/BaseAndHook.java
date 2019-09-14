package lucy_bdd_framework.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lucy_bdd_framework.utils.SeleniumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseAndHook {

    @Before
    public static void beforeEachScenario() {
        SeleniumDriver.setDriver();
    }

    @After
    public static void afterEachScenario(Scenario scenario) {
        WebDriver tempDriver = SeleniumDriver.getDriver();
        if (scenario.isFailed()) {
            byte[] screenshotByte = ((TakesScreenshot) tempDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotByte, "image/png");
        }
        SeleniumDriver.tearDown();
    }
}
