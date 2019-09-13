package lucy_bdd_framework.pages.actions;

import lucy_bdd_framework.pages.locators.CustomerDetailLocators;
import lucy_bdd_framework.utils.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;

import static core.helpers.elementHelper.ElementAction.getTextSupport;
import static core.helpers.elementHelper.ElementAction.selectSupport;

public class CustomerDetail {

    private CustomerDetailLocators customerDetailLocators = null;

    public CustomerDetail() {
        customerDetailLocators = new CustomerDetailLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), customerDetailLocators);
    }

    public String getWelcomeStatus() {
        return getTextSupport(customerDetailLocators.statusWelcome);
    }

    public void selectAccountNumber(String accountNumber) {
        selectSupport(customerDetailLocators.dropdownAccount, accountNumber);
    }

    public String getAccountNumberInfo() {
        return getTextSupport(customerDetailLocators.infoAccountNumber);
    }
}
