package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ImplicitAndExplicitWait {


  /**
   * It is the custom one. It will be used if we want the execution to wait for some time until some condition achieved.
   * @param driver
   * @param text
   */
  public static void ExplicitWait(WebDriver driver, String text){
    (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text)));
  }

  /**
   * Once you declared implicit wait it will be available for the entire life of web driver instance (driver).
   * By default the value will be 0. If you set a longer default, then the behavior will poll(search) the DOM on a periodic time 10 second e.g
   * @param driver
   */
  public static void ImplicitWait(WebDriver driver){
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
}
