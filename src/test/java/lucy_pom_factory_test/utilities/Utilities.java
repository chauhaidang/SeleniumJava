package lucy_pom_factory_test.utilities;

import lucy_pom_factory_test.base.Page;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

import static core.helpers.Utilities.captureScreenshotSupport;
import static core.helpers.Utilities.getDataSupport;

public class Utilities extends Page {

    public static String fileName;

    public static void captureScreenshot() throws IOException {
        fileName = captureScreenshotSupport(driver, "/target/surefire-reports/html/");
    }

    /**
     * Get data provider from excel
     * @param
     * @return Object[][]
     */
    @DataProvider(name="dp")
    public Object[][] getData(Method m) {
        return getDataSupport(m, excel);
    }
}
