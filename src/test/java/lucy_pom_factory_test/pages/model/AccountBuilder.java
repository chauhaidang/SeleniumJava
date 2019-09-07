package lucy_pom_factory_test.pages.model;

public class AccountBuilder {
    private CustomerModel customer;
    private String currencyType;

    public AccountBuilder withCustomer(CustomerModel customer) {
        this.customer = customer;
        return this;
    }

    public AccountBuilder withCurrencyType(String currencyType) {
        this.currencyType = currencyType;
        return this;
    }

    public AccountModel build() {
        return new AccountModel(customer, currencyType);
    }
}
