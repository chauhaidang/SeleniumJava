package lucy_bdd_framework.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {

    @Given("^user navigate to bank app \"([^\"]*)\"$")
    public void userNavigateToBankApp(String url) {
        System.out.println("Given user navigate to bank app url: " + url);
    }

    @And("^user navigate to home page$")
    public void userNavigateToHomePage() {
        System.out.println("And user navigate to home page");
    }

    @When("^user go to ([^\"]*) login$")
    public void userGoToParamLogin(String arg0) {
        System.out.println("When user go to " + arg0 + " login");
    }

    @Then("^user should see username title display as \"([^\"]*)\"$")
    public void userShouldSeeUsernameTitleDisplayAs(String titleText) {
        System.out.println("Then user should see username title display as " + titleText);
    }

    @And("^user should see username dropdown display as \"([^\"]*)\"$")
    public void userShouldSeeUsernameDropdownDisplayAs(String userNameText) {
        System.out.println("And user should see username dropdown display as " + userNameText);
    }

    @When("^user select username ([^\"]*)$")
    public void userSelectUsername(String arg0) {
        System.out.println("When user select username " + arg0);
    }

    @And("^user click login$")
    public void userClickLogin() {
        System.out.println("And user click login");
    }

    @Then("^user should see correct welcome status as \"([^\"]*)\" on customer detail page$")
    public void userShouldSeeCorrectWelcomeStatusOnCustomerDetailPage(String status) {
        System.out.println("Then user should see correct welcome status as " + status + " on customer detail page");
    }

    @Then("^user should see (\\d+) tabs to manage customers$")
    public void userShouldSeeTabsToManageCustomers(int arg0) {
        System.out.println("Then user should see " + arg0 + " tabs to manage customer");
    }
}
