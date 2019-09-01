package lucy_pom_test.utilities;

import lucy_data_driven_test.base.BaseTest;
import lucy_pom_test.base.Page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

public class Utilities extends Page {

    public static String fileName;

    public static void captureScreenshot() throws IOException {
        Date d = new Date();
        fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + fileName));
    }

    /**
     * Get data provider from excel
     * @param
     * @return Object[][]
     */
    @DataProvider(name="dp")
    public Object[][] getData(Method m) {

        String sheetName = m.getName();
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][1];

        Hashtable<String,String> table = null;

        for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

            table = new Hashtable<String,String>();

            for (int colNum = 0; colNum < cols; colNum++) {

                // data[0][0]
                table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;
            }

        }

        return data;

    }


    public static boolean isTestRunnable(String testName, ExcelReader excel){

        String sheetName="test_suite";
        int rows = excel.getRowCount(sheetName);


        for(int rNum=2; rNum<=rows; rNum++){

            String testCase = excel.getCellData(sheetName, "TCID", rNum);

            if(testCase.equalsIgnoreCase(testName)){

                String runmode = excel.getCellData(sheetName, "RunMode", rNum);

                if(runmode.equalsIgnoreCase("Y"))
                    return true;
                else
                    return false;
            }


        }
        return false;
    }
}
