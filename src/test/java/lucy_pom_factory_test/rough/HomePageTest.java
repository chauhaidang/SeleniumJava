package lucy_pom_factory_test.rough;

import lucy_pom_factory_test.pages.actions.AddCustomer;
import lucy_pom_factory_test.pages.actions.BankManager;
import lucy_pom_factory_test.pages.actions.Home;
import lucy_pom_factory_test.pages.model.CustomerBuilder;
import lucy_pom_factory_test.pages.model.CustomerModel;
import org.testng.Assert;

import static lucy_pom_factory_test.base.Page.*;

public class HomePageTest {

    public static void main(String[] args) throws InterruptedException {
        initConfiguration();

        Home home = topNav.goToHome();
        Assert.assertEquals(topNav.getTitle(), "XYZ Bank");

        home.goToCustomerLogin();
        topNav.goToHome();
        Assert.assertEquals(topNav.getTitle(), "XYZ Bank");

        BankManager bankManager = home.goToBankManagerLogin();
        AddCustomer addCustomer = bankManager.goToAddCustomer();
        CustomerModel newCustomer = addCustomer.fillCustomerForm(new CustomerBuilder()
                .withFirstName("Dang")
                .withLastName("Chau")
                .withPostCode("123")
                .build()
        );
        newCustomer.printCustomerInfo();

        quitBrowser();
    }
}
