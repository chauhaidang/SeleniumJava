package lucy_pom_test.pages;

import lucy_pom_test.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerLogin extends Page {

    public String getUserNameTitle(){
        return driver.findElement(By.cssSelector(".form-group > label")).getText();
    }

    public void selectUserName(String userName){
        WebElement selectElement = driver.findElement(By.cssSelector("#userSelect"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(userName);
    }

    public String getDefaultFromUserNameDropdown(){
        WebElement selectElement = driver.findElement(By.cssSelector("#userSelect"));
        Select select = new Select(selectElement);
        return select.getFirstSelectedOption().getText();
    }

    public void clickLogin(){
        driver.findElement(By.cssSelector("button[type=submit]")).click();
    }
}
