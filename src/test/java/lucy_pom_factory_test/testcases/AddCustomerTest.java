package lucy_pom_factory_test.testcases;

import lucy_pom_factory_test.pages.actions.AddCustomer;
import lucy_pom_factory_test.pages.actions.BankManager;
import lucy_pom_factory_test.pages.actions.Home;
import lucy_pom_factory_test.pages.model.CustomerBuilder;
import lucy_pom_factory_test.pages.model.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static lucy_pom_factory_test.base.Page.*;

public class AddCustomerTest {


    @BeforeTest
    public void testSetUp() {
        initConfiguration();
    }

    @AfterTest
    public void testTearDown() {
        quitBrowser();
    }

    @Test
    public void AddingCustomer01() {
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
    }
}
