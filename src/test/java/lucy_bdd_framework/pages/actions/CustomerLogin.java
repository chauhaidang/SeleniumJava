package lucy_bdd_framework.pages.actions;

import lucy_bdd_framework.pages.locators.CustomerLoginLocators;
import lucy_bdd_framework.utils.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;

import static core.helpers.elementHelper.ElementAction.*;

public class CustomerLogin {

    private CustomerLoginLocators customerLoginLocators = null;

    public CustomerLogin() {
        customerLoginLocators = new CustomerLoginLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), customerLoginLocators);
    }

    public String getUserNameTitle() {
        return getTextSupport(customerLoginLocators.customerTitle);
    }

    public void selectUserName(String userName) {
        selectSupport(customerLoginLocators.customerDropdown, userName);
    }

    public String getDefaultFromUserNameDropdown() {
        return getDropdownSelector(customerLoginLocators.customerDropdown)
                .getFirstSelectedOption().getText();
    }

    public CustomerDetail clickLogin() {
        clickSupport(customerLoginLocators.btnLogin);
        return new CustomerDetail();
    }
}
