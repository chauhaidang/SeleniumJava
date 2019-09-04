package lucy_pom_factory_test.utilities;

import core.helpers.ExcelReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;
import static core.helpers.Utilities.*;

public class Utilities {

    public static String fileName;

    public static void captureScreenshot(WebDriver driver) throws IOException {
        captureScreenshotSupport(driver, "/target/surefire-reports/html/");
    }

    /**
     * Get data provider from excel
     * @param
     * @return Object[][]
     */
    @DataProvider(name="dp")
    public Object[][] getData(Method m) {
        return getDataSupport(m, new ExcelReader(""));
    }
}
