package core.helpers.driverhelper;

import core.helpers.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static core.helpers.driverhelper.DriverName.CHROME;
import static core.helpers.driverhelper.DriverName.FIREFOX;

public class DriverManager {
    public static void setupDriver(String driverName) {
        switch (driverName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                break;
            default:
                throw new Error("There is no appropriate driver name: " + driverName);
        }
    }

    /**
     * To ignore predictable alert
     *
     * @param driver
     */
    public static void ignoreAlert(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.alert = () => 0");
        Log.debug("Ignored upcoming alert!");
    }
}

