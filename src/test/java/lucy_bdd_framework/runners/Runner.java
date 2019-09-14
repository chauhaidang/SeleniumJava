package lucy_bdd_framework.runners;

import com.cucumber.listener.ExtentCucumberFormatter;
import core.helpers.Const;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@CucumberOptions(
        features = Const.TEST_PATH + "/lucy_bdd_framework/features/",
        glue = {"lucy_bdd_framework/steps"},
        monochrome = true,
        tags = {"@Regression, @Functional"},
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber/cucumber.json",
                "com.cucumber.listener.ExtentCucumberFormatter"}
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setUpReport() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
        Date currentDate = new Date();
        String strDate = sdf.format(currentDate);
        String reportFilePath = System.getProperty("user.dir") + "/target/cucumber/extent_" + strDate + ".html";
        File reportFile = new File(reportFilePath);
        ExtentCucumberFormatter.initiateExtentCucumberFormatter(reportFile, false);

        //Load report config
        ExtentCucumberFormatter.loadConfig(new File(Const.TEST_PATH + "/lucy_bdd_framework/configs/extent_report_config.xml"));
        ExtentCucumberFormatter.addSystemInfo("BrowserName", "Chrome");
        ExtentCucumberFormatter.addSystemInfo("Browser Version", "76");
        ExtentCucumberFormatter.addSystemInfo("Selenium Version", System.getProperty("selenium.version"));
    }
}
