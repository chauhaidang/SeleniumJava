package lucy_pom_test.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import core.helpers.Const;
import core.helpers.driverhelper.DriverManager;
import core.helpers.driverhelper.DriverName;
import core.helpers.driverhelper.OptionsMapper;
import lucy_data_driven_test.base.BaseTest;
import lucy_data_driven_test.utilities.ExcelReader;
import lucy_pom_test.utilities.ExtentManager;
import lucy_pom_test.utilities.Utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static core.helpers.Const.*;

public class Page {

    public static WebDriver driver;
    public static Properties OR = new Properties();
    public static Properties Config = new Properties();
    public static FileInputStream fis;

    public static Logger log = LogManager.getLogger(BaseTest.class.getName());
    public static ExcelReader excel = new ExcelReader(Const.TEST_RESOURCE_PATH + "/excel/lucy_pom_test/testdata.xlsx");

    public ExtentReports report = ExtentManager.getInstance();
    //This will listen and manage all log report for your testcases for the listener
    public static ExtentTest test;

    //public static String browser;
    public static WebDriverWait wait;
    public static WebElement dropdown;

    //if your applications have their top menu bar, you should declare the page object of it here, cuz it always display at every page

    public Page() {
        //Make sure every sub class does not re-initialize this driver instance
        if (driver == null) {

            //Load config file
            try {
                fis = new FileInputStream(Const.TEST_RESOURCE_PATH + "/properties/lucy_pom_test/Config.properties");
                Config.load(fis);
                log.info("Config file loaded!");
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Load object file
            try {
                fis = new FileInputStream(Const.TEST_RESOURCE_PATH + "/properties/lucy_pom_test/OR.properties");
                OR.load(fis);
                log.info("Object Repository file loaded!");
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Set up driver
            if (Config.getProperty("browser").equalsIgnoreCase(DriverName.CHROME)) {
                DriverManager.setupDriver(DriverName.CHROME);

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                List<String> args = new OptionsMapper(DriverName.CHROME)
                        .withOption("--disable-extensions")
                        .withOption("--disable-infobars")
                        .build();
                options.addArguments(args);

                driver = new ChromeDriver();
                log.info("Successfully set up " + Config.getProperty("browser") + " and launched");
            } else if (Config.getProperty("browser").equalsIgnoreCase(DriverName.FIREFOX)) {
                DriverManager.setupDriver(DriverName.FIREFOX);
                driver = new FirefoxDriver();
                log.info("Successfully set up " + Config.getProperty("browser") + " and launched");
            }

            driver.get(Config.getProperty("url"));
            log.info("navigate to " + Config.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);

            wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));
        }
    }

    public static void quit() {
        driver.quit();
    }

    //Set up some common keyword
    public static void click(String locatorKey) {


        if (locatorKey.endsWith(XPATH)) {

            driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();

        } else if (locatorKey.endsWith(CSS)) {

            driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();

        } else if (locatorKey.endsWith(ID)) {

            driver.findElement(By.id(OR.getProperty(locatorKey))).click();

        }

        log.info("Clicking on an Element : " + locatorKey);

    }

    public static void type(String locatorKey, String value) throws IOException, AddressException, MessagingException {

        if (locatorKey.endsWith(XPATH)) {

            driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);

        } else if (locatorKey.endsWith(CSS)) {

            driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);

        } else if (locatorKey.endsWith(ID)) {

            driver.findElement(By.id(OR.getProperty(locatorKey))).sendKeys(value);

        }

        log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);

    }

    public static void select(String locatorKey, String value) throws IOException, AddressException, MessagingException {


        if (locatorKey.endsWith(XPATH)) {

            dropdown = driver.findElement(By.xpath(OR.getProperty(locatorKey)));

        } else if (locatorKey.endsWith(CSS)) {

            dropdown = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));

        } else if (locatorKey.endsWith(ID)) {

            dropdown = driver.findElement(By.id(OR.getProperty(locatorKey)));

        }
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);

        log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);

    }

    public static boolean isElementPresent(String locatorKey) {
        try {
            if (locatorKey.endsWith(XPATH)) {

                driver.findElement(By.xpath(OR.getProperty(locatorKey)));

            } else if (locatorKey.endsWith(CSS)) {

                driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));

            } else if (locatorKey.endsWith(ID)) {

                driver.findElement(By.id(OR.getProperty(locatorKey)));

            }
            log.info("Finding the Element : " + locatorKey);
            return true;
        } catch (Throwable t) {
            log.error("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
            return false;
        }
    }

    public static String getText(String locatorKey) {

        String elementValue = null;

        if (locatorKey.endsWith(XPATH)) {

            elementValue = driver.findElement(By.xpath(OR.getProperty(locatorKey))).getText();

        } else if (locatorKey.endsWith(CSS)) {

            elementValue = driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).getText();

        } else if (locatorKey.endsWith(ID)) {

            elementValue = driver.findElement(By.id(OR.getProperty(locatorKey))).getText();

        }

        log.info("Get display text of an Element : " + locatorKey);
        return elementValue;
    }

    public static Select getDropdownSelector(String locatorKey){
        if (locatorKey.endsWith(XPATH)) {

            dropdown = driver.findElement(By.xpath(OR.getProperty(locatorKey)));

        } else if (locatorKey.endsWith(CSS)) {

            dropdown = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));

        } else if (locatorKey.endsWith(ID)) {

            dropdown = driver.findElement(By.id(OR.getProperty(locatorKey)));

        }
        return new Select(dropdown);
    }

    public static void verifyEquals(String expected, String actual) throws IOException {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable t) {
            Utilities.captureScreenshot();

            //ReportNG
            Reporter.log("<br>" + "Verification failed: " + t.getMessage() + "<br>");
            Reporter.log("<a target=\"_blank\" href=" + Utilities.fileName + "><img src=" + Utilities.fileName + " height=200 width=200></a>");
            Reporter.log("<br>");
            Reporter.log("<br>");

            //Extent Report
            test.log(LogStatus.FAIL, "Verification failed with exception: " + t.getMessage());
            test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.fileName));
        }
    }
}
