package lucy_pom_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

   WebDriver driver;

   public HomePage(WebDriver _driver){
       driver = _driver;
   }

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
