package lucy_pom_test.base;

import core.helpers.driverhelper.DriverManager;
import core.helpers.driverhelper.DriverName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Page {

    public static WebDriver driver;

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
