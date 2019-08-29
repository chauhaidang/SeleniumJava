package lucy_pom_test.utilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import core.helpers.Const;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance(){

        if(extent==null){
            extent = new ExtentReports(System.getProperty("user.dir")+"/target/surefire-report/html/extent.html", true, DisplayOrder.OLDEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir")+ Const.TEST_RESOURCE_PATH + "/extentconfig/lucy_pom_test/ReportsConfig.xml"));
        }
        return extent;
    }

}
