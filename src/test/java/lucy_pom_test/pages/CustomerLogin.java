package lucy_pom_test.pages;

import lucy_pom_test.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.mail.MessagingException;
import java.io.IOException;

public class CustomerLogin extends Page {

    private Select userNameDropdown = getDropdownSelector("CustomerLogin.userNameDropdown.css");

    public String getUserNameTitle() {
        return getText("CustomerLogin.title.css");
    }

    public void selectUserName(String userName) throws Exception {
        select("CustomerLogin.userNameDropdown.css", userName);
    }

    public String getDefaultFromUserNameDropdown() {
        return userNameDropdown.getFirstSelectedOption().getText();
    }

    public CustomerDetail clickLogin() {
        click("CustomerLogin.btnLogin.css");
        return new CustomerDetail();
    }
}
