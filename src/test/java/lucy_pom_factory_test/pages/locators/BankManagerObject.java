package lucy_pom_factory_test.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class BankManagerObject {

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement btnAddCustomer;

    @FindBy(css = "button[ng-click='openAccount()']")
    public WebElement btnOpenAccount;

    @FindBy(css = "button[ng-click='showCust()']")
    public WebElement btnCustomersInquiry;

    @FindBy(css = ".btn.btn-lg.tab")
    public List<WebElement> tabNavigators;


    /**
     * Chaining locators to find complex element
     */
    @FindBys({
            @FindBy(tagName = "button"),
            @FindBy(className = "btn btn-lg tab btn-primary")
    })
    public WebElement tabNavigatorFirst;

    /**
     * Find all element according to following locators. If you define multiple locator then it will find multiple element
     * If no element found then it will throw noSuchElementException
     */
    @FindAll({
            @FindBy(css = ".btn"), @FindBy(css = ".btn.btn-lg")
    })
    public List<WebElement> tab2;
}
