package lucy_pom_factory_test.pages.actions;

import lucy_pom_factory_test.base.ConfigConst;
import lucy_pom_factory_test.base.Page;
import lucy_pom_factory_test.pages.locators.TopNavigationObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TopNavigation {

    private TopNavigationObjects topNavigationObjects;

    public TopNavigation(WebDriver driver) {
        topNavigationObjects = new TopNavigationObjects();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, ConfigConst.timeout);
        PageFactory.initElements(factory, topNavigationObjects);
    }

    public Home goToHome() {
        Page.click(topNavigationObjects.btnHome);
        return new Home();
    }

    public String getTitle() {
        return Page.getText(topNavigationObjects.lblHomeHeading);
    }
}
