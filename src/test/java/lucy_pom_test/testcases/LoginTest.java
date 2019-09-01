package lucy_pom_test.testcases;

import lucy_pom_test.pages.CustomerLogin;
import lucy_pom_test.pages.Home;
import lucy_pom_test.utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest extends HookAndPage {

    @Test(dataProviderClass = Utilities.class, dataProvider = "dp")
    public void login_customer(Hashtable<String, String> table) throws Exception {
        Home home = new Home();
        Assert.assertEquals(home.getTitle(), "XYZ Bank");

        CustomerLogin customerLogin = home.goToCustomerLogin();
        Assert.assertEquals(customerLogin.getUserNameTitle(), "Your Name :");
        Assert.assertEquals(customerLogin.getDefaultFromUserNameDropdown(), "---Your Name---");

        customerLogin.selectUserName(table.get("customer"));
        Assert.assertEquals(customerLogin.getDefaultFromUserNameDropdown(), table.get("customer"));
    }
}
