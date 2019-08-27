package core.lucy_kdd_core;

import core.helpers.Log;
import core.helpers.driverhelper.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static core.lucy_kdd_core.TestRunner.OR;
import static core.lucy_kdd_core.TestRunner.bResult;

public class ActionKeywords {
    private static WebDriver driver;

    public static void openBrowser(String object){
        try{
            Log.info("Setup driver");
            DriverManager.setupDriver("chrome");
            Log.info("Initial driver");
            driver = new ChromeDriver();
            Log.info("Set implicit wait for driver with 10 seconds timeout");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        catch (Exception e){
            //This is to print the logs - Method Name & Error description/stack
            Log.error("Not able to open browser --- \n" + e.getMessage());
            bResult=false;
        }
    }

    public static void navigate(String object){
        try{
            Log.info("Navigate to url: https://tiki.vn");
            driver.get("https://tiki.vn/");
        }
        catch (Exception e){
            Log.error("Not able to navigate to Url --- \n" + e.getMessage());
            bResult=false;
        }
    }

    public static void click(String object){
        try {
            Log.info("click on element: " + OR.getProperty(object));
            driver.findElement(By.xpath(OR.getProperty(object))).click();
            Thread.sleep(2000);
        }
        catch (Exception e){
            Log.error("Not able to click on elemen --- \n" + e.getMessage());
            bResult = false;
        }
    }

    public static void inputToEmail(String object) {
        try {
            Log.info("Send key to element: " + OR.getProperty(object));
            driver.findElement(By.xpath(OR.getProperty(object))).sendKeys("chauhaidang1testing@gmail.com");
        }
        catch (Exception e){
            Log.error("Not able to input to Email textbox --- \n" + e.getMessage());
            bResult = false;
        }
    }
    public static void inputToPassword(String object) {
        try {
            Log.info("Send key to element: "+ OR.getProperty(object));
            driver.findElement(By.xpath(OR.getProperty(object))).sendKeys("123456789");
            Thread.sleep(2000);
        }
        catch (Exception e){
            Log.error("Not able to input to Password textbox --- \n" + e.getMessage());
            bResult = false;
        }
    }

    public static void closeBrowser(String object){
        try{
        Log.info("Close the browser");
        driver.quit();
        }
        catch (Exception e) {
            Log.error("Not able to close the browser --- \n" + e.getMessage());
            bResult = false;
        }
    }

}
