package lucy_pom_factory_test.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationObjects {

    @FindBy(css = ".btn.home")
    public WebElement btnHome;

    @FindBy(css = ".mainHeading")
    public WebElement lblHomeHeading;
}
