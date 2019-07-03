package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingPopUpWindow {
  public static void main(String[] args){
    DriverFactory.setupDriver(DriverName.CHROME);

    WebDriver driver = new ChromeDriver();

    driver.get("http://executeautomation.com/demosite/index.html");

    driver.findElement(By.linkText("HtmlPopup")).click();

    String parent = driver.getWindowHandle();

    for(String name : driver.getWindowHandles()){
      if(!name.equals(parent)){
        driver.switchTo().window(name);
        driver.findElement(By.id("Initial")).sendKeys("child window");
        driver.findElement(By.id("FirstName")).sendKeys("child window");
        driver.close();
      }
    }

    driver.switchTo().window(parent);
    driver.findElement(By.id("Initial")).sendKeys("parent window");
    driver.findElement(By.id("FirstName")).sendKeys("parent window");
    driver.close();
  }
}
