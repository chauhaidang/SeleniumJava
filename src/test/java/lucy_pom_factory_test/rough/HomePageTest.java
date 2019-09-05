package lucy_pom_factory_test.rough;

import core.helpers.driverhelper.DriverManager;
import core.helpers.driverhelper.DriverName;
import lucy_pom_factory_test.base.Page;
import lucy_pom_factory_test.pages.actions.AddCustomer;
import lucy_pom_factory_test.pages.actions.BankManager;
import lucy_pom_factory_test.pages.actions.Home;
import lucy_pom_factory_test.pages.model.CustomerBuilder;
import lucy_pom_factory_test.pages.model.CustomerModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePageTest {

    public static void main(String[] args) throws InterruptedException {
        Page.initConfiguration();
        Home home = new Home();
        home.goToHome();
        System.out.println(home.getTitle());
        home.goToCustomerLogin();
        Thread.sleep(2000);

        //Bank manager test

        home.goToHome();
        System.out.println(home.getTitle());
        home.goToBankManagerLogin();

        BankManager bankManager = new BankManager();
        bankManager.goToAddCustomer();
        Thread.sleep(2000);

        AddCustomer addCustomer = new AddCustomer();
        CustomerModel newCustomer = addCustomer.fillCustomerForm(new CustomerBuilder()
                .withFirstName("Dang")
                .withLastName("Chau")
                .withPostCode("123")
                .build()
        );
        Thread.sleep(3000);
        newCustomer.printCustomerInfo();

        Page.quitBrowser();
    }
}
