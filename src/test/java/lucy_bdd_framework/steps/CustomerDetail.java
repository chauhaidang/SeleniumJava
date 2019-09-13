package lucy_bdd_framework.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

public class CustomerDetail {

    @And("^user select account number as$")
    public void userSelectAccountNumberAs(List<String> arg0) {

    }

    @Then("^user should see account number info display as \"([^\"]*)\"$")
    public void userShouldSeeAccountNumberInfoDisplayAs(String arg0) {
    }
}
