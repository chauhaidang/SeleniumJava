package lucy_data_driven_test.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import lucy_data_driven_test.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends BaseTest {

    public static String fileName;

    public static void captureScreenshot() throws IOException {
        Date d = new Date();
        fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/test-output/html/" + fileName));
    }

    /**
     * Get data provider from excel
     * @param sheetName
     * @return Object[][]
     */
    public static Object[][] getData(String sheetName) {
        int rowNum = excel.getRowCount(sheetName);
        int colNum = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rowNum - 1][colNum];

        for (int rows = 2; rows <= rowNum; rows++) {
            for (int cols = 0; cols < colNum; cols++) {

                data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);

            }
        }
        return data;
    }
}
