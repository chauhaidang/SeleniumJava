package lucy_pom_factory_test.testcases;

import lucy_pom_factory_test.pages.actions.AddCustomer;
import lucy_pom_factory_test.pages.actions.BankManager;
import lucy_pom_factory_test.pages.actions.Home;
import lucy_pom_factory_test.pages.model.CustomerBuilder;
import lucy_pom_factory_test.pages.model.CustomerModel;
import lucy_pom_factory_test.utilities.Utilities;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static lucy_pom_factory_test.base.Page.*;

public class AddCustomerTest {

    @BeforeTest
    public void testSetUp() {
//        initConfiguration(); //Remove due to init driver config base on run mode Y
    }

    @AfterTest
    public void testTearDown() {
        if (driver != null) {
            quitBrowser();
        }
    }

    @Test(dataProviderClass = Utilities.class, dataProvider = "dp")
    public void AddingCustomer01(Hashtable<String, String> data) throws InterruptedException {
        //If run mode of data was N then dont execute
        if (data.get("runmode").equalsIgnoreCase("N")) {
            throw new SkipException("Skipping the test data as the run mode is N!");
        }
        initConfiguration();

        Home home = topNav.goToHome();
        Assert.assertEquals(topNav.getTitle(), data.get("title"));

        home.goToCustomerLogin();
        topNav.goToHome();
        Assert.assertEquals(topNav.getTitle(), data.get("title"));

        BankManager bankManager = home.goToBankManagerLogin();
        AddCustomer addCustomer = bankManager.goToAddCustomer();
        CustomerModel newCustomer = addCustomer.fillCustomerForm(new CustomerBuilder()
                .withFirstName(data.get("firstname"))
                .withLastName(data.get("lastname"))
                .withPostCode(data.get("postcode"))
                .build()
        );
        addCustomer.clickAddCustomer();
    }
}
