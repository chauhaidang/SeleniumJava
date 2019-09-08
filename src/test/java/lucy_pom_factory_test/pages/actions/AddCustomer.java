package lucy_pom_factory_test.pages.actions;

import lucy_pom_factory_test.base.ConfigConst;
import lucy_pom_factory_test.base.Page;
import lucy_pom_factory_test.pages.locators.AddCustomerObjects;
import lucy_pom_factory_test.pages.model.CustomerModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddCustomer extends Page {

    private AddCustomerObjects addCustomerObjects;

    public AddCustomer() {
        addCustomerObjects = new AddCustomerObjects();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, ConfigConst.timeout);
        PageFactory.initElements(factory, addCustomerObjects);
    }

    public CustomerModel fillCustomerForm(CustomerModel customerModel) {
        type(addCustomerObjects.inputFirstName, customerModel.getFirstName());
        type(addCustomerObjects.inputLastName, customerModel.getLastName());
        type(addCustomerObjects.inputPostCode, customerModel.getPostCode());
        return customerModel;
    }

    public void clickAddCustomer() {
        click(addCustomerObjects.btnAddCustomer);
    }

    public CustomerModel submitCustomer(CustomerModel customerModel) {
        CustomerModel newCustomer = fillCustomerForm(customerModel);
        clickAddCustomer();
        return newCustomer;
    }

    public void acceptNotification() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
