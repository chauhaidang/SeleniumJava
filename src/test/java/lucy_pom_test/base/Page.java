package lucy_pom_test.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import core.helpers.Const;
import core.helpers.driverhelper.DriverManager;
import core.helpers.driverhelper.DriverName;
import lucy_data_driven_test.base.BaseTest;
import lucy_data_driven_test.utilities.ExcelReader;
import lucy_data_driven_test.utilities.MonitoringMail;
import lucy_pom_test.utilities.ExtentManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Page {

    public static WebDriver driver;
    public static Properties OR = new Properties();
    public static Properties Config = new Properties();
    public static FileInputStream fis;
    public static Logger log = LogManager.getLogger(BaseTest.class.getName());
    public static ExcelReader excel = new ExcelReader(Const.TEST_RESOURCE_PATH + "/excel/lucy_pom_test/testdata.xlsx");
    public ExtentReports report = ExtentManager.getInstance();
    public static ExtentTest test;
    public static String browser;
    public static WebDriverWait wait;

    //if your applications have their top menu bar, you should declare the page object of it here, cuz it always display at every page

    public Page() {
        //Make sure every sub class does not re-initialize this driver instance
        if(driver == null){
            DriverManager.setupDriver(DriverName.CHROME);
            driver = new ChromeDriver();
            driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
