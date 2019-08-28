package lucy_pom_test.rough;

import core.helpers.driverhelper.DriverManager;
import core.helpers.driverhelper.DriverName;
import lucy_pom_test.base.Page;
import lucy_pom_test.pages.CustomerDetail;
import lucy_pom_test.pages.CustomerLogin;
import lucy_pom_test.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class rough {

    public static void main(String[] args) throws Exception {

        HomePage homePage = new HomePage();
        homePage.goToHome();
        Assert.assertEquals(homePage.getTitle(),"XYZ Bank");
        homePage.goToCustomerLogin();

        CustomerLogin customerLogin = new CustomerLogin();
        Assert.assertEquals(customerLogin.getUserNameTitle(), "Your Name :");
        Assert.assertEquals(customerLogin.getDefaultFromUserNameDropdown(), "---Your Name---");
        customerLogin.selectUserName("Harry Potter");
        customerLogin.clickLogin();

        CustomerDetail customerDetail = new CustomerDetail();
        Assert.assertTrue(customerDetail.getWelcomeStatus().contains("Harry Potter"));
        customerDetail.selectAccountNumber("1004");
        Assert.assertEquals(customerDetail.getAccountNumberInfo(), "1004");

        Thread.sleep(3000);

        Page.driver.close();
    }

}
