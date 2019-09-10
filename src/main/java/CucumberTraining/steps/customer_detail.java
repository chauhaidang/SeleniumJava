package CucumberTraining.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;
import java.util.Map;

public class customer_detail {
    @And("^user select account number$")
    public void userSelectAccountNumber(List<String> lstAccountNumber) {
        System.out.println("Select account number: " + lstAccountNumber.get(1));//get 1 because the 0 index is a header
    }

    @Then("^user should see account number info display$")
    public void userShouldSeeAccountNumberInfoDisplay(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        System.out.println("User should see account number info display with label '"
                + data.get(0).get("label") + "' and info is: "
                + data.get(0).get("accountNumberInfo"));
    }
}
