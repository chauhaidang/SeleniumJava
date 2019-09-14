package lucy_bdd_framework.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import lucy_bdd_framework.pages.actions.CustomerDetail;
import org.testng.Assert;

import java.util.List;

public class CustomerDetailSteps {

    CustomerDetail customerDetail = new CustomerDetail();

    @And("^user select account number as$")
    public void userSelectAccountNumberAs(List<String> arg0) {
        System.out.println("Selecting account number...");
        String accountNumber = arg0.get(1);
        customerDetail.selectAccountNumber(accountNumber);
    }

    @Then("^user should see account number info display as \"([^\"]*)\"$")
    public void userShouldSeeAccountNumberInfoDisplayAs(String arg0) {
        System.out.println("Verifying account number info....");
        Assert.assertEquals(customerDetail.getAccountNumberInfo(), arg0);
    }
}
