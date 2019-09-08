package lucy_pom_factory_test.testcases;

import lucy_pom_factory_test.collector.ErrorCollector;
import lucy_pom_factory_test.pages.actions.AddCustomer;
import lucy_pom_factory_test.pages.actions.BankManager;
import lucy_pom_factory_test.pages.actions.Home;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static lucy_pom_factory_test.base.Page.initConfiguration;
import static lucy_pom_factory_test.base.Page.quitBrowser;

public class BankManagerDisplayTest {

    @BeforeTest
    public void testSetUp() {
        initConfiguration();
    }

    @AfterTest
    public void testTearDown() {
        quitBrowser();
    }

    @Test
    public void TabDisplay01() throws InterruptedException, IOException {
        BankManager bankManager = new Home().goToBankManagerLogin();
        //Assert.assertEquals(bankManager.findTabCount(), 4);
        ErrorCollector.verifyEquals(bankManager.findTabCount(), 4);
        ErrorCollector.verifyEquals(bankManager.findTabCount(), 5);
        ErrorCollector.verifyEquals(bankManager.findTabCount(), 6);
        System.out.println(bankManager.count());
        AddCustomer addCustomer = bankManager.goToAddCustomer();
        Thread.sleep(2000);
    }
}
