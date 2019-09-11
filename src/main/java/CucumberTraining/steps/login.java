package CucumberTraining.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {

    @Before
    public void beforeEachScenario() {
        System.out.println("Launch browser!");
    }

    @After
    public void afterEachScenario() {
        System.out.println("Close browser!");
    }

    @Given("^user navigate to bank app$")
    public void userNavigateToBankApp() {
        System.out.println("Given user navigate to bank app");
    }

    @And("^user navigate to home page$")
    public void userNavigateToHomePage() {
        System.out.println("And user navigate to home page");
    }

    @When("^user go to ([^\"]*) login$")
    public void userGoToParamLogin(String arg0) {
        System.out.println("When user go to " + arg0 + " login");
    }

    @Then("^user should see username title display correctly$")
    public void userShouldSeeUsernameTitleDisplayCorrectly() {
        System.out.println("Then user should see username title display correctly");
    }

    @And("^user should see username dropdown display with default info$")
    public void userShouldSeeUsernameDropdownDisplayWithDefaultInfo() {
        System.out.println("And user should see username dropdown display with default info");
    }

    @When("^user select username ([^\"]*)$")
    public void userSelectUsername(String arg0) {
        System.out.println("When user select username " + arg0);
    }

    @And("^user click login$")
    public void userClickLogin() {
        System.out.println("And user click login");
    }

    @Then("^user should see correct welcome status on customer detail page$")
    public void userShouldSeeCorrectWelcomeStatusOnCustomerDetailPage() {
        System.out.println("Then user should see correct welcome status on customer detail page");
    }

    @Then("^user should see (\\d+) tabs to manage customers$")
    public void userShouldSeeTabsToManageCustomers(int arg0) {
        System.out.println("Then user should see " + arg0 + " tabs to manage customer");
    }
}
