package CucumberTraining.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {
    @Given("^user navigate to bank app$")
    public void userNavigateToBankApp() {
        System.out.println("Given user navigate to bank app");
    }

    @And("^user navigate to home page$")
    public void userNavigateToHomePage() {
        System.out.println("And user navigate to home page");
    }

    @When("^user go to customer login$")
    public void userGoToCustomerLogin() {
        System.out.println("When user go to customer login");
    }

    @Then("^user should see username title display correctly$")
    public void userShouldSeeUsernameTitleDisplayCorrectly() {
        System.out.println("Then user should see username title display correctly");
    }

    @And("^user should see username dropdown display with default info$")
    public void userShouldSeeUsernameDropdownDisplayWithDefaultInfo() {
        System.out.println("And user should see username dropdown display with default info");
    }

    @When("^user select username$")
    public void userSelectUsername() {
        System.out.println("When user select username");
    }

    @And("^user click login$")
    public void userClickLogin() {
        System.out.println("And user click login");
    }

    @Then("^user should see correct welcome status on customer detail page$")
    public void userShouldSeeCorrectWelcomeStatusOnCustomerDetailPage() {
        System.out.println("Then user should see correct welcome status on customer detail page");
    }
}
