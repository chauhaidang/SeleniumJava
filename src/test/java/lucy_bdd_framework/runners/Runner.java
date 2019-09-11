package lucy_bdd_framework.runners;


import com.cucumber.listener.ExtentCucumberFormatter;
import core.helpers.Const;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        //This must be the path count from working directory
        features = Const.TEST_PATH + "/lucy_bdd_framework/features/",
        //This glues automatically is searched in classpath because they are all java class, right? So just give the relative path
        glue = {"lucy_bdd_framework/steps"},
        monochrome = true,
        //tags = {"@smoke, @regression"},
        plugin = {"pretty", "html:target/cucumber", "com.cucumber.listener.ExtentCucumberFormatter"}
)
public class Runner {
    @BeforeClass
    public static void setUpReport() {
        ExtentCucumberFormatter.initiateExtentCucumberFormatter();

        //Load report config
        ExtentCucumberFormatter.loadConfig(new File(Const.TEST_PATH + "/lucy_bdd_framework/extent_report_config.xml"));
        ExtentCucumberFormatter.addSystemInfo("BrowserName", "Chrome");
        ExtentCucumberFormatter.addSystemInfo("Browser Version", "76");
        ExtentCucumberFormatter.addSystemInfo("Selenium Version", "Not provided yet");

    }
}
