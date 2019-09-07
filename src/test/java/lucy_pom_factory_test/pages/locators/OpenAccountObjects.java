package lucy_pom_factory_test.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountObjects {
    @FindBy(name = "userSelect")
    public WebElement accountDropdown;

    @FindBy(name = "currency")
    public WebElement currencyDropdown;

    @FindBy(css = "button[type=submit]")
    public WebElement btnProcess;
}
