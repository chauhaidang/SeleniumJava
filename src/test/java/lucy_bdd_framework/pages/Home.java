package lucy_bdd_framework.pages;

public class Home {

    public void goToHome() {

    }

    public String getTitle() {
        return "";
    }

    public CustomerLogin goToCustomerLogin() {

        return new CustomerLogin();
    }

    public BankManagerDetail goToBankManagerLogin() {

        return new BankManagerDetail();
    }
}
