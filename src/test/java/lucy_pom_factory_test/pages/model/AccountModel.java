package lucy_pom_factory_test.pages.model;

public class AccountModel {
    private CustomerModel customer;
    private String currencyType;
    private String customerName;

    public AccountModel(CustomerModel customer, String currencyType) {
        this.customer = customer;
        this.currencyType = currencyType;
        this.customerName = this.customer.getFirstName() + " " + this.customer.getLastName();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public void printAccountInfo() {
        System.out.println("Account have info: \nCustomer name: " + customerName + "\nCurrency type: " + currencyType);
    }
}
