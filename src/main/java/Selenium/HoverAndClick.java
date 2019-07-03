package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverAndClick {
  public static void main(String[] args) throws InterruptedException {
    DriverFactory.setupDriver(DriverName.CHROME);

    WebDriver driver = new ChromeDriver();

    driver.get("http://executeautomation.com/demosite/index.html");

    WebElement menu = driver.findElement(By.id("Automation Tools"));
    WebElement optionParent = driver.findElement(By.id("Selenium"));
    WebElement targetElement = driver.findElement(By.id("Selenium WebDriver"));

    Actions act = new Actions(driver);
    act.moveToElement(menu).perform();

    act.moveToElement(optionParent)
        .click(targetElement)
        .build()
        .perform();

    Thread.sleep(5000);

    driver.close();
  }
}
