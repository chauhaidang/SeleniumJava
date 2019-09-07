package lucy_pom_factory_test.pages.actions;

import lucy_pom_factory_test.base.ConfigConst;
import lucy_pom_factory_test.base.Page;
import lucy_pom_factory_test.pages.locators.OpenAccountObjects;
import lucy_pom_factory_test.pages.model.AccountModel;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccount extends Page {

    private OpenAccountObjects openAccountObjects;

    public OpenAccount() {
        openAccountObjects = new OpenAccountObjects();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, ConfigConst.timeout);
        PageFactory.initElements(factory, openAccountObjects);
    }

    public void selectCustomerName(String customerName) {
        Select select = new Select(openAccountObjects.accountDropdown);
        select.selectByVisibleText(customerName);
    }

    public void selectCurrency(String currencyType) {
        Select select = new Select(openAccountObjects.currencyDropdown);
        select.selectByVisibleText(currencyType);
    }

    public void clickProcess() {
        openAccountObjects.btnProcess.click();
    }

    public void acceptNotification() {
        driver.switchTo().alert().accept();
    }

    public AccountModel submitNewAccountWith(AccountModel accountModel) {
        selectCustomerName(accountModel.getCustomerName());
        selectCurrency(accountModel.getCurrencyType());
        clickProcess();
        return accountModel;
    }
}
