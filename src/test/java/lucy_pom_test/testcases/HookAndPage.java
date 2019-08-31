package lucy_pom_test.testcases;

import lucy_pom_test.base.Page;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class HookAndPage {

    @AfterSuite
    public void tearDown(){
        Page.quit();
    }
}
