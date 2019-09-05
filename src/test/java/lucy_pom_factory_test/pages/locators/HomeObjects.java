package lucy_pom_factory_test.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeObjects {

    @FindBy(css = ".btn.home")
    public WebElement btnHome;

    @FindBy(css = ".mainHeading")
    public WebElement lblHomeHeading;

    @FindBy(css = "button[ng-click='manager()']")
    public WebElement btnBankManagerLogin;

    @FindBy(css = "button[ng-click='customer()']")
    public WebElement btnCustomerLogin;
}
