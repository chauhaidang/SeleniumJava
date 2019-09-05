package lucy_pom_factory_test.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankManagerObject {

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement btnAddCustomer;

    @FindBy(css = "button[ng-click='openAccount()']")
    public WebElement btnOpenAccount;

    @FindBy(css = "button[ng-click='showCust()']")
    public WebElement btnCustomersInquiry;

}
