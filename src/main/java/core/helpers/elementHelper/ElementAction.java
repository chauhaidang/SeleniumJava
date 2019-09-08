package core.helpers.elementHelper;

import core.helpers.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementAction extends Log {

    public static void clickSupport(WebElement element) {
        try {
            element.click();
            info("Clicked on an Element : " + element);
        } catch (Throwable e) {
            error("Can not clicked on an Element: " + element + " due to " + e.getMessage());
            throw e;
        }
    }

    public static void typeSupport(WebElement element, String value) {
        try {
            element.sendKeys(value);
            info("Typed text '" + value + "' to element: " + element);
        } catch (Throwable e) {
            error("Can not type text on an element: " + element + " due to " + e.getMessage());
            throw e;
        }
    }

    public static void selectSupport(WebElement elementToSelect, String value) {
        try {
            Select select = new Select(elementToSelect);
            info("Selected to dropdown element: " + elementToSelect);
            select.selectByVisibleText(value);
            info("Selected option with text: " + value);
        } catch (Throwable e) {
            error("Can not select to dropdown due to: " + e.getMessage());
            throw e;
        }
    }

    public static boolean isElementAvailable(WebElement element, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            info("Found the Element : " + element);
            return true;
        } catch (Throwable t) {
            error("Error while finding an element : " + element + " exception message is : " + t.getMessage());
            return false;
        }
    }

    public static String getTextSupport(WebElement element) {
        String elementValue = null;
        try {
            elementValue = element.getText();
            info("Got text from element: " + element + " with value: " + elementValue);
        } catch (Throwable e) {
            error("Can not get text from element: " + element);
            throw e;
        } finally {
            return elementValue;
        }
    }

    public static Select getDropdownSelector(WebElement element) {
        try {
            Select select = new Select(element);
            info("Found the select dropdown of element: " + element);
            return select;
        } catch (Throwable e) {
            error("Can not find dropdown due to: " + e.getMessage());
            throw e;
        }
    }
}
