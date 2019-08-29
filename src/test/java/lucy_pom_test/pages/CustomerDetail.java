package lucy_pom_test.pages;

import lucy_pom_test.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerDetail extends Page {

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

    public CustomerDetail_Transactions clickTransactionsButton(){
        driver.findElement(By.cssSelector("button[ng-click='transactions()']")).click();
        return new CustomerDetail_Transactions();
    }

    public CustomerDetail_Deposit clickDepositButton(){
        driver.findElement(By.cssSelector("button[ng-click='deposit()']")).click();
        return new CustomerDetail_Deposit();
    }

    public void clickWithdrawlButton(){
        driver.findElement(By.cssSelector("button[ng-click='withdrawl()']")).click();
    }
}
