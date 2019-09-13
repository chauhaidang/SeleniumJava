package lucy_bdd_framework.pages.actions;

import lucy_bdd_framework.pages.locators.BankManagerDetailLocators;
import lucy_bdd_framework.utils.SeleniumDriver;
import org.openqa.selenium.support.PageFactory;

public class BankManagerDetail {
    private BankManagerDetailLocators bankManagerDetailLocators = null;

    public BankManagerDetail() {
        bankManagerDetailLocators = new BankManagerDetailLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), bankManagerDetailLocators);
    }

    public int findTabCount() {
        return bankManagerDetailLocators.tabMenu.size();
    }
}
