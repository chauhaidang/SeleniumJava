package lucy_data_driven_test.base;

import core.helpers.Const;
import core.helpers.driverhelper.DriverManager;
import core.helpers.driverhelper.DriverName;
import lucy_data_driven_test.utilities.DbManager;
import lucy_data_driven_test.utilities.ExcelReader;
import lucy_data_driven_test.utilities.MonitoringMail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    /*
     * Excel - done
     * Logs - done
     * Properties - done
     * TestNG - done
     * JavaMail - done
     * ReportNG
     * Database
     * WebDriver - done
     * Explicit and ImplicitWait - done
     * Keywords - done
     * Screenshots
     * Maven - Build tool
     * Jenkins
     *
     */

    public static WebDriver driver;
    public static Properties OR = new Properties();
    public static Properties Config = new Properties();
    public static FileInputStream fis;
    public static Logger log = LogManager.getLogger(BaseTest.class.getName());
    public static ExcelReader excel = new ExcelReader(Const.TEST_RESOURCE_PATH + "/excel/lucy_data_driven_test/testdata.xlsx");
    public static MonitoringMail mail = new MonitoringMail();
    public static WebDriverWait wait;
    public static WebElement dropdown;


    //before all class
    @BeforeSuite
    public void setUp() {
        if (driver == null) {

            //Load config file
            try {
                fis = new FileInputStream(Const.TEST_RESOURCE_PATH + "/properties/lucy_data_driven_test/Config.properties");
                Config.load(fis);
                log.info("Config file loaded!");
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Load object file
            try {
                fis = new FileInputStream(Const.TEST_RESOURCE_PATH + "/properties/lucy_data_driven_test/OR.properties");
                OR.load(fis);
                log.info("Object Repository file loaded!");
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Set up driver
            if (Config.getProperty("browser").equalsIgnoreCase(DriverName.CHROME)) {
                DriverManager.setupDriver(DriverName.CHROME);
                driver = new ChromeDriver();
                log.info("Successfully set up " + Config.getProperty("browser") + " and launched");
            } else if (Config.getProperty("browser").equalsIgnoreCase(DriverName.FIREFOX)) {
                DriverManager.setupDriver(DriverName.FIREFOX);
                driver = new FirefoxDriver();
                log.info("Successfully set up " + Config.getProperty("browser") + " and launched");
            }

            driver.get(Config.getProperty("url"));
            log.info("navigated to url " + Config.getProperty("url"));

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
            log.info("set implicit wait completed!");

            //Connect to db
//            try {
//                DbManager.setMysqlDbConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }

            //Set explicit wait if needed
            wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));
            log.info("set explicit wait completed!");
        }
    }

    public static void click(String locatorKey) {


        if (locatorKey.endsWith("_XPATH")) {

            driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();

        } else if (locatorKey.endsWith("_CSS")) {

            driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();

        } else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

            driver.findElement(By.id(locatorKey)).click();

        }

        log.info("Clicking on an Element : " + locatorKey);

    }

    public static void type(String locatorKey, String value) throws IOException, AddressException, MessagingException {

        if (locatorKey.endsWith("_XPATH")) {

            driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);

        } else if (locatorKey.endsWith("_CSS")) {

            driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);

        } else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

            driver.findElement(By.id(locatorKey)).sendKeys(value);

        }

        log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);

    }

    public static void select(String locatorKey, String value) throws IOException, AddressException, MessagingException {


        if (locatorKey.endsWith("_XPATH")) {

            dropdown = driver.findElement(By.xpath(OR.getProperty(locatorKey)));

        } else if (locatorKey.endsWith("_CSS")) {

            dropdown = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));

        } else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

            dropdown = driver.findElement(By.id(locatorKey));

        }
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);

        log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);

    }

    public static boolean isElementPresent(String locatorKey) {

        try {

            if (locatorKey.endsWith("_XPATH")) {

                driver.findElement(By.xpath(OR.getProperty(locatorKey)));

            } else if (locatorKey.endsWith("_CSS")) {

                driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));

            } else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

                driver.findElement(By.id(locatorKey));

            }

            log.info("Finding the Element : " + locatorKey);
            return true;
        } catch (Throwable t) {
            log.error("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
            return false;
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        log.info("Test execution completed!");
    }
}
