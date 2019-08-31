package lucy_pom_test.pages;

import lucy_pom_test.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.mail.MessagingException;
import java.io.IOException;

public class CustomerDetail extends Page {

    public String getWelcomeStatus(){
        return getText("CustomerDetail.welcomeStatus.xpath");
    }

    public void selectAccountNumber(String accountNumber) throws IOException, MessagingException {
        select("CustomerDetail.accountDropdown.css", accountNumber);
    }

    public String getAccountNumberInfo(){
       return getText("CustomerDetail.accountNumberInfo.xpath");
    }

    public CustomerDetail_Transactions clickTransactionsButton(){
        click("CustomerDetail.btnTransaction.css");
        return new CustomerDetail_Transactions();
    }

    public CustomerDetail_Deposit clickDepositButton(){
        click("CustomerDetail.btnDeposit.css");
        return new CustomerDetail_Deposit();
    }

    public void clickWithdrawlButton(){
        click("CustomerDetail.btnWithdrawl.css");
    }
}
