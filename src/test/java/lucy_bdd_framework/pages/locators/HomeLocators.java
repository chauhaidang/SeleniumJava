package lucy_bdd_framework.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLocators {
    @FindBy(css = ".btn.home")
    public WebElement btnHome;

    @FindBy(css = "button[ng-click='customer()']")
    public WebElement btnCustomerLogin;

    @FindBy(css = "button[ng-click='manager()']")
    public WebElement btnManagerLogin;

    @FindBy(css = ".mainHeading")
    public WebElement mainHeading;
}
