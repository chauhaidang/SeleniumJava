package CucumberTraining.runners;

import core.helpers.Const;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(//This must be the path count from working directory
        features = Const.MAIN_PATH + "/CucumberTraining/feature/",
        //This glues automatically is searched in classpath because they are all java class, right? So just give the relative path
        glue = {"CucumberTraining/steps"},
        monochrome = true,
        tags = {"@smoke"})
public class testng_runner extends AbstractTestNGCucumberTests {
}
