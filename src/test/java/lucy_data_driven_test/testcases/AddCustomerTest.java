package lucy_data_driven_test.testcases;

import lucy_data_driven_test.base.BaseTest;
import lucy_data_driven_test.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;

public class AddCustomerTest extends BaseTest {

    @Test(dataProvider="getData")
    public void addCustomer(String firstname, String lastname, String postcode, String alertText) throws IOException, MessagingException {
        click("addCustBtn_CSS");
        type("firstName_CSS", firstname);
        type("lastName_CSS", lastname);
        type("postCode_CSS", postcode);
        click("addCustomer_CSS");

        //Wait and return driver.switchTo().alert();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertText));

        alert.accept();
    }

    @DataProvider()
    public static Object[][] getData() {
        return TestUtil.getData("AddCustomerTest");
    }
}
