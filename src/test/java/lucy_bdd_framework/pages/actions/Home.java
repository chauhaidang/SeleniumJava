package lucy_bdd_framework.pages.actions;

import lucy_bdd_framework.pages.locators.HomeLocators;
import lucy_bdd_framework.utils.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;

import static core.helpers.elementHelper.ElementAction.clickSupport;
import static core.helpers.elementHelper.ElementAction.getTextSupport;

public class Home {
    private HomeLocators homeLocators = null;

    public Home() {
        homeLocators = new HomeLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), homeLocators);
    }

    public void goToHome() {
        clickSupport(homeLocators.btnHome);
    }

    public String getTitle() {
        return getTextSupport(homeLocators.mainHeading);
    }

    public CustomerLogin goToCustomerLogin() {
        clickSupport(homeLocators.btnCustomerLogin);
        return new CustomerLogin();
    }

    public BankManagerDetail goToBankManagerLogin() {
        clickSupport(homeLocators.btnManagerLogin);
        return new BankManagerDetail();
    }
}
