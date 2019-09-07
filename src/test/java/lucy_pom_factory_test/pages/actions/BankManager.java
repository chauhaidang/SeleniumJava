package lucy_pom_factory_test.pages.actions;

import lucy_pom_factory_test.base.ConfigConst;
import lucy_pom_factory_test.base.Page;
import lucy_pom_factory_test.pages.locators.BankManagerObject;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BankManager extends Page {

    private BankManagerObject bankManagerObject;

    public BankManager(){
        bankManagerObject = new BankManagerObject();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, ConfigConst.timeout);
        PageFactory.initElements(factory, bankManagerObject);
    }

    public AddCustomer goToAddCustomer() {
        bankManagerObject.btnAddCustomer.click();
        return new AddCustomer();
    }

    public void goToOpenAccount(){
        bankManagerObject.btnOpenAccount.click();
    }

    public void goToCustomerInquiry(){
        bankManagerObject.btnCustomersInquiry.click();
    }
}
