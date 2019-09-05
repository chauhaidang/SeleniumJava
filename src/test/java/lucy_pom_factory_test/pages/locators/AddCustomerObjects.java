package lucy_pom_factory_test.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomerObjects {

    @FindBy(css = "input[ng-model='fName']")
    public WebElement inputFirstName;

    @FindBy(css = "input[ng-model='lName']")
    public WebElement inputLastName;

    @FindBy(css = "input[ng-model='postCd']")
    public WebElement inputPostCode;

    @FindBy(css = "button[type=submit]")
    public WebElement btnAddCustomer;

}
