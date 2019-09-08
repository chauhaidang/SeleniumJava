package lucy_pom_factory_test.listeners;

import com.relevantcodes.extentreports.LogStatus;
import lucy_pom_factory_test.base.Page;
import lucy_pom_factory_test.utilities.Utilities;
import org.testng.*;

import java.io.IOException;

public class CustomListeners extends Page implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {

    }

    @Override
    public void onFinish(ISuite iSuite) {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //Tell the extent report to start listen to the test
        test = rep.startTest(iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //define log for test case
        test.log(LogStatus.PASS, iTestResult.getName().toUpperCase() + " PASSED");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //Add tag for reportng to understand html script
        try {
            Utilities.captureScreenshot();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.error("Can not capture screenshot at test method " + iTestResult.getName().toUpperCase() + " due to " + e.getMessage());
            e.printStackTrace();
        }

        //TestNG Report and ReportNG
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("<a target=\"_blank\" href=" + Utilities.fileName + ">Screenshot link</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=" + Utilities.fileName + "><img src=" + Utilities.fileName + " height=200 width=200></a>");

        //ExtentReport
        test.log(LogStatus.FAIL, iTestResult.getName().toUpperCase() + " FAILED with exception: \n" + iTestResult.getThrowable());
        test.log(LogStatus.INFO, test.addScreenCapture(Utilities.fileName)); //This should not be a failure but information
        rep.endTest(test); //stop listen to test
        rep.flush(); // release holding the report
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //Add custom email here or whatever we want
    }
}
