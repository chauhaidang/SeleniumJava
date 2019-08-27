package core.helpers.driverhelper;

import io.github.bonigarcia.wdm.WebDriverManager;

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
}

