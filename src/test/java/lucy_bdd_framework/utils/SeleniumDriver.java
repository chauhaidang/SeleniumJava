package lucy_bdd_framework.utils;

import core.helpers.driverhelper.DriverManager;
import core.helpers.driverhelper.DriverName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static core.helpers.driverhelper.DriverManager.setupDriver;

public class SeleniumDriver {
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;
    private static SeleniumDriver seleniumDriver;
    private static WebDriver driver;
    private static WebDriverWait waitDriver;

    //The reason why we set this constructor to private because we don't want the instance of this class to be initialized by constructor default always
    //But only when we call below setDriver method
    private SeleniumDriver() {
        setupDriver(DriverName.CHROME);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void openPage(String url) {
        DriverManager.openPage(driver, url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        if (seleniumDriver == null) {
            seleniumDriver = new SeleniumDriver(); //This call the private constructor
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
}
