package lucy_pom_test.testcases;

import lucy_pom_test.pages.Home;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends HookAndPage {

    @Test
    public void loginTest(){
        Home home = new Home();
        Assert.assertEquals(home.getTitle(), "XYZ Bank");
    }
}
