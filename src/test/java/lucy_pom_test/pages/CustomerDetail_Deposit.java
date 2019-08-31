package lucy_pom_test.pages;

import lucy_pom_test.base.Page;
import org.openqa.selenium.By;

import javax.mail.MessagingException;
import java.io.IOException;

public class CustomerDetail_Deposit extends Page {

    public void enterAmount(String amount) throws IOException, MessagingException {
        type("CustomerDetail.Deposit.tbAmount.css", amount);
    }

    public void clickDeposit(){
        click("CustomerDetail.Deposit.btnSubmit.css");
    }

    public void submitNewDeposit(String amount) throws Exception{
        enterAmount(amount);
        clickDeposit();
    }
}
