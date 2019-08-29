package lucy_pom_test.pages;

import lucy_pom_test.base.Page;
import org.openqa.selenium.By;

public class CustomerDetail_Deposit extends Page {

    public void enterAmount(String amount){
        driver.findElement(By.cssSelector("input[ng-model=amount]")).sendKeys(amount);
    }

    public void clickDeposit(){
        driver.findElement(By.cssSelector("button[type=submit]")).click();
    }

    public void submitNewDeposit(String amount){
        enterAmount(amount);
        clickDeposit();
    }
}
