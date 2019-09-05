package lucy_pom_factory_test.pages.model;

public class CustomerModel {

    private String firstName;
    private String lastName;
    private String postCode;
    private String accountNumber = null;

    public CustomerModel(String firstName, String lastName, String postCode, String accountNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
        this.accountNumber = accountNumber;
    }

    public CustomerModel(String firstName, String lastName, String postCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void printCustomerInfo(){
        System.out.println("FirstName is: " + firstName + "\n" + "LastName is: " + lastName + "\n"
                + "PostCode is: " + postCode + "\n" + "AccountNumber is: " +accountNumber);
    }
}

