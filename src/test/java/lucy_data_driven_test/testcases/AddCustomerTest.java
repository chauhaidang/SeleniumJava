package lucy_data_driven_test.testcases;

import lucy_data_driven_test.base.BaseTest;
import lucy_data_driven_test.utilities.TestUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;

public class AddCustomerTest extends BaseTest {

    @Test(dataProvider="getData")
    public void addCustomer(String firstname, String lastname, String postcode) throws IOException, MessagingException {
        click("addCustBtn_CSS");
        type("firstName_CSS", firstname);
        type("lastName_CSS", lastname);
        type("postCode_CSS", postcode);
        click("addCustomer_CSS");
        driver.switchTo().alert().accept();
    }

    @DataProvider()
    public static Object[][] getData() {
        return TestUtil.getData("AddCustomerTest");
    }
}
