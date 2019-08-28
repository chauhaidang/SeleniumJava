package lucy_data_driven_test.testcases;

import lucy_data_driven_test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends BaseTest {

    @Test
    public void loginAsBankManager(){
        click("bmlBtn_CSS");
        Assert.assertTrue(isElementPresent("addCustBtn_CSS"));
    }
}
