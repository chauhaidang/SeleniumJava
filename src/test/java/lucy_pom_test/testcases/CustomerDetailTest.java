package lucy_pom_test.testcases;

import lucy_pom_test.pages.CustomerDetail;
import lucy_pom_test.pages.CustomerLogin;
import lucy_pom_test.utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Hashtable;

public class CustomerDetailTest {

    @Test(dataProviderClass = Utilities.class, dataProvider = "dp")
    public void detail_customer(Hashtable<String, String> table) throws IOException, MessagingException {
        //Go to customer detail
        CustomerLogin customerLogin = new CustomerLogin();
        CustomerDetail customerDetail = customerLogin.clickLogin();
        Assert.assertTrue(customerDetail.getWelcomeStatus().contains(table.get("customer")));
        customerDetail.selectAccountNumber(table.get("account_number"));
        Assert.assertEquals(customerDetail.getAccountNumberInfo(), table.get("account_number"));
    }

}
