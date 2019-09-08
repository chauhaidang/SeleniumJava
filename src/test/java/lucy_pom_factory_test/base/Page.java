package lucy_pom_factory_test.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import core.helpers.Const;
import core.helpers.ExcelReader;
import core.helpers.driverhelper.DriverManager;
import core.helpers.driverhelper.DriverName;
import core.helpers.driverhelper.OptionsMapper;
import core.helpers.elementHelper.ElementAction;
import lucy_pom_factory_test.collector.ErrorCollector;
import lucy_pom_factory_test.pages.actions.TopNavigation;
import lucy_pom_factory_test.utilities.ExtentManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page {

    /**
     * WebDriver
     * ExcelReader
     * Logs
     * WebDriverWait
     * ExtentReport
     */


    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(Page.class.getName());
    public static ExcelReader excel = new ExcelReader(Const.TEST_RESOURCE_PATH + "/excel/lucy_pom_factory_test/testdata.xlsx");
    public static WebDriverWait wait;
    public ExtentReports rep = ExtentManager.getInstance();
    //This will listen and manage all log report for your testcases for the listener
    public static ExtentTest test;
    public static TopNavigation topNav;

    public static void click(WebElement element) {
        try {
            ElementAction.clickSupport(element);
            test.log(LogStatus.INFO, "Clicked on an Element : " + element);
        } catch (Throwable e) {
            ErrorCollector.addThrowableMessages(e);
        }
    }

    public static String getText(WebElement element) {
        String value = null;
        try {
            value = ElementAction.getTextSupport(element);
            test.log(LogStatus.INFO, "Got text from element: " + element + "with value: " + value);
        } catch (Throwable e) {
            ErrorCollector.addThrowableMessages(e);
        }
        return value;
    }

    public static void initConfiguration(){
        //Set up driver
        if (ConfigConst.browser.equalsIgnoreCase(DriverName.CHROME)) {
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
            log.debug("Successfully set up " + ConfigConst.browser + " and launched");
        } else if (ConfigConst.browser.equalsIgnoreCase(DriverName.FIREFOX)) {
            DriverManager.setupDriver(DriverName.FIREFOX);
            driver = new FirefoxDriver();
            log.debug("Successfully set up " + ConfigConst.browser + " and launched");
        }

        driver.get(ConfigConst.url);
        log.debug("Navigated to URL "+ ConfigConst.url);
        driver.manage().window().maximize();
        log.debug("Maximized window!");
//        driver.manage().timeouts().implicitlyWait(ConfigConst.timeout, TimeUnit.SECONDS);
//        log.debug("Set implicit wait time out to "+ ConfigConst.timeout);

        topNav = new TopNavigation(driver); //Init top navigation page because it always appear along with all page
    }

    public static void quitBrowser(){
        driver.close();
        log.debug("Closed browser!");
    }
}
