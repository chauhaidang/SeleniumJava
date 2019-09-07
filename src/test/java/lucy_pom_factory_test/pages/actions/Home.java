package lucy_pom_factory_test.pages.actions;

import lucy_pom_factory_test.base.ConfigConst;
import lucy_pom_factory_test.base.Page;
import lucy_pom_factory_test.pages.locators.HomeObjects;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Home Page
 * Home Page does stick to TopNavigation Page
 */
public class Home extends Page {

    private HomeObjects homeObjects;

    public Home(){
        homeObjects = new HomeObjects();
        //Help to synchronize element before perform action
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, ConfigConst.timeout);
        PageFactory.initElements(factory, homeObjects);
    }

    public void goToCustomerLogin(){
        homeObjects.btnCustomerLogin.click();
    }

    public BankManager goToBankManagerLogin() {
        homeObjects.btnBankManagerLogin.click();
        return new BankManager();
    }
}
