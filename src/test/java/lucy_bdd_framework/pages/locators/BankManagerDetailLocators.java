package lucy_bdd_framework.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BankManagerDetailLocators {
    @FindBy(css = ".btn.btn-lg.tab")
    public List<WebElement> tabMenu;
}
