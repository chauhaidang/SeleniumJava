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
        click(bankManagerObject.btnAddCustomer);
        return new AddCustomer();
    }

    public OpenAccount goToOpenAccount() {
        click(bankManagerObject.btnOpenAccount);
        return new OpenAccount();
    }

    public void goToCustomerInquiry(){
        click(bankManagerObject.btnCustomersInquiry);
    }

    public int findTabCount() {
        return bankManagerObject.tabNavigators.size();
    }

    public int count() {
        return bankManagerObject.tab2.size();
    }

    public String getFindBysTab() {
        return getText(bankManagerObject.tabNavigatorFirst);
    }
}
