package lucy_bdd_framework.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginLocators {

    @FindBy(css = ".form-group > label")
    public WebElement customerTitle;

    @FindBy(css = "#userSelect")
    public WebElement customerDropdown;

    @FindBy(css = "button[type=submit]")
    public WebElement btnLogin;
}
