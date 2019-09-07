package lucy_pom_factory_test.rough;

import lucy_pom_factory_test.pages.actions.AddCustomer;
import lucy_pom_factory_test.pages.actions.BankManager;
import lucy_pom_factory_test.pages.actions.Home;
import lucy_pom_factory_test.pages.actions.OpenAccount;
import lucy_pom_factory_test.pages.model.AccountBuilder;
import lucy_pom_factory_test.pages.model.AccountModel;
import lucy_pom_factory_test.pages.model.CustomerBuilder;
import lucy_pom_factory_test.pages.model.CustomerModel;

import static lucy_pom_factory_test.base.Page.initConfiguration;
import static lucy_pom_factory_test.base.Page.quitBrowser;

public class CreateAccountTest {

    public static void main(String[] args) throws InterruptedException {
        initConfiguration();

        //Go to bank manager
        Home home = new Home();
        BankManager bankManager = home.goToBankManagerLogin();

        //Go to add customer page and add a new customer
        AddCustomer addCustomer = bankManager.goToAddCustomer();
        CustomerModel newCustomer = addCustomer.createCustomer(new CustomerBuilder()
                .withFirstName("Dang")
                .withLastName("Chau")
                .withPostCode("123")
                .build());
        addCustomer.acceptNotification();

        //Go to open account page and add new account for the early created account
        OpenAccount openAccount = bankManager.goToOpenAccount();
        AccountModel newAccount = openAccount.submitNewAccountWith(new AccountBuilder()
                .withCustomer(newCustomer)
                .withCurrencyType("Dollar")
                .build());
        openAccount.acceptNotification();
        newAccount.printAccountInfo();

        Thread.sleep(3000);
        quitBrowser();
    }
}
