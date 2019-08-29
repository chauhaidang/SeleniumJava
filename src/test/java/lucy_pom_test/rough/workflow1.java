package lucy_pom_test.rough;

import lucy_pom_test.base.Page;
import lucy_pom_test.pages.*;
import org.testng.Assert;

public class workflow1 {

    public void main(String[] args) throws Exception {

        HomePage homePage = new HomePage();
        homePage.goToHome();
        Assert.assertEquals(homePage.getTitle(),"XYZ Bank");

        //Goto customer login
        CustomerLogin customerLogin = homePage.goToCustomerLogin();
        Assert.assertEquals(customerLogin.getUserNameTitle(), "Your Name :");
        Assert.assertEquals(customerLogin.getDefaultFromUserNameDropdown(), "---Your Name---");
        customerLogin.selectUserName("Harry Potter");

        //Go to customer detail
        CustomerDetail customerDetail = customerLogin.clickLogin();
        Assert.assertTrue(customerDetail.getWelcomeStatus().contains("Harry Potter"));
        customerDetail.selectAccountNumber("1004");
        Assert.assertEquals(customerDetail.getAccountNumberInfo(), "1004");

        //Go to customer deposit page
        CustomerDetail_Deposit customerDetail_deposit = customerDetail.clickDepositButton();
        customerDetail_deposit.submitNewDeposit("1000");
        Thread.sleep(2000);
        customerDetail_deposit.submitNewDeposit("2000");
        Thread.sleep(2000);

        //Go to customer detail transaction page
        CustomerDetail_Transactions customerDetail_transactions =  customerDetail.clickTransactionsButton();
        Assert.assertEquals(customerDetail_transactions.getFirstAmount(), "1000");
        customerDetail_transactions.clickBack();

        Thread.sleep(2000);

        Page.driver.close();
    }
}
