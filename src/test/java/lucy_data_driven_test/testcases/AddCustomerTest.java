package lucy_data_driven_test.testcases;

import lucy_data_driven_test.base.BaseTest;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;

public class AddCustomerTest extends BaseTest {
    @Test
    public void addCustomer() throws IOException, MessagingException {
        click("addCustBtn_CSS");
        type("firstName_CSS", "dang");
        type("lastName_CSS", "chau");
        type("postCode_CSS", String.valueOf(Math.random()));
        click("addCustomer_CSS");
    }
}
