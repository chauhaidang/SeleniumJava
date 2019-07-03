package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
  public static void setupDriver(DriverName driverName) {
    switch (driverName) {
      case CHROME:
        WebDriverManager.chromedriver().setup();
        break;
      case FIREFOX:
        WebDriverManager.firefoxdriver().setup();
        break;
      default:
        throw new Error("There is no appropriate driver name: " + driverName);
    }
  }
}
