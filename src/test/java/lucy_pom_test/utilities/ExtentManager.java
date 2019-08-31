package lucy_pom_test.utilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import core.helpers.Const;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance(){

        if(extent==null){
            //set new extent report
            extent = new ExtentReports(System.getProperty("user.dir")+"/target/surefire-reports/html/extent.html", true, DisplayOrder.OLDEST_FIRST);
            //Load config
            extent.loadConfig(new File(Const.TEST_RESOURCE_PATH + "/extentconfig/lucy_pom_test/ReportsConfig.xml"));
        }
        return extent;
    }

}
