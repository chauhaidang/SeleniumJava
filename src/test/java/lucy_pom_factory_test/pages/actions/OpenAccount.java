package lucy_pom_factory_test.pages.actions;

import core.helpers.driverhelper.DriverManager;
import lucy_pom_factory_test.base.ConfigConst;
import lucy_pom_factory_test.base.Page;
import lucy_pom_factory_test.pages.locators.OpenAccountObjects;
import lucy_pom_factory_test.pages.model.AccountModel;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OpenAccount extends Page {

    private OpenAccountObjects openAccountObjects;

    public OpenAccount() {
        openAccountObjects = new OpenAccountObjects();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, ConfigConst.timeout);
        PageFactory.initElements(factory, openAccountObjects);
    }

    public void selectCustomerName(String customerName) {
        select(openAccountObjects.accountDropdown, customerName);
    }

    public void selectCurrency(String currencyType) {
        select(openAccountObjects.currencyDropdown, currencyType);
    }

    public void clickProcess() {
        DriverManager.ignoreAlert(driver);
        click(openAccountObjects.btnProcess);
    }

    public AccountModel submitNewAccountWith(AccountModel accountModel) {
        selectCustomerName(accountModel.getCustomerName());
        selectCurrency(accountModel.getCurrencyType());
        clickProcess();
        return accountModel;
    }
}
