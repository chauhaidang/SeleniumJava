package lucy_bdd_framework.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lucy_bdd_framework.pages.actions.BankManagerDetail;
import lucy_bdd_framework.pages.actions.CustomerDetail;
import lucy_bdd_framework.pages.actions.CustomerLogin;
import lucy_bdd_framework.pages.actions.Home;
import lucy_bdd_framework.utils.SeleniumDriver;
import org.testng.Assert;

public class LoginSteps {

    Home home = new Home();
    CustomerLogin customerLogin = new CustomerLogin();
    CustomerDetail customerDetail = new CustomerDetail();
    BankManagerDetail bankManagerDetail = new BankManagerDetail();

    @Given("^user navigate to bank app \"([^\"]*)\"$")
    public void userNavigateToBankApp(String url) {
        System.out.println("Given user navigate to bank app url: " + url);
        SeleniumDriver.openPage(url);
        System.out.println("Navigated successfully to Url: " + url);
    }

    @And("^user navigate to home page$")
    public void userNavigateToHomePage() {
        System.out.println("And user navigate to home page");
        home.goToHome();
        System.out.println("Clicked on button home page");
    }

    @When("^user go to ([^\"]*) login$")
    public void userGoToParamLogin(String arg0) {
        System.out.println("When user go to " + arg0 + " login");
        if (arg0.equalsIgnoreCase("customer")) {
            home.goToCustomerLogin();
        } else if (arg0.equalsIgnoreCase("manager")) {
            home.goToBankManagerLogin();
        }
    }

    @Then("^user should see username title display as \"([^\"]*)\"$")
    public void userShouldSeeUsernameTitleDisplayAs(String titleText) {
        System.out.println("Then user should see username title display as " + titleText);
        Assert.assertEquals(customerLogin.getUserNameTitle(), titleText);
    }

    @And("^user should see username dropdown display as \"([^\"]*)\"$")
    public void userShouldSeeUsernameDropdownDisplayAs(String userNameText) {
        System.out.println("And user should see username dropdown display as " + userNameText);
        Assert.assertEquals(customerLogin.getDefaultFromUserNameDropdown(), userNameText);
    }

    @When("^user select username ([^\"]*)$")
    public void userSelectUsername(String arg0) {
        System.out.println("When user select username " + arg0);
        customerLogin.selectUserName(arg0);
    }

    @And("^user click login$")
    public void userClickLogin() {
        System.out.println("And user click login");
        customerLogin.clickLogin();
    }

    @Then("^user should see correct welcome status as \"([^\"]*)\" on customer detail page$")
    public void userShouldSeeCorrectWelcomeStatusOnCustomerDetailPage(String status) {
        System.out.println("Then user should see correct welcome status as " + status + " on customer detail page");
        Assert.assertEquals(customerDetail.getWelcomeStatus(), status);
    }

    @Then("^user should see ([^\"]*) tabs to manage customers$")
    public void userShouldSeeTabsToManageCustomers(int arg0) {
        System.out.println("Then user should see " + arg0 + " tabs to manage customer");
        Assert.assertEquals(bankManagerDetail.findTabCount(), arg0);
    }
}
