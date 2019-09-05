package lucy_pom_factory_test.pages.model;

public class CustomerBuilder {
    private String firstName;
    private String lastName;
    private String postCode;
    private String accountNumber = null;

    public CustomerBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder withPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public CustomerBuilder withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public CustomerModel build() {
        return (accountNumber != null) ? new CustomerModel(firstName, lastName, postCode, accountNumber) : new CustomerModel(firstName, lastName, postCode);
    }
}
