package core.helpers.elementHelper;

import core.helpers.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementAction extends Log {

    public static void clickSupport(WebElement element) {
        try {
            info("Clicking on an Element : " + element + ".....");
            element.click();
        } catch (Throwable e) {
            error("Can not clicked on an Element: " + element + " due to " + e.getMessage());
            throw e;
        }
    }

    public static void typeSupport(WebElement element, String value) {
        try {
            info("Typing text '" + value + "' to element" + element + ".....");
            element.sendKeys(value);
        } catch (Throwable e) {
            error("Can not type text on an element: " + element + " due to " + e.getMessage());
            throw e;
        }
    }

    public static void selectSupport(WebElement elementToSelect, String value) {
        try {
            info("Selecting to dropdown element: " + elementToSelect + ".....");
            Select select = new Select(elementToSelect);
            info("Selecting option with text: " + value + ".....");
            select.selectByVisibleText(value);
        } catch (Throwable e) {
            error("Can not select to dropdown due to: " + e.getMessage());
            throw e;
        }
    }

    public static boolean isElementAvailable(WebElement element, WebDriverWait wait) {
        try {
            info("Finding the Element : " + element + ".....");
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Throwable t) {
            error("Error while finding an element : " + element + " exception message is : " + t.getMessage());
            return false;
        }
    }

    public static String getTextSupport(WebElement element) {
        String elementValue = null;
        try {
            info("Getting text from element: " + element + ".....");
            elementValue = element.getText();
        } catch (Throwable e) {
            error("Can not get text from element: " + element);
            throw e;
        } finally {
            return elementValue;
        }
    }

    public static Select getDropdownSelector(WebElement element) {
        try {
            info("Finding the select dropdown of element: " + element + ".....");
            Select select = new Select(element);
            return select;
        } catch (Throwable e) {
            error("Can not find dropdown due to: " + e.getMessage());
            throw e;
        }
    }
}
