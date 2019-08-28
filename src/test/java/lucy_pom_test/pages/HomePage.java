package lucy_pom_test.pages;

import lucy_pom_test.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

   public void goToHome(){
       driver.findElement(By.cssSelector(".btn.home")).click();
   }

   public String getTitle(){
        return driver.findElement(By.cssSelector(".mainHeading")).getText();
   }

   public void goToCustomerLogin(){
        driver.findElement(By.cssSelector("button[ng-click='customer()']")).click();
   }

   public void goToBankManagerLogin(){
       driver.findElement(By.cssSelector("button[ng-click='manager()']")).click();
   }
}
