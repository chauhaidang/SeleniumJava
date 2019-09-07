package lucy_pom_factory_test.pages.actions;

import lucy_pom_factory_test.base.ConfigConst;
import lucy_pom_factory_test.base.Page;
import lucy_pom_factory_test.pages.locators.AddCustomerObjects;
import lucy_pom_factory_test.pages.model.CustomerModel;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AddCustomer extends Page {

    private AddCustomerObjects addCustomerObjects;

    public AddCustomer(){
        addCustomerObjects = new AddCustomerObjects();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, ConfigConst.timeout);
        PageFactory.initElements(factory, addCustomerObjects);
    }

    public CustomerModel fillCustomerForm(CustomerModel customerModel){
        try{
            addCustomerObjects.inputFirstName
                    .sendKeys(customerModel.getFirstName());
            log.info("Entered firstName to text box");

            addCustomerObjects.inputLastName
                    .sendKeys(customerModel.getLastName());
            log.info("Entered last name to text box");

            addCustomerObjects.inputPostCode
                    .sendKeys(customerModel.getPostCode());
            log.info("Entered post code to text box");
        }
        catch (Exception e){
            log.error("Could not create Customer due to: "+ e.getMessage());
            throw new Error("Could not create Customer due to: "+ e.getMessage());
        }
        finally {
            return customerModel;
        }
    }

    public void submitCustomer(){
        try{
            addCustomerObjects.btnAddCustomer.click();
            log.info("Clicked to add customer button!");
        }
        catch (Exception e) {
            throw new Error("Could not click to button submit due to: "+ e.getMessage());
        }
    }

    public CustomerModel createCustomer(CustomerModel customerModel){
        CustomerModel newCustomer = fillCustomerForm(customerModel);
        submitCustomer();
        return newCustomer;
    }

    public void acceptNotification() {
        driver.switchTo().alert().accept();
    }
}
