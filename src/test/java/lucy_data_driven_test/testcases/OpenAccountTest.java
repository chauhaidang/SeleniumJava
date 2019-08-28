package lucy_data_driven_test.testcases;

import lucy_data_driven_test.base.BaseTest;
import lucy_data_driven_test.utilities.TestUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;

public class OpenAccountTest extends BaseTest {
    @Test(dataProvider="getData")
    public void openAccount(String customer, String currency) throws IOException, MessagingException {
        click("openAccount_CSS");
        select("customer_CSS", customer);
        select("currency_CSS", currency);
        click("process_CSS");
        driver.switchTo().alert().accept();
    }

    @DataProvider()
    public static Object[][] getData() {
        return TestUtil.getData("OpenAccountTest");
    }
}

