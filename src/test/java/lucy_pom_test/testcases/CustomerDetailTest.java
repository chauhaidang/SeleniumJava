package lucy_pom_test.testcases;

import lucy_pom_test.base.Page;
import lucy_pom_test.pages.CustomerDetail;
import lucy_pom_test.pages.CustomerLogin;
import lucy_pom_test.utilities.Utilities;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Hashtable;

public class CustomerDetailTest extends Page {

    @Test(dataProviderClass = Utilities.class, dataProvider = "dp")
    public void detail_customer(Hashtable<String, String> table) throws IOException, MessagingException {
        //Go to customer detail
        CustomerLogin customerLogin = new CustomerLogin();
        CustomerDetail customerDetail = customerLogin.clickLogin();

        //Assert.assertTrue(customerDetail.getWelcomeStatus().contains(table.get("customer") + "DANG")); //Failed here and stop execution
        verifyEquals(customerDetail.getWelcomeStatus(), "HAHA"); //Will not stop but it make the run report NO failures -> not good

        customerDetail.selectAccountNumber(table.get("account_number"));
        //Assert.assertEquals(customerDetail.getAccountNumberInfo(), table.get("account_number"));
        verifyEquals(customerDetail.getAccountNumberInfo(), "HAHA");
    }

}
