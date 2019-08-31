package lucy_pom_test.listeners;

import com.relevantcodes.extentreports.LogStatus;
import lucy_data_driven_test.utilities.TestUtil;
import lucy_pom_test.base.Page;
import lucy_pom_test.utilities.Utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class POM_Listener extends Page implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //define log for test case
        test.log(LogStatus.PASS, iTestResult.getName().toUpperCase() + " PASSED");
        report.endTest(test);
        report.flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //Add tag for reportng to understand html script
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try {
            Utilities.captureScreenshot();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //TestNG Report and ReportNG
        Reporter.log("<a target=\"_blank\" href="+Utilities.fileName+">Screenshot link</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href="+Utilities.fileName+"><img src="+Utilities.fileName+" height=200 width=200></a>");

        //ExtentReport
        test.log(LogStatus.FAIL, iTestResult.getName().toUpperCase() + " FAILED with exception: "+ iTestResult.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.fileName));
        report.endTest(test); //stop listen to test
        report.flush(); // release holding the report

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //Tell the extent report to start listen to the test
        test = report.startTest(iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
