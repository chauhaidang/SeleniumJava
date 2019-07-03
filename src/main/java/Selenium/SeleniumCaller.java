package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumCaller {
  public static void main(String[] args){
    DriverFactory.setupDriver(DriverName.CHROME);

    WebDriver driver = new ChromeDriver();

    driver.get("http://google.com");

    WebElement element = driver.findElement(By.name("q"));

    element.sendKeys("Hello");

    driver.close();


  }
}
