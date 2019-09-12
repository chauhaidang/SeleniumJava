package lucy_bdd_framework.steps;

import core.helpers.driverhelper.DriverName;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static core.helpers.driverhelper.DriverManager.setupDriver;

public class Login {

    public static WebDriver driver;

    @Before
    public void beforeEachScenario() {
        setupDriver(DriverName.CHROME);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Cucumber hook can listen to test scenario result and invoke the method with that result to be injected
    @After
    public void afterEachScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshotByte = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotByte, "image/png");
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^user navigate to bank app \"([^\"]*)\"$")
    public void userNavigateToBankApp(String url) {
        System.out.println("Given user navigate to bank app url: " + url);
        driver.get(url);
        System.out.println("Navigated successfully to Url: " + url);
    }

    @And("^user navigate to home page$")
    public void userNavigateToHomePage() {
        System.out.println("And user navigate to home page");
        driver.findElement(By.cssSelector(".btn.home")).click();
        System.out.println("Clicked on button home page");
    }

    @When("^user go to ([^\"]*) login$")
    public void userGoToParamLogin(String arg0) {
        System.out.println("When user go to " + arg0 + " login");
        WebElement element = null;
        if (arg0.equalsIgnoreCase("customer")) {
            element = driver.findElement(By.cssSelector("button[ng-click='customer()']"));
        } else if (arg0.equalsIgnoreCase("manager")) {
            element = driver.findElement(By.cssSelector("button[ng-click='manager()']"));
        }
        if (element != null) {
            element.click();
        }
    }

    @Then("^user should see username title display as \"([^\"]*)\"$")
    public void userShouldSeeUsernameTitleDisplayAs(String titleText) {
        System.out.println("Then user should see username title display as " + titleText);
        Assert.assertEquals(
                driver.findElement(By.cssSelector(".form-group > label")).getText(), titleText);
    }

    @And("^user should see username dropdown display as \"([^\"]*)\"$")
    public void userShouldSeeUsernameDropdownDisplayAs(String userNameText) {
        System.out.println("And user should see username dropdown display as " + userNameText);
        Select select = new Select(driver.findElement(By.cssSelector("#userSelect")));
        Assert.assertEquals(
                select.getFirstSelectedOption().getText(), userNameText
        );
    }

    @When("^user select username ([^\"]*)$")
    public void userSelectUsername(String arg0) {
        System.out.println("When user select username " + arg0);
        Select select = new Select(driver.findElement(By.cssSelector("#userSelect")));
        select.selectByVisibleText(arg0);
    }

    @And("^user click login$")
    public void userClickLogin() {
        System.out.println("And user click login");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
    }

    @Then("^user should see correct welcome status as \"([^\"]*)\" on customer detail page$")
    public void userShouldSeeCorrectWelcomeStatusOnCustomerDetailPage(String status) {
        System.out.println("Then user should see correct welcome status as " + status + " on customer detail page");
        Assert.assertEquals(
                driver.findElement(By.xpath("//strong[contains(normalize-space(),'Welcome')]")).getText(), status
        );
    }

    @Then("^user should see ([^\"]*) tabs to manage customers$")
    public void userShouldSeeTabsToManageCustomers(int arg0) {
        System.out.println("Then user should see " + arg0 + " tabs to manage customer");
        Assert.assertEquals(driver.findElements(By.cssSelector(".btn.btn-lg.tab")).size(), arg0);
    }
}
