package lucy_pom_test.rough;

import core.helpers.driverhelper.DriverManager;
import core.helpers.driverhelper.DriverName;
import lucy_pom_test.pages.CustomerDetail;
import lucy_pom_test.pages.CustomerLogin;
import lucy_pom_test.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class rough {

    public static void main(String[] args) throws Exception {
        DriverManager.setupDriver(DriverName.CHROME);
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePage homePage = new HomePage(driver);
        homePage.goToHome();
        Assert.assertEquals(homePage.getTitle(),"XYZ Bank");
        homePage.goToCustomerLogin();

        CustomerLogin customerLogin = new CustomerLogin(driver);
        Assert.assertEquals(customerLogin.getUserNameTitle(), "Your Name :");
        Assert.assertEquals(customerLogin.getDefaultFromUserNameDropdown(), "---Your Name---");
        customerLogin.selectUserName("Harry Potter");
        customerLogin.clickLogin();

        CustomerDetail customerDetail = new CustomerDetail(driver);
        Assert.assertTrue(customerDetail.getWelcomeStatus().contains("Harry Potter"));
        customerDetail.selectAccountNumber("1004");
        Assert.assertEquals(customerDetail.getAccountNumberInfo(), "1004");

        Thread.sleep(3000);

        driver.close();
    }

}
