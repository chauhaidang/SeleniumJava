package lucy_bdd_framework.runners;

import com.cucumber.listener.ExtentCucumberFormatter;
import core.helpers.Const;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

import java.io.File;

@CucumberOptions(
        features = Const.TEST_PATH + "/lucy_bdd_framework/features/",
        glue = {"lucy_bdd_framework/steps"},
        monochrome = true,
        tags = {"@Regression, @Functional"},
        plugin = {"json:target/cucumber/cucumber.json", "pretty", "html:target/cucumber", "com.cucumber.listener.ExtentCucumberFormatter"}
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setUpReport() {
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
//        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
//        Date curDate = new Date();
//        String strDate = sdf.format(curDate);
        String fileName = System.getProperty("user.dir") + "/target/cucumber/extent.html";
        File newFile = new File(fileName);
        ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile, true);

        //Load report config
        ExtentCucumberFormatter.loadConfig(new File(Const.TEST_PATH + "/lucy_bdd_framework/configs/extent_report_config.xml"));
        ExtentCucumberFormatter.addSystemInfo("BrowserName", "Chrome");
        ExtentCucumberFormatter.addSystemInfo("Browser Version", "76");
        ExtentCucumberFormatter.addSystemInfo("Selenium Version", "Not provided yet");
    }
}
