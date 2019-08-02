package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenControl {
    public static void main(String[] args) throws InterruptedException {
        DriverFactory.setupDriver(DriverName.CHROME);
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("file:///C:/Users/chdang/Desktop/html%20file/index.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement hiddenButton = driver.findElement(By.cssSelector("#clickme"));

        String script = "arguments[0].click();";

        js.executeScript(script, hiddenButton);

        Thread.sleep(5000);

        driver.switchTo().alert().accept();

        driver.close();
    }
}
