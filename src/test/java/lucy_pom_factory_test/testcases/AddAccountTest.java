package lucy_pom_factory_test.testcases;

import lucy_pom_factory_test.pages.actions.AddCustomer;
import lucy_pom_factory_test.pages.actions.BankManager;
import lucy_pom_factory_test.pages.actions.Home;
import lucy_pom_factory_test.pages.actions.OpenAccount;
import lucy_pom_factory_test.pages.model.AccountBuilder;
import lucy_pom_factory_test.pages.model.AccountModel;
import lucy_pom_factory_test.pages.model.CustomerBuilder;
import lucy_pom_factory_test.pages.model.CustomerModel;
import lucy_pom_factory_test.utilities.Utilities;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static lucy_pom_factory_test.base.Page.*;

public class AddAccountTest {

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
    public void AddingAccount01(Hashtable<String, String> data) throws InterruptedException {
        //If run mode of data was N then dont execute
        if (data.get("runmode").equalsIgnoreCase("N")) {
            throw new SkipException("Skipping the test data as the run mode is N!");
        }
        initConfiguration();

        //Go to bank manager
        Home home = new Home();
        BankManager bankManager = home.goToBankManagerLogin();

        //Go to add customer page and add a new customer
        AddCustomer addCustomer = bankManager.goToAddCustomer();
        CustomerModel newCustomer = addCustomer.submitCustomer(new CustomerBuilder()
                .withFirstName(data.get("firstname"))
                .withLastName(data.get("lastname"))
                .withPostCode(data.get("postcode"))
                .build());

        //Go to open account page and add new account for the early created account
        OpenAccount openAccount = bankManager.goToOpenAccount();
        AccountModel newAccount = openAccount.submitNewAccountWith(new AccountBuilder()
                .withCustomer(newCustomer)
                .withCurrencyType(data.get("currency"))
                .build());
    }
}
