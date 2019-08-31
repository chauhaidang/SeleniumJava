package lucy_pom_test.pages;

import lucy_pom_test.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends Page {

   public void goToHome(){
       click("Home.btnHome.css");
   }

   public String getTitle(){
        return getText("Home.pageHeading.css");
   }

   public CustomerLogin goToCustomerLogin(){
       click("Home.btnCustomerLogin.css");
       return new CustomerLogin();
   }

   public BankManagerDetail goToBankManagerLogin(){
       click("Home.btnBankManagerLogin.css");
       return new BankManagerDetail();
   }
}
