package lucy_pom_factory_test.testcases;

import lucy_pom_factory_test.collector.ErrorCollector;
import lucy_pom_factory_test.pages.actions.AddCustomer;
import lucy_pom_factory_test.pages.actions.BankManager;
import lucy_pom_factory_test.pages.actions.Home;
import lucy_pom_factory_test.utilities.Utilities;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

import static lucy_pom_factory_test.base.Page.*;

public class BankManagerDisplayTest {

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
    public void TabDisplay01(Hashtable<String, String> data) throws InterruptedException, IOException {
        //If run mode of data was N then dont execute
        if (data.get("runmode").equalsIgnoreCase("N")) {
            throw new SkipException("Skipping the test data as the run mode is N!");
        }
        initConfiguration();
        BankManager bankManager = new Home().goToBankManagerLogin();
        ErrorCollector.verifyEquals(Integer.toString(bankManager.findTabCount()), data.get("tabcount"));
        AddCustomer addCustomer = bankManager.goToAddCustomer();
    }
}
