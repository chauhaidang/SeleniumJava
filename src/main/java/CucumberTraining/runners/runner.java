package CucumberTraining.runners;

import core.helpers.Const;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = Const.MAIN_PATH + "/CucumberTraining/feature/",
        glue = {"CucumberTraining.steps"})
public class runner {
}
