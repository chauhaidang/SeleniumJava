package lucy_pom_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerDetail {

    WebDriver driver;

    public CustomerDetail(WebDriver _driver){
        driver = _driver;
    }

    public String getWelcomeStatus(){
        return driver.findElement(By.xpath("//strong[contains(normalize-space(),'Welcome')]")).getText();
    }

    public void selectAccountNumber(String accountNumber){
        WebElement selectElement = driver.findElement(By.cssSelector("#accountSelect"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(accountNumber);
    }

    public String getAccountNumberInfo(){
        return driver.findElement(By.xpath("//div[contains(text(),'Account Number')]/strong[1]")).getText();
    }

    public void clickTransactionsButton(){
        driver.findElement(By.cssSelector("button[ng-click='transactions()']")).click();
    }

    public void clickDepositButton(){
        driver.findElement(By.cssSelector("button[ng-click='deposit()']")).click();
    }

    public void clickWithdrawlButton(){
        driver.findElement(By.cssSelector("button[ng-click='withdrawl()']")).click();
    }
}
