package lucy_bdd_framework.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerDetailLocators {
    @FindBy(xpath = "//strong[contains(normalize-space(),'Welcome')]")
    public WebElement statusWelcome;

    @FindBy(css = "#accountSelect")
    public WebElement dropdownAccount;

    @FindBy(xpath = "//div[contains(text(),'Account Number')]/strong[1]")
    public WebElement infoAccountNumber;
}
