package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
  public static void main(String[] args){
    DriverFactory.setupDriver(DriverName.CHROME);

    WebDriver driver = new ChromeDriver();

    driver.get("http://executeautomation.com/demosite/Dragging.html");

    WebElement fromElement = driver.findElement(By.id("item1"));
    WebElement toElement = driver.findElement(By.id("item4"));

    Actions act = new Actions(driver);
    act.dragAndDrop(fromElement, toElement).perform();

    driver.close();
  }

}
